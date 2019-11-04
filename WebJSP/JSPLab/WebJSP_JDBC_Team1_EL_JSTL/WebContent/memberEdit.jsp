<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="common/Admin.jsp"></c:import>

<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");


	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		conn = Singleton_Helper.getConnection("oracle");
		String sql = "select id,pwd,name,age,trim(gender),email from koreamember where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		rs.next();
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Edit</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
	    $(function(){
	        let idpw_pattern = /^[a-z0-9_]{4,20}$/;
	        //a~z,0~9까지 입력가능 4자~20자 이내로
	        let email_pattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	         //0부터9a부터zA부터Z까지 (-, _, . 가 있어도 되고 없어도 되고, 0부터9a부터zA부터Z까지)반복횟수 상관없이가능
	         //@기호포함  (-, _, . 가 있어도 되고 없어도 되고, 0부터9a부터zA부터Z까지)반복횟수 상관없이가능 .기호포함 2자~3자 이내 대소문자 구분안함
	        
	        let pw_check = false;
	        let pwck_check = false;
	        let email_check = false;
	
	        //PW확인 userPass : keyup 
	        $('#pwd').keyup(function(){
	            if(idpw_pattern.test($(this).val()) != true ){
	                $('#sppw').text("패스워드가 조건에 일치하지 않습니다.");
	                pw_check=false;
	            }else{
	                $('#sppw').text("패스워드가  조건과 일치합니다.");
	                pw_check=true;
	            }
	        });
	        
	        //PW입력동일 확인 userPassCheck : keyup
	        $('#pwdck').keyup(function(){
	            if( $('#pwd').val() != $('#pwdck').val()){
	                $('#sppwck').text("입력한 비밀번호와 일치하지 않습니다.");
	                pwck_check=false;
	            }else{
	                $('#sppwck').text("입력한 비밀번호와 일치합니다.");
	                pwck_check=true;
	            }
	        });
	        
	        //email확인  userEmail : keyup
	        $('#email').keyup(function(){
	            if(email_pattern.test($(this).val()) != true){
	                $('#spemail').text("이메일 형식에 맞지 않습니다.");
	                email_check=false;
	            }else{
	                $('#spemail').text("이메일 형식에 맞습니다.");
	                email_check=true;
	            }
	        });
	        
	        
	        $('#submit').click(function(){
	            /* let Ssn1_check = $('#userSsn1').val()!="";
	            let Ssn2_check = $('#userSsn2').val()!="";
	            let ZipCode_check = $('#userZipCode').val()!=""; */
	            let name_check = false;
	        	let age_check = false;
 	
		    	if ($('#age').val() == "") { // 나이 검사
		    		age_check = false;
		    	}else{
		    		age_check = true;
		    	}
		        
	            
	            let issubmit = pw_check && pwck_check && email_check && age_check;
	            console.log(issubmit);
	            
	            if (!issubmit){
	                alert("입력이 되지 않았습니다.");    
	            }else{
	                issubmit = true;
	            }
	            
	          return issubmit;
	        });
	    });
	</script>
	<c:import url="common/Top.jsp"></c:import>
	
    <div class="d-flex align-items-stretch">
    
    <c:import url="common/Left.jsp"></c:import>
    
      <div class="page-holder w-100 d-flex flex-wrap">
        <div class="container-fluid px-xl-5">
        	
        	<div class="row">
				<div class="col-lg-12 data-padding">
					<div class="card mb-5 mb-lg-0">         
						<div class="card-header text-center">
							<h6>Edit</h6>
						</div>
						<div class="card-body body-padding text-center">
        					<c:set var="rs" value="<%=rs %>"/>
        					
				        	<form id="editForm" action="memberEditok.jsp" class="mt-4" method="post">
				              <div class="form-group mb-4"><!-- ID -->
				             <%--  <c:forEach var ="data" items="${rs.rows}"> --%>
				             	
				                <input type="text" name="id" id='id' value="${rs.getString(1)}" class="form-control border-0 shadow form-control-lg" readonly>
				              </div>
				              
				              <div class="form-group mb-4"><!-- pw -->
				                <input type="password" name="pwd" id='pwd' value="${rs.getString(2)}" class="form-control border-0 shadow form-control-lg text-violet">
				                <span id=sppw></span>
				              </div>
				              
				              <div class="form-group mb-4"><!-- pw체크 -->
				                <input type="password" id='pwdck' value="${rs.getString(2)}" class="form-control border-0 shadow form-control-lg text-violet">
				                <span id=sppwck></span>
				              </div>
				              
				              <div class="form-group mb-4"><!-- 이름 -->
				                <input type="text" name="name" id='name' value="${rs.getString(3)}" class="form-control border-0 shadow form-control-lg" readonly>
				              </div>
				              
				              <div class="form-group mb-4"><!-- 나이-->
				                <input type="text" name="age" id='age' value="${rs.getString(4)}" class="form-control border-0 shadow form-control-lg text-violet">
				              </div>
				              
				              <div class="form-group mb-4"><!-- 성별-->
				              	<div class="row">
				              		<div class="col-lg-6">
				                		<input type="radio" name="gender" id="gender" value="여" <c:if test="${rs.getString(5) == '여'}"> checked  </c:if>  >여자
				                	</div>
				                	<div class="col-lg-6">							
				                		<input type="radio" name="gender" id="gender" value="남" <c:if test="${rs.getString(5) == '남' }"> checked </c:if>  >남자
				                	</div>
				                </div>
				              </div>
				              
				              <div class="form-group mb-4"><!-- email -->
				                <input type="text" name='email' id='email' value="${rs.getString(6)}" class="form-control border-0 shadow form-control-lg text-violet">
				                <span id=spemail></span>
				              </div>
				              <button type="submit" id="submit" class="btn btn-primary shadow px-5">Edit</button>
				              <button type="button" id="button" class="btn btn-primary shadow px-5" onclick="location.href='memberlist.jsp'">List</button>
				        	</form>
        				</div>
        			</div>
        		</div>
        	</div>

<%	
	} catch(Exception e){
		
	} finally{
		Singleton_Helper.close(rs);
		Singleton_Helper.close(pstmt);
	}
%>
        </div>
        <c:import url="common/Bottom.jsp"></c:import>
        