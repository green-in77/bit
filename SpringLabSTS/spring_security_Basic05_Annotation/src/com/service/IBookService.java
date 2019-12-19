package com.service;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import com.bean.Book;

public interface IBookService {

	@PreAuthorize("hasRole('ROLE_WRITE')") //method 실행 전 권한검사
	void addBook(Book book);
	
	
	@PostAuthorize("returnObject.owner == authentication.name") //함수가 끝나고 난 후 return 할때 제어가능
	Book getBook();
	/*
	   현재 로그인한 계정 : hong 
	   Book b = new Book("구운몽","kglim")
	   
	   "kglim" != "hong" > false 접근권한 예외 
	   return  b; 
	*/
	
	/*
	 Book bo = new Book("홍길동전","kglim")
	 (bo.kglim == "kglim")
	 delelteBook(bo)
	 */
	
	@PreAuthorize("#book.owner == authentication.name") //method 태우기 전 객체 검사 가능
	void deleteBook(Book book);
}