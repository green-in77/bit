package kr.or.bit.dto;

import java.util.Map;

import org.springframework.web.socket.WebSocketSession;

public class ChatInfo {
	private Map<String, WebSocketSession> users; //채팅방 참여자
	private Map<String, Map<String, WebSocketSession>> rooms; //채팅방 + 참여자
	
	public Map<String, WebSocketSession> getUsers() {
		return users;
	}
	public void setUsers(Map<String, WebSocketSession> users) {
		this.users = users;
	}
	public Map<String, Map<String, WebSocketSession>> getRooms() {
		return rooms;
	}
	public void setRooms(Map<String, Map<String, WebSocketSession>> rooms) {
		this.rooms = rooms;
	}
	
}
