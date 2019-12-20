package kr.or.bit.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.bit.dto.Roomdto;

@Controller
public class ChatController {

	@RequestMapping("/chat")
	public String chat() {
		return "chat-ws"; 
	}
	
	private void roomLog(String status) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String date = simple.format(new Date());
		System.out.println(date + " : " + status);
	}
	
	//전체채팅방
	@RequestMapping("/chatsock")
	public String chat_sock(Model model) {
		roomLog("전체 채팅방");
		model.addAttribute("room", "all");
		
		return "chat-sockjs"; 
	}
	
	
	//방만들기
	public String createRoom(Roomdto room, Model model) {
		roomLog("방만들기");
		
		return "chat-sockjs";
	}
	
	//방이동
	public String moveRoom() {
		
		return "";
	}
	
}
