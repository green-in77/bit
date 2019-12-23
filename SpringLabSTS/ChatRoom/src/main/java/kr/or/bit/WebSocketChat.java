package kr.or.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@ServerEndpoint(value="/chat.do/{roomName}") // /echo.do 라는 url 요청을 통해 웹소켓에 들어가겠다
public class WebSocketChat {
	
	private static List<String> roomsList = new ArrayList<String>();
	private static Map<String, List<Session>> rooms = new HashMap<String, List<Session>>();
	
	@RequestMapping(value="/index.do")
	public String getHomeViewPage() {
		return "main";
	}
	
	@RequestMapping(value="/chatAll.do")
	public String getChatViewPage(Model model) {
		System.out.println(rooms.containsKey("all"));
		
		if(!rooms.containsKey("all")) {
			roomsList.add("all");
		}
		model.addAttribute("roomList", roomsList);
		return "chatAll";
	}
	
	@RequestMapping(value = "/create.do")
	public String createRoom(String roomName, Model model) {
		System.out.println(rooms.containsKey(roomName));
		
		if(!rooms.containsKey(roomName)) {
			roomsList.add(roomName);
		}
		
		model.addAttribute("roomList", roomsList);
		return "chatAll";
	}
	
	@OnOpen //클라이언트가 웹소켓에 문제없이 들어왔을때 실행
	public void onOpen(Session session, @PathParam("roomName") String roomName) {
		System.out.println("Open session id :" + session.getId());
		
		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText(roomName + "연결되었습니다.");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		if(!rooms.containsKey(roomName)) {//map에 방이름을 찾아 list 가 없으면
			rooms.put(roomName, new ArrayList<Session>()); //session list 생성
		}
		
		session.getUserProperties().putIfAbsent("roomName", roomName); //유저설정 셋팅
		rooms.get(roomName).add(session); //해당 방의 session list 에 session 추가
		
		System.out.println("rooms : " + roomName + " / 인원수 : " + rooms.get(roomName).size());
	}
	
	//메시지 보낸 자신을 제외한 나머지 연결된 세션에 메시지를 보냄
	private void sendAllSessionToMessage(Session self, String message) {
		try {
			String room = (String) self.getUserProperties().get("roomName");
			System.out.println("room : " + room);
			
			for(Session session : rooms.get(room)) {
				if(!self.getId().equals(session.getId())) {
					session.getBasicRemote().sendText(message.split(",")[1] + " : " + message.split(",")[0]);
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@OnMessage //메시지가 들어왔을때 실행
	public void onMessage(String message, Session session) {
		System.out.println("Message From " + message.split(",")[1] + ": " + message.split(",")[0]);
		
		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("to : " + message);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		sendAllSessionToMessage(session, message);
	}
	
	@OnError
	public void onError(Throwable e, Session session) {
		
	}
	
	@OnClose //클라이언트와 웹소켓 연결이 끊기면 실행
	public void onClose(Session session) {
		System.out.println("Session " + session.getId() + "접속종료");
		String room = (String) session.getUserProperties().get("roomName");
		rooms.get(room).remove(session);
	}
}
