package com.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/*
create table photo(
	varchar2(10) name,
	number age,
	varchar2(100) image --업로드한 파일명 : a.jpg, b.png
)
*/

public class Photo {
	private String name;
	private int age;
	private String image; //업로드한 파일 객체에서 별도로 추출해야한다.. (setter 설정) 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	//POINT <input type="file" name="file"> 변수명과 name 동일해야함
	private CommonsMultipartFile file; //업로드한 파일이 byte가 통채로 들어옴(DB에는 없음)
	//해당 파일에서 업로드 명 등 뽑아내서 DB에 저장하는 것.
	
	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
}
