<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../common/Admin.jsp" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Emp List</title>
   	<c:import url="../common/Top.jsp" />
   	<!-- 페이징 처리 위해서 count, cp 설정 -->
   	<c:set var="count" value="${requestScope.totalcount}" />
	<c:choose>
		<c:when test="${count%2 == 0}">
			<c:set var="count" value="${count/4}" />
		</c:when>
		<c:otherwise>
			<c:set var="count" value="${count/4 +1}" />
		</c:otherwise>
	</c:choose>
	<fmt:formatNumber var="countInt" value="${count+(1-(count%1))%1}" pattern="."/>
	<fmt:parseNumber var = "countInt" integerOnly="true" value="${countInt}"/>
	
   	<script type="text/javascript">
		$(function(){
			var cp = 1;
			//console.log(cp);
			var data = {"cp" : 1};
			//list();
			
			function list() {
				$.ajax({
					url : "empListOk.htm",
					dataType: "JSON",
					type: "POST",
					data : data,
					success: function(data){
						//console.log(data);
						if(data != ""){
							$('#selectData').empty();
							selectData = "";
							
							$.each(data, function(index, data){
								selectData += '<div class="d-flex justify-content-between align-items-start align-items-sm-center mb-4 flex-column flex-sm-row">'
		            				+'<div class="left d-flex align-items-center" style="width:80%">'
		                   				+'<div class="icon icon-lg shadow mr-3 text-gray"><img src="emp_img/'+data.save_picture+'" alt="Jason Doe" style="max-width: 2.5rem;" class="img-fluid rounded-circle shadow"></div>'
		                      				+'<div class="text" style="width:15%;">'
		                           				+'<h6 class="mb-0 d-flex align-items-center">'
		                       						+'<span>'+data.ename+'</span>'
		                   						+ '</h6>'
		                   						+'<small class="text-gray">'+data.empno+'</small>'
		              						+'</div>'
		                   				+'<div class="text" style="width:20%;">'
		                   					+'<h6>'+data.job+'</h6>'
		                   				+'</div>'
		                   				+'<div class="text" style="width:10%;">'
		                   					+'<h6>'+data.mgr+'</h6>'
		                   				+'</div>'
		                   				+'<div class="text" style="width:20%;">'
		                   					+'<h6>'+data.hiredate+'</h6>'
		                   				+'</div>'
		                   				+'<div class="text" style="width:14%;">'
		                   					+'<h6>'+data.sal+'</h6>'
		                   				+'</div>'
		                   				+'<div class="text" style="width:13%;">'
		                   					+'<h6>'+data.comm+'</h6>'
		                   				+'</div>'
		                   				+'<div class="text" style="width:13%;">'
		                   					+'<h6>'+data.deptno+'</h6>'
		                   				+'</div>'
		                	  		+'</div>'
		                    		+'<div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-violet" style="width:7%">'
		                       			+'<a href="empEdit.htm?empno='+data.empno+'"><span>수정</span></a>'
		                       		+'</div>'
		                       		+'<div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-violet" style="width:7%">'
		                       			+'<a href="empDelete.htm?empno='+data.empno+'"><span>삭제</span></a>'
		                    		+'</div>'
		          				+'</div>';
							});
						}else {
							$('#selectData').empty();
							selectData = "데이터가 없습니다.";
						}
						$('#selectData').append(selectData);
					},
					error : function (xhr) {
						console.log(xhr.status);
					}
				});	
			};
			
			var selectData = ""; //비동기 출력 데이터 담을 변수
			
			$('.btn').click(function() {
				var cur = $(this).text(); //클릭한 페이지
				//console.log(cur);
				if(cur == "처음"){
					data = {"cp":1};
					cp = 1
				}else if(cur == "마지막"){
					data = {"cp":${countInt}};
					cp = ${countInt};
				}else {
					data = {"cp":(cur)};
					cp = (cur);
				}
				//console.log(data);
				//list();
				location.href="empList.htm?cp="+cp;
			});
			
			//empno 비동기 검색
			$("#empno").keyup(function(){
				//입력확인
				//console.log($("#empno").val());
				
				if($("#empno").val() != ""){
					$.ajax({
						url:"empSeleteEmpno.htm",
						type : "POST",
						dataType : "json",
						data : {"empno":$('#empno').val()},
						success : function(data){//서버에서 받은 응답이 정상이라면, 4 + 200~299
							//console.log(data.empno);
							
							if( data.empno != 0 ) {
								//console.log("출력처리가능");
								$('#selectData').empty();
			                  	
			                    selectData = '<div class="d-flex justify-content-between align-items-start align-items-sm-center mb-4 flex-column flex-sm-row">'
			                    				+'<div class="left d-flex align-items-center" style="width:80%">'
			                           				+'<div class="icon icon-lg shadow mr-3 text-gray"><img src="emp_img/'+data.save_picture+'" alt="Jason Doe" style="max-width: 2.5rem;" class="img-fluid rounded-circle shadow"></div>'
			                              				+'<div class="text" style="width:15%;">'
			                                   				+'<h6 class="mb-0 d-flex align-items-center">'
			                               						+'<span>'+data.ename+'</span>'
			                           						+ '</h6>'
			                           						+'<small class="text-gray">'+data.empno+'</small>'
			                      						+'</div>'
			                           				+'<div class="text" style="width:20%;">'
			                           					+'<h6>'+data.job+'</h6>'
			                           				+'</div>'
			                           				+'<div class="text" style="width:10%;">'
			                           					+'<h6>'+data.mgr+'</h6>'
			                           				+'</div>'
			                           				+'<div class="text" style="width:20%;">'
			                           					+'<h6>'+data.hiredate+'</h6>'
			                           				+'</div>'
			                           				+'<div class="text" style="width:14%;">'
			                           					+'<h6>'+data.sal+'</h6>'
			                           				+'</div>'
			                           				+'<div class="text" style="width:13%;">'
			                           					+'<h6>'+data.comm+'</h6>'
			                           				+'</div>'
			                           				+'<div class="text" style="width:13%;">'
			                           					+'<h6>'+data.deptno+'</h6>'
			                           				+'</div>'
			                        	  		+'</div>'
				                        		+'<div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-violet" style="width:7%">'
				                           			+'<a href="empEdit.do?empno='+data.empno+'"><span>수정</span></a>'
				                           		+'</div>'
				                           		+'<div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-violet" style="width:7%">'
				                           			+'<a href="empDelete.do?empno='+data.empno+'"><span>삭제</span></a>'
				                        		+'</div>'
			                  				+'</div>';
							}else {
								$('#selectData').empty();
								selectData = "데이터가 없습니다.";
							}
							$('#selectData').append(selectData);
						},
						error : function(xhr){ //서버에서 받은 응답이 error 404,500 등
							alert(xhr.status); //에러코드 404, 500 ...
							//새로고침 하거나 그냥 두거나 개발자 선택
						}
					});	
				}else {
					alert("사번이 입력되지 않았습니다.");
				}
				return false;
			});//empno 비동기검색 닫음
			
			//deptno 비동기 검색
			$("#deptno").keyup(function(){
				//입력확인
				//console.log($("#deptno").val());
				
				if($("#deptno").val() != ""){
					$.ajax({
						url:"empSeleteDeptno.htm",
						type : "POST",
						dataType : "json",
						data : {"deptno":$('#deptno').val()},
						success : function(data){//서버에서 받은 응답이 정상이라면, 4 + 200~299
							//console.log(data == ""); //true
							if(data != ""){
								$('#selectData').empty();
								selectData = "";
								$.each(data, function(index, data){
									selectData += '<div class="d-flex justify-content-between align-items-start align-items-sm-center mb-4 flex-column flex-sm-row">'
	                    				+'<div class="left d-flex align-items-center" style="width:80%">'
	                           				+'<div class="icon icon-lg shadow mr-3 text-gray"><img src="emp_img/'+data.save_picture+'" alt="Jason Doe" style="max-width: 2.5rem;" class="img-fluid rounded-circle shadow"></div>'
	                              				+'<div class="text" style="width:15%;">'
	                                   				+'<h6 class="mb-0 d-flex align-items-center">'
	                               						+'<span>'+data.ename+'</span>'
	                           						+ '</h6>'
	                           						+'<small class="text-gray">'+data.empno+'</small>'
	                      						+'</div>'
	                           				+'<div class="text" style="width:20%;">'
	                           					+'<h6>'+data.job+'</h6>'
	                           				+'</div>'
	                           				+'<div class="text" style="width:10%;">'
	                           					+'<h6>'+data.mgr+'</h6>'
	                           				+'</div>'
	                           				+'<div class="text" style="width:20%;">'
	                           					+'<h6>'+data.hiredate+'</h6>'
	                           				+'</div>'
	                           				+'<div class="text" style="width:14%;">'
	                           					+'<h6>'+data.sal+'</h6>'
	                           				+'</div>'
	                           				+'<div class="text" style="width:13%;">'
	                           					+'<h6>'+data.comm+'</h6>'
	                           				+'</div>'
	                           				+'<div class="text" style="width:13%;">'
	                           					+'<h6>'+data.deptno+'</h6>'
	                           				+'</div>'
	                        	  		+'</div>'
		                        		+'<div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-violet" style="width:7%">'
		                           			+'<a href="empEdit.htm?empno='+data.empno+'"><span>수정</span></a>'
		                           		+'</div>'
		                           		+'<div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-violet" style="width:7%">'
		                           			+'<a href="empDelete.htm?empno='+data.empno+'"><span>삭제</span></a>'
		                        		+'</div>'
	                  				+'</div>';
								});
							}else {
								$('#selectData').empty();
								selectData = "데이터가 없습니다.";
							}
							$('#selectData').append(selectData);
						},
						error : function(xhr){ //서버에서 받은 응답이 error 404,500 등
							alert(xhr.status); //에러코드 404, 500 ...
							//새로고침 하거나 그냥 두거나 개발자 선택
						}
					});	
				}else {
					alert("부서번호가 입력되지 않았습니다.");
				}
				return false;
			});//deptno 비동기검색 닫음
			
		});//onload 닫음

   </script>
    
    <div class="d-flex align-items-stretch">
    
    <c:import url="../common/Left.jsp" />
    
      <div class="page-holder w-100 d-flex flex-wrap" style="min-width: 850px">
      
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
                     
                     <form id="searchFormEmpno" class="ml-auto d-none d-lg-block mb-3" method="post">
						<div class="form-group position-relative mb-0">
							<button type="submit" id="empnoSearch" style="top: -3px; left: 0;" class="position-absolute bg-white border-0 p-0">
							<i class="o-search-magnify-1 text-gray text-lg"></i></button>
							<input type="search" id="empno" name="empno" placeholder="Empno Search ..." class="form-control form-control-sm border-0 no-shadow pl-4">
						</div>
                     </form>
                     
                     <form id="searchFormDeptno" class="ml-auto d-none d-lg-block mb-3" method="post">
						<div class="form-group position-relative mb-0">
							<button type="submit" id="deptnoSearch" style="top: -3px; left: 0;" class="position-absolute bg-white border-0 p-0">
							<i class="o-search-magnify-1 text-gray text-lg"></i></button>
							<input type="search" id="deptno" name="deptno" placeholder="Deptno Search ..." class="form-control form-control-sm border-0 no-shadow pl-4">
						</div>
                     </form>
                     
         			<div id="selectData">
         			<c:forEach var="emp" items="${emplist}">
                  	<!-- 회원리스트 1줄 -->
                       <div class="d-flex justify-content-between align-items-start align-items-sm-center mb-4 flex-column flex-sm-row">
							<div class="left d-flex align-items-center" style="width:80%">
                              <div class="icon icon-lg shadow mr-3 text-gray"><img src="emp_img/${emp.save_picture}" alt="Jason Doe" style="max-width: 2.5rem;" class="img-fluid rounded-circle shadow"></div>
                                <div class="text" style="width:15%;">
                                    <h6 class="mb-0 d-flex align-items-center">
                                 		<span id="ename">${emp.ename}</span>
                              		</h6>
                              		<small class="text-gray" id="empno">${emp.empno}</small>
                           		</div>
                           		
                           		<div class="text" style="width:20%;">
                           			<h6 id="job">${emp.job}</h6>
                           		</div>
                           		
                           		<div class="text" style="width:10%;">
                           			<h6 id="mgr">${emp.mgr}</h6>
                           		</div>
                           		
                           		<div class="text" style="width:20%;">
                           			<h6 id="hiredate">${emp.hiredate}</h6>
                           		</div>
                           		
                           		<div class="text" style="width:14%;">
                           			<h6 id="sal">${emp.sal}</h6>
                           		</div>
                           		
                           		<div class="text" style="width:13%;">
                           			<h6 id="comm">${emp.comm}</h6>
                           		</div>
                           		
                           		<div class="text" style="width:13%;">
                           			<h6 id="deptno">${emp.deptno}</h6>
                           		</div>
                        	  </div>
	                        <div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-violet" style="width:7%">
	                           <a href="empEdit.htm?empno=${emp.empno}"><span>수정</span></a>
	                        </div>
	                        <div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-violet" style="width:7%">   
	                           <a href="empDelete.htm?empno=${emp.empno}"><span>삭제</span></a>
	                        </div>
                  		</div>
                       <!-- 회원리스트 1줄 -->
                       </c:forEach>
                      </div>

                      <div style="margin-bottom:15px; text-align:center">
				         <span style="padding:0;" class="btn" id="first">처음</span>
				         <c:forEach var="i" begin="1" end="${countInt}">
				            <span style="padding:0;" class="btn" id="paging">${i}</span>
				         </c:forEach>
				         <span style="padding:0;" class="btn" id="next">마지막</span>
				      </div>
				      
			      </div>
                </div>
              </div>
            </div>          
        </div>
      
      <!-- 여기까지-->

        <c:import url="../common/Bottom.jsp" />   