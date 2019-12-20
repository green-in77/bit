package kr.or.bit.socket;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import kr.or.bit.dto.ChatInfo;

@Configuration
public class ChatWebSocketHandler extends TextWebSocketHandler{
	
	private Map<String, WebSocketSession> users = new HashMap<String, WebSocketSession>(); //채팅방 참여자

	private void log(String msg) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String date = simple.format(new Date());
		System.out.println(date + " : " + msg);
	}
	
	//연결
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		Principal principal = session.getPrincipal();
		log(principal.getName() + "연결");
		
		users.put(principal.getName(), session);
		
		//연결되면 session ID와 session 을 map에 저장
	}
	
	//연결해제
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
		Principal principal = session.getPrincipal();
		
		log(principal.getName() + "연결종료");
		users.remove(principal.getName());
	}
	
	//데이터 전송
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
		Principal principal = session.getPrincipal();
		log(principal.getName() + "수신메시지 : " + message.getPayload());
		
		//메시지가 수신되면 map 에 저장된 접속중인 모든 클라이언트에게 메시지 전송
		for(WebSocketSession s : users.values()) {
			Principal principal_users = s.getPrincipal();
			s.sendMessage(message);
			log(principal_users.getName() + "메시지발송 " + message.getPayload());
		}
	}
	
	//연결에 문제 발생시
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception{
		Principal principal = session.getPrincipal();
		
		log(principal.getName() + "예외발생 : " + exception.getMessage());
	}
	
}
