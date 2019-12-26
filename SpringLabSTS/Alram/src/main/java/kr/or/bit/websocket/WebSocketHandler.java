package kr.or.bit.websocket;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import kr.or.bit.dto.Message;
import kr.or.bit.service.MemberService;

@Configuration
public class WebSocketHandler extends TextWebSocketHandler{
	
	@Autowired
	private MemberService service;
	
	private static Map<String, WebSocketSession> users = new HashMap<String, WebSocketSession>();

	private void log(String msg) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String date = simple.format(new Date());
		System.out.println(date + " : " + msg);
	}
	
	//연결
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log(session.getPrincipal().getName() + " 접속");
		//users.put(session.getId(), session); //userid 와 session 저장
		users.put(session.getPrincipal().getName(), session); //userid 와 session 저장
	}	
	
	//연결해제
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
		log(session.getPrincipal().getName() + " 해제");
		//users.remove(session.getId()); //연결해제된 id 삭제
		users.remove(session.getPrincipal().getName()); //연결해제된 id 삭제
	}
	
	//데이터 전송
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
		
		if(message.getPayload().equals("login") || message.getPayload().equals("view")) {
			String userid = session.getPrincipal().getName();
			
			int result = service.getmsgcount(userid);
			
			if(users.containsKey(userid)) {
				TextMessage msg = new TextMessage("수신된 쪽지 : " + result + "건");
				users.get(userid).sendMessage(msg);
				log(userid + " / " + message.getPayload() + " / " + msg.getPayload());
			}
		}else {
			String fromid = message.getPayload().split(",")[1];
			Message savemsg = new Message(message.getPayload().split(",")[0], message.getPayload().split(",")[1], message.getPayload().split(",")[2]);
			service.insertMessage(savemsg);
			
			int result = service.getmsgcount(fromid);
			if(users.containsKey(fromid)) {
				TextMessage msg = new TextMessage("수신된 쪽지 : " + result + "건");
				users.get(fromid).sendMessage(msg);
				log(fromid + " / " + message.getPayload() + " / " + msg.getPayload());
			}
			System.out.println("fromid : " + fromid);
			System.out.println(message.getPayload());
		}
		
	}
	
	//연결에 문제 발생시
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception{
		log(session.getPrincipal().getName() + " / " + exception.getMessage());
	}

}
