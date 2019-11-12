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
               <div class="col-lg-12 table-padding">
                  <div class="card mb-5 mb-lg-0">         
                     <div class="card-header">
                        <h2 class="h6 mb-0 text-uppercase">Emp List</h2>
                     </div>
                  <div class="card-body">
                     <p class="text-gray">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사원명(사번)&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;부서명&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;사수&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;입사일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;급여&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;수당&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;부서번호</p>
                     <form id="searchForm" class="ml-auto d-none d-lg-block mb-3" action="memberSearch.jsp" method="post">
                             <div class="form-group position-relative mb-0">
                                  <button type="submit" style="top: -3px; left: 0;" class="position-absolute bg-white border-0 p-0">
                                  <i class="o-search-magnify-1 text-gray text-lg"></i></button>
                                  <input type="search" name="search" placeholder="회원명 Search ..." class="form-control form-control-sm border-0 no-shadow pl-4">
                             </div>
                        </form>
         			
         			<c:forEach var="emp" items="${requestScope.emplist}">
                  	<!-- 회원리스트 1줄 -->
                       <div class="d-flex justify-content-between align-items-start align-items-sm-center mb-4 flex-column flex-sm-row">
							<div class="left d-flex align-items-center">
                              <div class="icon icon-lg shadow mr-3 text-gray"><i class="fab fa-android"></i></div>
                                <div class="text" style="width:80px;">
                                    <h6 class="mb-0 d-flex align-items-center">
                                 		<span>${emp.ename}</span>
                              		</h6>
                              
                              		<small class="text-gray">${emp.empno}</small>
                           		</div>
                           		<div class="text" style="width:100px;">
                           			<h6>${emp.job}</h6>
                           		</div>
                           		<div class="text" style="width:50px;">
                           			<h6>${emp.mgr}</h6>
                           		</div>
                           		<div class="text" style="width:100px;">
                           			<h6>${emp.hiredate}</h6>
                           		</div>
                           		<div class="text" style="width:70px;">
                           			<h6>${emp.sal}</h6>
                           		</div>
                           		<div class="text" style="width:70px;">
                           			<h6>${emp.comm}</h6>
                           		</div>
                           		<div class="text" style="width:70px;">
                           			<h6>${emp.deptno}</h6>
                           		</div>
                        	  </div>
	                        <div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-violet">
	                           <a href="empEdit.do?empno=${emp.empno}"><span>수정</span></a>
	                           <a href="empDelete.do?empno=${emp.empno}"><span>삭제</span></a>
	                        </div>
                  		</div>
                       <!-- 회원리스트 1줄 -->
                       </c:forEach>
			      </div>
                </div>
              </div>
            </div>          
        </div>
      
      <!-- 여기까지-->

        <c:import url="../common/Bottom.jsp" />   