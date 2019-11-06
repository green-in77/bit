<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("userid") != null){ //값이 있으면
		out.print("<script>");
			out.print("alert('["+session.getAttribute("userid")+"]님 이미 로그인 되어있습니다 :)');");	
			out.print("location.href='index.jsp'");	
		out.print("</script>");
	}
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login</title>
    	
	<jsp:include page="common/Top.jsp"></jsp:include>
	
    <div class="d-flex align-items-stretch">
    
    <jsp:include page="common/Left.jsp"></jsp:include>
    
      <div class="page-holder w-100 d-flex flex-wrap">
        <div class="container-fluid px-xl-5">
        	<div class="row">
				<div class="col-lg-12 table-padding">
					<div class="card mb-5 mb-lg-0">         
						<div class="card-header text-center">
							<h5>Login</h5>
						</div>
						<div class="card-body table-padding text-center">
        
				        	<form id="loginForm" action="loginok.jsp" class="mt-4" method="post">
				              <div class="form-group mb-4">
				                <input type="text" name="id" placeholder="Id" class="form-control border-0 shadow form-control-lg">
				              </div>
				              <div class="form-group mb-4">
				                <input type="password" name="pwd" placeholder="Password" class="form-control border-0 shadow form-control-lg text-violet">
				              </div>
				              <button type="submit" class="btn btn-primary shadow px-5">Login</button>
				        	</form>
				       	</div>
        			</div>
        		</div>
        	</div>
                
        </div>
        
        <jsp:include page="common/Bottom.jsp"></jsp:include>
        