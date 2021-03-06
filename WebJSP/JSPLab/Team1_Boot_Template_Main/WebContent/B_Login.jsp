<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="commonmodule/B_top.jsp"></jsp:include>
  <section id="about" class="section-padding1 text-center">
   <div class="container" align ="center">
            
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="about-text wow bounceIn">
                        <div class="about-icon">
                            <i class="li_world"></i>
                        </div>


				<h3>Sign In</h3>
				<div class="d-flex justify-content-end social_icon">
					
				</div>
			</div>
			
			<div class="card-body">
				<form >
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="username" >
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="password">
					</div>
					<div class="row align-items-center remember">
						<input type="checkbox">Remember Me
					</div>
					<div class="form-group">
						<button type="submit" class="signupbtn">Login</button>
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Don't have an account?<a href="B_sign_up.jsp">Sign Up</a>
				</div>
			</div>
		</div>
	</div>
</div>
</section>
<jsp:include page="commonmodule/B_foot.jsp"></jsp:include>

