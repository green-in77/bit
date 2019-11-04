<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
       
   <c:import url="common/Top.jsp" />
    
    <div class="d-flex align-items-stretch">
    
   
    <c:import url="common/Left.jsp" />
    
      <div class="page-holder w-100 d-flex flex-wrap">
        <div class="container-fluid px-xl-5">
           <section id = "main" class="section-padding">
              <div class="container">
               <div class="row">
                  <div class="col-md-12 text-center">   
                     
                     <c:set var="id" value="${sessionScope.userid}"/>
                     <c:if test="${empty id}">
                       	 방문을 환영합니다.<br> 회원가입 또는 로그인 후 이용바랍니다!
                     </c:if>
                  </div>
               </div>
            </div>
         </section>
        
           <section id="member" class="section-padding">
              <div class="container">
           
                  <div class="row">
                      <div class="col-md-12 text-center">
                     <h2>TEAM_1</h2>
                      </div>
                  </div>
                             
                  <div class="row">
                      <div class="col-md-12 text-center inner-padding">
                         <div class="row">
      
                        <div class='col-md-4'>
                                   <span>GM [ISFP-A] 호기심 많은 예술가</span><br>
                                 <img src="img/Team1_1.png" alt="광민" width="200px" height="200px">
                             </div>
                                 
                        <div class='col-md-4'>
                           <span>DY [INFP-T] 열정적인 중재자</span><br>
                           <img src="img/Team1_2.png" alt="도연" width="200px" height="200px">
                        </div>
                                 
                        <div class='col-md-4'>
                           <span>JG [INTJ-A] 용의주도한 전략가</span><br>
                           <img src="img/Team1_3.png" alt="정균" width="200px" height="200px">
                        </div>
                     </div>
                  </div>
               </div>
               
               <div class="row">
                      <div class="col-md-12 text-center inner-padding">
                         <div class="row">
                      
                        <div class='col-md-4'>
                           <span>SH [INFJ-T] 선의의 옹호자</span><br>
                           <img src="img/Team1_4.png" alt="성호" width="200px" height="200px">
                        </div>
                                 
                        <div class='col-md-4'>
                           <span>HN [ESFP-A] 자유로운 영혼의 연예인</span><br>
                           <img src="img/Team1_5.png" alt="한녘" width="200px" height="200px">
                        </div>
                                 
                        <div class='col-md-4'>
                           <span>JH [ISTJ-T] 청렴결백한 논리주의자</span><br>
                           <img src="img/Team1_6.jpg" alt="정하" width="200px" height="200px">
                        </div>
                     </div>
                      </div>
                  </div>

              </div>
          </section>

        </div>
        <c:import url="common/Bottom.jsp" />

        