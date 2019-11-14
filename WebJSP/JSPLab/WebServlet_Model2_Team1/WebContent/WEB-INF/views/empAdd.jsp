<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Register</title>
   <c:import url="../common/Top.jsp" />
       <script type="text/javascript">
	    	$(function(){

	    		$.ajax({
	    			url:"deptNo.do",
	    			type : "POST",
					dataType : "json",
	    			success: function(dept){
	    				//console.log(dept);
	    				$.each(dept,function(index,data){
	    					//console.log(data.deptno);
	    					var option = "<option value='"+data.deptno+"'>"+data.dname+"</option>"
	    					$('#deptno').append(option);
	    				});
	    			},
	    			error : function(xhr){
	    				alert(xhr.status);	
	    			}
	    		});
	    		
	    		var monthNames =[];
				for(var i = 1 ; i <=12 ;i++){
					monthNames.push(i + "월");
				}
				
				$('#hiredate').datepicker({
					dateFormat: "yy-mm-dd",
					prevText: "이전달",
					nextText: "다음달",
					monthNames: monthNames,
					dayNamesMin: ['일','월','화','수','목','금','토'],
					yearSuffix: "년",
					numberOfMonths: 1
				});
	    		
				$('#hiredate').datepicket("option", "onClose", function(selectedDate){
					
				})
				
	    		$('#submit').click(function(){
	        		var issubmit = false;
	        		console.log($('#empno').val());
	        		
	        		if($('#empno').val() == ""){
	        			alert("사번은 필수입력사항 입니다.");
	        			issubmit = false;
	        		}else {
	        			issubmit = true;
	        		}
	        		return issubmit;
	        	});	
	    	});
    	</script>
    
    <div class="d-flex align-items-stretch">
    <c:import url="../common/Left.jsp" />
      <div class="page-holder w-100 d-flex flex-wrap">
      	<!-- 여기부터 -->
      	<div class="container-fluid px-xl-5">
        	
        	<div class="row">
				<div class="col-lg-12 data-padding">
					<div class="card mb-5 mb-lg-0">         
						<div class="card-header text-center">
							<h6>Register</h6>
						</div>
						<div class="card-body body-padding text-center">
						
				        	<form id="editForm" action="empAddOk.do" class="mt-4" method="post" enctype="multipart/form-data">
				              
				              <div class="form-group mb-4"><!-- 사원명 -->
				                <input type="text" name="ename" id='ename' placeholder="Name" class="form-control border-0 shadow form-control-lg text-violet">
				              </div>
				              
				              <div class="form-group mb-4"><!-- 사번 -->
				                <input type="text" name="empno" id='empno' placeholder="EmpNo" class="form-control border-0 shadow form-control-lg text-violet">
				              </div>
				              
				              <div class="form-group mb-4" id="jobdiv"><!-- 직종 -->
					            <input type="text" name="job" id='job' placeholder="Job"class="form-control border-0 shadow form-control-lg text-violet" >
				              </div>
				              
				              <div class="form-group mb-4"><!-- 사수 -->
				                <input type="text" name="mgr" id='mgr' placeholder="Manager EmpNo" class="form-control border-0 shadow form-control-lg text-violet">
				              </div>
				              
				              <div class="form-group mb-4"><!-- 입사일 -->
				                <input type="text" name="hiredate" id='hiredate' placeholder="Hiredate" class="form-control border-0 shadow form-control-lg">
				              </div>
				              
				              <div class="form-group mb-4"><!-- 급여 -->
				                <input type="text" name="sal" id='sal' placeholder="Sal" class="form-control border-0 shadow form-control-lg text-violet">
				              </div>
				              
				              <div class="form-group mb-4"><!-- 수당 -->
				                <input type="text" name='comm' id='comm' placeholder="Commission" class="form-control border-0 shadow form-control-lg text-violet">
				              </div>
				              
				              <div class="form-group mb-4"><!-- 부서번호 -->
				              	<select class="form-control" id="deptno" name="deptno"></select>
				                <!-- <input type="text" name='deptno' id='deptno' placeholder="DeptNo" class="form-control border-0 shadow form-control-lg text-violet"> -->
				              </div>
				              
				              <div class="form-group mb-4"><!-- 사진 -->
				                <input type="file" name='emp_img' id='emp_img' placeholder="Image" class="form-control border-0 shadow form-control-lg text-violet">
				              </div>
				              
				              <button type="submit" id="submit" class="btn btn-primary shadow px-5">OK</button>
				              <button type="button" id="button" class="btn btn-primary shadow px-5" onclick="location.href='empList.do'">List</button>
				        	</form>
        				</div>
        			</div>
        		</div>
        	</div>
        </div>
      	<!-- 여기까지-->
      	<c:import url="../common/Bottom.jsp" />   