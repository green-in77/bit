<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Data</title>
    
	<c:import url="common/Top.jsp"></c:import>
	
    <div class="d-flex align-items-stretch">
    
    <c:import url="common/Left.jsp"></c:import>
    
      <div class="page-holder w-100 d-flex flex-wrap">
        <div class="container-fluid px-xl-5">
        <%
        	request.setCharacterEncoding("UTF-8");
    		String id = request.getParameter("id");
    		
    		Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = Singleton_Helper.getConnection("oracle");
				String sql = "select * from koreamember where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				rs.next();
		%>
			<div class="row">
				<div class="col-lg-12 data-padding">
					<div class="card mb-5 mb-lg-0">         
						<div class="card-header text-center">
							<h6>Data</h6>
						</div>
						<div class="card-body body-padding text-center">
        					  <c:set var="rs" value="<%=rs%>" />      	
				              <div class="form-group mb-4"><!-- ID -->
				                <input type="text" name="id" id='id' value='${rs.getString("id")}' class="form-control border-0 shadow form-control-lg" readonly>
				              </div>
				              
				              <div class="form-group mb-4"><!-- pw -->
				                <input type="text" name="pwd" id='pwd' value='${rs.getString("pwd")}' class="form-control border-0 shadow form-control-lg" readonly>
				              </div>

				              <div class="form-group mb-4"><!-- 이름 -->
				                <input type="text" name="name" id='name' value='${rs.getString("name")}' class="form-control border-0 shadow form-control-lg" readonly>
				              </div>
				              
				              <div class="form-group mb-4"><!-- 나이-->
				                <input type="text" name="age" id='age' value='${rs.getInt("age")}' class="form-control border-0 shadow form-control-lg" readonly>
				              </div>
				              
				              <div class="form-group mb-4"><!-- 성별-->
				              	<div class="row">
				              		<div class="col-lg-6">
				                		<input type="radio" name="gender" id="gender" value="여" <c:if test="${rs.getString(5).trim()=='여'}"> checked </c:if>>여자
				                	</div>
				                	<div class="col-lg-6">
				                		<input type="radio" name="gender" id="gender" value="남" <c:if test="${rs.getString(5).trim()=='남'}"> checked </c:if>>남자
				                	</div>
				                </div>
				              </div>
				              
				              <div class="form-group mb-4"><!-- email -->
				                <input type="text" name='email' id='email' value='${rs.getString("email")}' class="form-control border-0 shadow form-control-lg" readonly>
				              </div>
				              
				              <div class="form-group mb-4"><!-- email -->
				                <input type="text" name='ip' id='ip' value='${rs.getString("ip")}' class="form-control border-0 shadow form-control-lg" readonly>
				              </div>
				              
				              <button type="button" id="button" class="btn btn-primary shadow px-5" onclick="location.href='memberlist.jsp'">List</button>
				        	
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
        
        <jsp:include page="common/Bottom.jsp"></jsp:include>
        