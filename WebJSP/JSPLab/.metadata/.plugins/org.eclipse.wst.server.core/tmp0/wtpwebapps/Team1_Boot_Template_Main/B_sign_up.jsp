<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="commonmodule/B_top.jsp"></jsp:include>

<div class="container">
    <div class="row">
    <div class="col-sm-12 text-center" >
    <div class="col-sm-3"></div>
     
    <div class="col-sm-6">
    <h2>Sign Up</h2>
   
        <table class="table table-boardered">
            <tr>
                <th>아이디</th>
                <td><input type="text" class="form-control" name="id" placeholder="아이디를 입력해주세요"></td>        
            </tr>
            <tr>
                <th>패스워드</th>
                <td><input type="password" class="form-control" name="pass1" placeholder="비밀번호를 입력해주세요"></td>      
            </tr>
             
            <tr>
                <th>패스워드확인</th>
                <td><input type="password" class="form-control" name="pass2"></td>        
            </tr>
             
            <tr>
                <th>이메일</th>
                <td><input type="email" class="form-control" name="email"></td>       
            </tr>
             
            <tr>
                <th>전화번호</th>
                <td><input type="tel" class="form-control" name="tel"></td>       
            </tr>
             
            <tr>
                <th>관심분야</th>
                <td>
                <input type="checkbox"  name="hobby" value="맛집탐방">맛집탐방 &nbsp;&nbsp;
                <input type="checkbox"  name="hobby" value="등산">등산 &nbsp;&nbsp;
                <input type="checkbox"  name="hobby" value="영화">영화 &nbsp;&nbsp;
                <input type="checkbox"  name="hobby" value="독서">독서 &nbsp;&nbsp;
                </td>     
            </tr>
             
            <tr>
                <th>당신의 직업</th>
                <td>
                 <select name="job" class="form-control">
                    <option value="학생">학생</option>
                    <option value="자영업">자영업</option>
                    <option value="프로그래머">프로그래머</option>
                    <option value="무직">무직</option>
                 </select>
                </td>     
            </tr>
             
                         
            <tr>
                <th>당신의 연령</th>
                <td>
                <input type="radio"  name="age" value="10">10대 &nbsp;&nbsp;
                <input type="radio"  name="age" value="20">20대 &nbsp;&nbsp;
                <input type="radio"  name="age" value="30">30대 &nbsp;&nbsp;
                <input type="radio"  name="age" value="40">40대 &nbsp;&nbsp;
                <input type="radio"  name="age" value="40">50대 &nbsp;&nbsp;
                </td>     
            </tr>
             
            <tr>
                <td colspan="2"> <!-- 열로 2칸 만들기 -->
                <button type="button" class="cancelbtn">Cancel</button>
        		<button type="submit" class="signupbtn">Sign Up</button>
                </td>
            </tr>          
        </table>
   
    </div>
     
    </div>
    </div>
</div>

<jsp:include page="commonmodule/B_foot.jsp"></jsp:include>