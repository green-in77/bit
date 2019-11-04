<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("userid") != null){ //값이 있으면
		out.print("<script>");
			out.print("alert('["+session.getAttribute("userid")+"]님 로그아웃 후 회원가입을 진행해주세요 :)');");
			out.print("location.href='index.jsp'");	
		out.print("</script>");
	}
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Sign up</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
	    $(function(){
	        let idpw_pattern = /^[a-z0-9_]{4,20}$/;
	        //a~z,0~9까지 입력가능 4자~20자 이내로
	        let email_pattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	         //0부터9a부터zA부터Z까지 (-, _, . 가 있어도 되고 없어도 되고, 0부터9a부터zA부터Z까지)반복횟수 상관없이가능
	         //@기호포함  (-, _, . 가 있어도 되고 없어도 되고, 0부터9a부터zA부터Z까지)반복횟수 상관없이가능 .기호포함 2자~3자 이내 대소문자 구분안함
	        
	        let id_check = false;
	        let pw_check = false;
	        let pwck_check = false;
	        let email_check = false;
	
	        //ID 확인 userId : keyup 
	        $('#id').keyup(function(){
	            if(idpw_pattern.test($(this).val()) != true ){
	                $('#spid').text("아이디가 조건에 일치하지 않습니다.");
	                id_check=false;
	            }else{
	                $('#spid').text("아이디가 조건과 일치합니다.");
	                id_check=true;
	            }
	        });
	        
	        //PW확인 userPass : keyup 
	        $('#pwd').keyup(function(){
	            if(idpw_pattern.test($(this).val()) != true ){
	                $('#sppw').text("패스워드가 조건에 일치하지 않습니다.");
	                pw_check=false;
	            }else{
	                $('#sppw').text("패스워드가  조건과 일치합니다.");
	                pw_check=true;
	            }
	        });
	        
	        //PW입력동일 확인 userPassCheck : keyup
	        $('#pwdck').keyup(function(){
	            if( $('#pwd').val() != $('#pwdck').val()){
	                $('#sppwck').text("입력한 비밀번호와 일치하지 않습니다.");
	                pwck_check=false;
	            }else{
	                $('#sppwck').text("입력한 비밀번호와 일치합니다.");
	                pwck_check=true;
	            }
	        });
	        
	        //email확인  userEmail : keyup
	        $('#email').keyup(function(){
	            if(email_pattern.test($(this).val()) != true){
	                $('#spemail').text("이메일 형식에 맞지 않습니다.");
	                email_check=false;
	            }else{
	                $('#spemail').text("이메일 형식에 맞습니다.");
	                email_check=true;
	            }
	        });
	        
	        
	        $('#submit').click(function(){
	            /* let Ssn1_check = $('#userSsn1').val()!="";
	            let Ssn2_check = $('#userSsn2').val()!="";
	            let ZipCode_check = $('#userZipCode').val()!=""; */
	            let name_check = false;
	        	let age_check = false;
	            
	            if($('#name').val() == "") { // 이름 검사
		        	name_check = false;
		      	}else{
		      		name_check = true;
		      	}
		    	    	
		    	if ($('#age').val() == "") { // 나이 검사
		    		age_check = false;
		    	}else{
		    		age_check = true;
		    	}
		        
	            
	            let issubmit = id_check && pw_check && pwck_check && email_check && name_check && age_check;
	            console.log(issubmit);
	            
	            if (!issubmit){
	                alert("입력이 되지 않았습니다.");    
	            }else{
	                issubmit = true;
	            }
	            
	          return issubmit;
	        });
	    });
	</script>	
	<jsp:include page="common/Top.jsp"></jsp:include>
	
    <div class="d-flex align-items-stretch">
    
    <jsp:include page="common/Left.jsp"></jsp:include>
    
      <div class="page-holder w-100 d-flex flex-wrap">
        <div class="container-fluid px-xl-5">
        	
        	<div class="row">
				<div class="col-lg-12 data-padding">
					<div class="card mb-5 mb-lg-0">         
						<div class="card-header text-center">
							<h6>Sign Up</h6>
						</div>
						<div class="card-body body-padding text-center">
				        	<form id="signupForm" action="signupok.jsp" class="mt-4" method="post">
				        	
				              <div class="form-group mb-4"><!-- ID -->
				                <input type="text" name="id" id='id' placeholder="Id" class="form-control border-0 shadow form-control-lg">
				                <span id=spid></span>
				              </div>
				              
				              <div class="form-group mb-4"><!-- pw -->
				                <input type="password" name="pwd" id='pwd' placeholder="Password" class="form-control border-0 shadow form-control-lg text-violet">
				                <span id=sppw></span>
				              </div>
				              
				              <div class="form-group mb-4"><!-- pw체크 -->
				                <input type="password" id='pwdck' placeholder="Password" class="form-control border-0 shadow form-control-lg text-violet">
				                <span id=sppwck></span>
				              </div>
				              
				              <div class="form-group mb-4"><!-- 이름 -->
				                <input type="text" name="name" id='name' placeholder="Name" class="form-control border-0 shadow form-control-lg text-violet">
				              </div>
				              
				              <div class="form-group mb-4"><!-- 나이-->
				                <input type="text" name="age" id='age' placeholder="Age" class="form-control border-0 shadow form-control-lg text-violet">
				              </div>
				              
				              <div class="form-group mb-4"><!-- 성별-->
				              	<div class="row">
					              	<div class="col-lg-6">
					                	<input type="radio" name="gender" id="gender" value="여" checked>여자
					                </div>
					                <div class="col-lg-6">
					                	<input type="radio" name="gender" id="gender" value="남">남자
					                </div>
				                </div>
				              </div>
				              
				              <div class="form-group mb-4"><!-- email -->
				                <input type="text" name='email' id='email' placeholder="Email" class="form-control border-0 shadow form-control-lg text-violet">
				                <span id=spemail></span>
				              </div>
				
				              <button type="submit" id="submit" class="btn btn-primary shadow px-5">Sign up</button>
				        	</form>
        				</div>
        			</div>
        		</div>
        	</div>
        </div>
        <jsp:include page="common/Bottom.jsp"></jsp:include>
        