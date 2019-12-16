<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="id" value="${sessionScope.userid}"/>
	<div id="sidebar" class="sidebar py-3">
        <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">TEAM_1</div>
        <ul class="sidebar-menu list-unstyled">
              <li class="sidebar-list-item">
              	<a href="index.jsp" class="sidebar-link text-muted">
              	<i class="o-home-1 mr-3 text-gray"></i><span>Home</span>
              	</a>
              </li>
			  <c:choose>
   				<c:when test="${id!=null}">
   					<li class="sidebar-list-item">
              			<a href="empList.htm" class="sidebar-link text-muted">
              			<i class="o-exit-1 mr-3 text-gray"></i><span>List</span></a>
              		</li>
              		<li class="sidebar-list-item">
              			<a href="empAdd.htm" class="sidebar-link text-muted">
              			<i class="o-exit-1 mr-3 text-gray"></i><span>Register</span></a>
              		</li>
              		<li class="sidebar-list-item">
              			<a href="empchart.htm" class="sidebar-link text-muted">
              			<i class="o-exit-1 mr-3 text-gray"></i><span>Chart</span></a>
              		</li>
              		<li class="sidebar-list-item">
              			<a href="adminLogout.htm" class="sidebar-link text-muted">
              			<i class="o-exit-1 mr-3 text-gray"></i><span>Logout</span></a>
              		</li>
				</c:when>
   				<c:otherwise>
      				<li class="sidebar-list-item">
              			<a href="adminLogin.htm" class="sidebar-link text-muted">
              			<i class="o-exit-1 mr-3 text-gray"></i><span>Login</span></a>
              		</li>
   				</c:otherwise>
			</c:choose>              
             

        </ul>
        
	</div>