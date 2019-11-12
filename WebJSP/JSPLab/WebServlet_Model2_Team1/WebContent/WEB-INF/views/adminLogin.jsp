<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Admin Login</title>
       
   <c:import url="../common/Top.jsp" />
    
    <div class="d-flex align-items-stretch">

    <c:import url="../common/Left.jsp" />
    
      <div class="page-holder w-100 d-flex flex-wrap">
      
		<!-- 여기부터 -->
		<div class="container-fluid px-xl-5">
        	<div class="row">
				<div class="col-lg-12 table-padding">
					<div class="card mb-5 mb-lg-0">         
						<div class="card-header text-center">
							<h5>Admin Login</h5>
						</div>
						<div class="card-body table-padding text-center">
				        	<form id="loginForm" action="adminLoginOk.do" class="mt-4" method="post">
				              <div class="form-group mb-4">
				                <input type="text" name="userid" placeholder="userid" class="form-control border-0 shadow form-control-lg">
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
      	<!-- 여기까지-->
      	
        <c:import url="../common/Bottom.jsp" />   