<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
       
   <c:import url="../common/Top.jsp" />
    
    <div class="d-flex align-items-stretch">
    
   
    <c:import url="../common/Left.jsp" />
    
      <div class="page-holder w-100 d-flex flex-wrap">
      
      	<!-- 여기부터 -->
      	 <div class="container-fluid px-xl-5">
        	
        	<div class="row">
				<div class="col-lg-12 data-padding">
					<div class="card mb-5 mb-lg-0">         
						<div class="card-header text-center">
							<h6>Edit</h6>
						</div>
						<div class="card-body body-padding text-center">
        					<c:set var="emp" value="${requestScope.emp}"/>
        					
				        	<form id="editForm" action="empEditOk.do" class="mt-4" method="post">
				              
				              <div class="form-group mb-4"><!-- 사원명 -->
				                <input type="text" name="ename" id='ename' value="${emp.ename}" class="form-control border-0 shadow form-control-lg" readonly>
				              </div>
				              
				              <div class="form-group mb-4"><!-- 사번 -->
				                <input type="text" name="empno" id='empno' value="${emp.empno}" class="form-control border-0 shadow form-control-lg" readonly>
				              </div>
				              
				              <div class="form-group mb-4"><!-- 직종 -->
				                <input type="text" name="job" id='job' value="${emp.job}" class="form-control border-0 shadow form-control-lg">
				              </div>
				              
				              <div class="form-group mb-4"><!-- 사수 -->
				                <input type="text" name="mgr" id='mgr' value="${emp.mgr}" class="form-control border-0 shadow form-control-lg text-violet">
				              </div>
				              
				              <div class="form-group mb-4"><!-- 입사일 -->
				                <input type="text" name="hiredate" id='hiredate' value="${emp.hiredate}" class="form-control border-0 shadow form-control-lg" readonly>
				              </div>
				              
				              <div class="form-group mb-4"><!-- 급여 -->
				                <input type="text" name="sal" id='sal' value="${emp.sal}" class="form-control border-0 shadow form-control-lg text-violet">
				              </div>
				              
				              <div class="form-group mb-4"><!-- 수당 -->
				                <input type="text" name='comm' id='comm' value="${emp.comm}" class="form-control border-0 shadow form-control-lg text-violet">
				              </div>
				              
				              <div class="form-group mb-4"><!-- 부서번호 -->
				                <input type="text" name='deptno' id='deptno' value="${emp.deptno}" class="form-control border-0 shadow form-control-lg text-violet">
				              </div>
				              
				              <button type="submit" id="submit" class="btn btn-primary shadow px-5">Edit</button>
				              <button type="button" id="button" class="btn btn-primary shadow px-5" onclick="location.href='empList.do'">List</button>
				        	</form>
        				</div>
        			</div>
        		</div>
        	</div>
        </div>
		<!-- 여기까지 -->
	
        <c:import url="../common/Bottom.jsp" />
           