<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="common/Admin.jsp"></jsp:include>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Member List</title>
    
	<jsp:include page="common/Top.jsp"></jsp:include>
	
    <div class="d-flex align-items-stretch">
    
    <jsp:include page="common/Left.jsp"></jsp:include>
    
      <div class="page-holder w-100 d-flex flex-wrap">
        <div class="container-fluid px-xl-5">
        <%
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					conn = Singleton_Helper.getConnection("oracle");
					String sql = "select id,ip from koreamember";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
			%>
				<div class="row">
					<div class="col-lg-12 table-padding">
						<div class="card mb-5 mb-lg-0">         
							<div class="card-header">
								<h2 class="h6 mb-0 text-uppercase">Member List</h2>
							</div>
						<div class="card-body">
							<p class="text-gray">회원관리하세요~</p>
							<form id="searchForm" class="ml-auto d-none d-lg-block mb-3" action="memberSearch.jsp" method="post">
              					<div class="form-group position-relative mb-0">
                						<button type="submit" style="top: -3px; left: 0;" class="position-absolute bg-white border-0 p-0">
                						<i class="o-search-magnify-1 text-gray text-lg"></i></button>
                						<input type="search" name="search" placeholder="회원명 Search ..." class="form-control form-control-sm border-0 no-shadow pl-4">
              					</div>
            				</form>
			<%
					while(rs.next()){
			%>
						<!-- 회원리스트 1줄 -->
                    	<div class="d-flex justify-content-between align-items-start align-items-sm-center mb-4 flex-column flex-sm-row">
                      		<div class="left d-flex align-items-center">
                        		<div class="icon icon-lg shadow mr-3 text-gray"><i class="fab fa-android"></i></div>
                        			<div class="text">
                          				<h6 class="mb-0 d-flex align-items-center">
											<span><a href='memberDetail.jsp?id=<%=rs.getString("id")%>'><%= rs.getString("id") %></span>
										</h6>
										<small class="text-gray"><%= rs.getString("ip") %></small>
									</div>
								</div>
								<div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-violet">
									<a href='memberEdit.jsp?id=<%=rs.getString("id")%>'><span>수정</span></a>
									<a href='memberDelete.jsp?id=<%=rs.getString("id")%>'><span>삭제</span></a>
								</div>
						</div>
                    	<!-- 회원리스트 1줄 -->
			<%
					}
			%>
			         </div>
                </div>
              </div>
              
            </div> 

			<%
				} catch(Exception e){
					
				} finally{
					Singleton_Helper.close(rs);
					Singleton_Helper.close(pstmt);
				}
			%>
			
        </div>
        
        <jsp:include page="common/Bottom.jsp"></jsp:include>
        