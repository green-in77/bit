<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript">
	/*
		$.get(URL,data,function(data,status,xhr),dataType)
		>httpReq.open("GET")
	*/
	$(function(){
		$('#btn').click(function(){
			$.get('Ex03_Company.xml',function(data){
				//console.log(data); //가공
				$('#display').empty() //자식요소 제거
				//console.log($(data).find('Company'));
				//find() 함수 return = 배열[Company, Company]
				//$.each(Array,function(index, element){});
				//$().each(function(index,element){});
				$(data).find('Company').each(function(){
					//console.log(this);
					var entry = $(this);
					//console.log(entry);
					/*
					<Company CompanyType="private">
						<CompanyName>Bit</CompanyName>
						<CompanyNumber>2019</CompanyNumber>
						<CompanyAddress>서울시 시초구</CompanyAddress>
						<Name></Name>
					</Company>
					*/
					let html = "<div>" + entry.attr('CompanyType') + "</div>";
					//console.log(html);
					html += "<div>" + entry.find('CompanyName').text() + "</div>"
					html += "<div>" + entry.find('CompanyNumber').text() + "</div>"
					html += "<div>" + entry.find('CompanyAddress').text() + "</div>"
					html += "<div>" + entry.find('Name').text() + "</div>"
					
					$('#display').append(html);
					
					//var Companyarr = $(data).find('Company');
					//$.each(Companyarr, function(index, obj){});
				});
				
			});
		});
	});
	</script>
</head>
<body>
	<input type="button" id="btn" value="회사소개">
	<div id="display" style="background-color: gray">DATA</div>
</body>
</html>