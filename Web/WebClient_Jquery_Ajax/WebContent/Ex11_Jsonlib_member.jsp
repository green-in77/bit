<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="kr.or.bit.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member member = new Member();
	
	//객체 1개일때 JSONObject
	JSONObject obj = JSONObject.fromObject(member);
	//json 자동 변환
	//{"address":"서울시 강남구","admin":"1","password":"1004","username":"bit"}
%>
<%= obj %>
<hr>
<%
	List<Member> memberlist = new ArrayList<>();
	memberlist.add(new Member("hong","1004","서울시 강남구","0"));
	memberlist.add(new Member("kim","1004","서울시 양천구","1"));
	memberlist.add(new Member("park","1004","경기도 성남시","1"));
	
	//[{},{},{}]]
	//객체 여러개일때 JSONArray
	JSONArray objarray = JSONArray.fromObject(memberlist);
%>

<%= objarray%>