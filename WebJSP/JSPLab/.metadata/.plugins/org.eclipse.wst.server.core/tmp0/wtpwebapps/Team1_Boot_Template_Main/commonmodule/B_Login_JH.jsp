<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="B_top.jsp"></jsp:include>

<div id="id01">
  <form class="animate" action="#" method="post">
   <!--  <div class="imgcontainer">
      <img src="img/img_avatar2.png" alt="Avatar" class="avatar">
    </div> -->

    <div class="container">
    	<h1>로그인</h1>
      <label for="uname"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="uname" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>
        
      <button type="submit">Login</button>
      <label>
        <input type="checkbox" checked="checked" name="remember"> Remember me
      </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="#" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
  </form>
</div>

<jsp:include page="B_foot.jsp"></jsp:include>