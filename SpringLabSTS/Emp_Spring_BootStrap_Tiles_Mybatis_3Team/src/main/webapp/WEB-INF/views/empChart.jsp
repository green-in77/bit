<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../common/Admin.jsp" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Chart</title>
    
    <script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/wordcloud.js"></script>
	
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

   	<c:import url="../common/Top.jsp" />
    	
	<script type="text/javascript">
		$(function(){
			$('#chart').change(function() {
				console.log($('#chart').val());
				var data = [];
				
				$.ajax({
					url : $('#chart').val(),
					type : "POST",
					dataType : "json",
					success : function(emp){//서버에서 받은 응답이 정상이라면, 4 + 200~299
						//console.log(emp);
						if($('#chart').val() == "empSalChart.htm"){
							//사원별 급여 선택 시
							$.each(emp, function(index, emp){
								console.log(emp.ename);
								data.push({"name":emp.ename,"weight":emp.sal});
							});
							console.log(emp);
							
							Highcharts.chart('container', {
							    series: [{
							        type: 'wordcloud',
							        data: data,
							        name: 'Sal'
							    }],
							    title: {
							        text: 'Emp Sal'
							    }
							}); //chart 끝
						}
					}, //success 끝
					error : function(xhr){ //서버에서 받은 응답이 error 404,500 등
						alert("ajax error : " + xhr.status); //에러코드 404, 500 ...
					} //error 끝
				}); //ajax 끝
			}); //change 끝
		});//onload 끝
	</script>
    
    <div class="d-flex align-items-stretch">
    <c:import url="../common/Left.jsp" />    
      <div class="page-holder w-100 d-flex flex-wrap">
		<!-- 여기부터 -->
		<select style="height: 30px" id="chart">
			<!-- <option value="EmpJopAvgSalChart.do">직종별 평균급여</option>
			<option value="EmpJopChart.do">직종별 사원수</option> -->
			<option value="empSalChart.htm">Chart</option>
			<option value="empSalChart.htm">사원별 급여</option>
		</select>
		<div id="container" style="width: 90%; height: 90%; margin: auto;">
		</div>
		<!-- 여기까지 -->
        <c:import url="../common/Bottom.jsp" />   