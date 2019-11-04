<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate(); //세션삭제
	response.sendRedirect("login.jsp");
%>