package com.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.model.Photo;

@Controller
@RequestMapping("/image/upload.do") //get 또는 post 에 따라서 요청 처리
public class ImageController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "image/image";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(Photo photo, HttpServletRequest request) throws Exception{
		/*
		1. Photo DTO 타입으로 받기
			1.1 자동화 : name == member field
		 	1.2 submit(Photo photo 자동화
		 		Photo photo = new Photo;
		 		photo.setName("");
		 		photo.setAge();
		 		photo.segFile();
		 		**setImage 는 자동주입 되지 않음 : image 변수 없고, image는 file 에서 추출해서 직접 주입해야 한다.
		 		
		 		별도의 추가작업 : 원본파일이름, 파일크기, 저장파일이름 
		 			코드작업
		*/
		CommonsMultipartFile imagefile = photo.getFile();
		
		System.out.println(imagefile.getName());
		System.out.println(imagefile.getOriginalFilename()); //원본파일명
		System.out.println(imagefile.getContentType()); //파일타입
		System.out.println(imagefile.getBytes().length); //파일크기
		
		//POINT : DB에 파일명을 저장할 수 있다.
		photo.setImage(imagefile.getName());
		
		//실제 파일 업로드(write 작업 : 웹서버의 특정 경로에 file write)
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload"); //서버의 실 경로
		//C:\\SmartWeb\\Spring\\SpringLabs\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\SpringMVC_Basic03_Annotation\\upload
		
		String fpath = path + "\\" + filename;
		//C:\\SmartWeb\\Spring\\SpringLabs\\....\\upload\\a.jpg
		
		FileOutputStream fs = new FileOutputStream(fpath);
		fs.write(imagefile.getBytes());
		fs.close();
		/////////////////////////////////////////////////////////////////////////////////
		//이후 DB저장 DAO 만들어서 insert..
		
		return "image/image";
	}
}
