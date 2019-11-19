<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title>Free Responsive Admin Theme - ZONTAL</title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONT AWESOME ICONS  -->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLE  -->
    <link href="assets/css/style.css" rel="stylesheet" />
     <!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="navbar navbar-inverse set-radius-zero">
        <div class="container">
        
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand" href="index.jsp">
                    <img src="assets/img/Logo3.png" style="width: 45%"/>
                </a>
            </div>

            <div class="left-div">
                <div class="user-settings-wrapper">
                
                </div>
            </div>
        </div>
    </div>
    <!-- LOGO HEADER END-->
    <section class="menu-section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                
                    <div class="navbar-collapse collapse ">
                        <ul id="menu-top" class="nav navbar-nav navbar-right">
                            <li><a href="index.jsp">Eye-Fi</a></li>
                            <li><a href="">어린이집</a></li>
                            <li><a data-toggle="modal" data-target="#login">로그인</a></li>
                            <li><a data-toggle="modal" data-target="#join">회원가입</a></li>
                        </ul>
                    </div>
                    
                </div>
            </div>
        </div>
    </section>
    <!-- MENU SECTION END-->
    
    <!-- 로그인  -->
    <div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
		<div class="modal-dialog1">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">로그인</h4>
				</div>
				<form role="form" id="loginForm" action="login.do" method="post">
					<div class="modal-body">
						
							<div class="form-group">
								<label class="control-label" for="userid">아이디</label>
								<input type="text" class="form-control" id="userid" name="userid">
							</div>
							
							<div class="form-group">
								<label class="control-label" for="userpw">비밀번호</label>
								<input type="password" class="form-control" id="userpw" name="userpw">
							</div>
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
						<button type="submit" class="btn btn-primary">로그인</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<!-- 회원가입 -->
    <div class="modal fade" id="join" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
		<div class="modal-dialog2">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">회원가입</h4>
				</div>
				<form role="form" id="joinForm" action="join.do" method="post">
					<div class="modal-body">
						
							<div class="form-group">
								<label class="control-label" for="userid">아이디</label>
								<input type="text" class="form-control" id="userid" />
								<small id="idcheck">아이디를 입력해주세요.</small>
							</div>
							
							<div class="form-group">
								<label class="control-label" for="userpw">비밀번호</label>
								<input type="password" class="form-control" id="userpw" />
								<small id="idcheck">비밀번호를 입력해주세요.</small>
							</div>
							
							<div class="form-group">
								<label class="control-label" for="userpwCk">비밀번호 확인</label>
								<input type="password" class="form-control" id="userpwCk" />
								<small id="idcheck">비밀번호를 입력해주세요.</small>
							</div>
							
							<div class="form-group">
								<label class="control-label" for="email">이메일</label>
								<input type="text" class="form-control" id="email" />
								<small id="idcheck">이메일을 입력해주세요.</small>
								<div style="text-align: right;">
									<button type="button" class="btn btn-primary" onclick="">인증</button>
								</div>
							</div>
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
						<button type="submit" class="btn btn-primary">회원가입</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	