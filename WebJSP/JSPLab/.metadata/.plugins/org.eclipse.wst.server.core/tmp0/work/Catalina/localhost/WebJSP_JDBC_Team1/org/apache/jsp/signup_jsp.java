/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.26
 * Generated at: 2019-11-01 08:12:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	if(session.getAttribute("userid") != null){ //값이 있으면
		out.print("<script>");
			out.print("alert('["+session.getAttribute("userid")+"]님 로그아웃 후 회원가입을 진행해주세요 :)');");
			out.print("location.href='index.jsp'");	
		out.print("</script>");
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <title>Sign up</title>\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("\t    $(function(){\r\n");
      out.write("\t        let idpw_pattern = /^[a-z0-9_]{4,20}$/;\r\n");
      out.write("\t        //a~z,0~9까지 입력가능 4자~20자 이내로\r\n");
      out.write("\t        let email_pattern = /^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$/i;\r\n");
      out.write("\t         //0부터9a부터zA부터Z까지 (-, _, . 가 있어도 되고 없어도 되고, 0부터9a부터zA부터Z까지)반복횟수 상관없이가능\r\n");
      out.write("\t         //@기호포함  (-, _, . 가 있어도 되고 없어도 되고, 0부터9a부터zA부터Z까지)반복횟수 상관없이가능 .기호포함 2자~3자 이내 대소문자 구분안함\r\n");
      out.write("\t        \r\n");
      out.write("\t        let id_check = false;\r\n");
      out.write("\t        let pw_check = false;\r\n");
      out.write("\t        let pwck_check = false;\r\n");
      out.write("\t        let email_check = false;\r\n");
      out.write("\t\r\n");
      out.write("\t        //ID 확인 userId : keyup \r\n");
      out.write("\t        $('#id').keyup(function(){\r\n");
      out.write("\t            if(idpw_pattern.test($(this).val()) != true ){\r\n");
      out.write("\t                $('#spid').text(\"아이디가 조건에 일치하지 않습니다.\");\r\n");
      out.write("\t                id_check=false;\r\n");
      out.write("\t            }else{\r\n");
      out.write("\t                $('#spid').text(\"아이디가 조건과 일치합니다.\");\r\n");
      out.write("\t                id_check=true;\r\n");
      out.write("\t            }\r\n");
      out.write("\t        });\r\n");
      out.write("\t        \r\n");
      out.write("\t        //PW확인 userPass : keyup \r\n");
      out.write("\t        $('#pwd').keyup(function(){\r\n");
      out.write("\t            if(idpw_pattern.test($(this).val()) != true ){\r\n");
      out.write("\t                $('#sppw').text(\"패스워드가 조건에 일치하지 않습니다.\");\r\n");
      out.write("\t                pw_check=false;\r\n");
      out.write("\t            }else{\r\n");
      out.write("\t                $('#sppw').text(\"패스워드가  조건과 일치합니다.\");\r\n");
      out.write("\t                pw_check=true;\r\n");
      out.write("\t            }\r\n");
      out.write("\t        });\r\n");
      out.write("\t        \r\n");
      out.write("\t        //PW입력동일 확인 userPassCheck : keyup\r\n");
      out.write("\t        $('#pwdck').keyup(function(){\r\n");
      out.write("\t            if( $('#pwd').val() != $('#pwdck').val()){\r\n");
      out.write("\t                $('#sppwck').text(\"입력한 비밀번호와 일치하지 않습니다.\");\r\n");
      out.write("\t                pwck_check=false;\r\n");
      out.write("\t            }else{\r\n");
      out.write("\t                $('#sppwck').text(\"입력한 비밀번호와 일치합니다.\");\r\n");
      out.write("\t                pwck_check=true;\r\n");
      out.write("\t            }\r\n");
      out.write("\t        });\r\n");
      out.write("\t        \r\n");
      out.write("\t        //email확인  userEmail : keyup\r\n");
      out.write("\t        $('#email').keyup(function(){\r\n");
      out.write("\t            if(email_pattern.test($(this).val()) != true){\r\n");
      out.write("\t                $('#spemail').text(\"이메일 형식에 맞지 않습니다.\");\r\n");
      out.write("\t                email_check=false;\r\n");
      out.write("\t            }else{\r\n");
      out.write("\t                $('#spemail').text(\"이메일 형식에 맞습니다.\");\r\n");
      out.write("\t                email_check=true;\r\n");
      out.write("\t            }\r\n");
      out.write("\t        });\r\n");
      out.write("\t        \r\n");
      out.write("\t        \r\n");
      out.write("\t        $('#submit').click(function(){\r\n");
      out.write("\t            /* let Ssn1_check = $('#userSsn1').val()!=\"\";\r\n");
      out.write("\t            let Ssn2_check = $('#userSsn2').val()!=\"\";\r\n");
      out.write("\t            let ZipCode_check = $('#userZipCode').val()!=\"\"; */\r\n");
      out.write("\t            let name_check = false;\r\n");
      out.write("\t        \tlet age_check = false;\r\n");
      out.write("\t            \r\n");
      out.write("\t            if($('#name').val() == \"\") { // 이름 검사\r\n");
      out.write("\t\t        \tname_check = false;\r\n");
      out.write("\t\t      \t}else{\r\n");
      out.write("\t\t      \t\tname_check = true;\r\n");
      out.write("\t\t      \t}\r\n");
      out.write("\t\t    \t    \t\r\n");
      out.write("\t\t    \tif ($('#age').val() == \"\") { // 나이 검사\r\n");
      out.write("\t\t    \t\tage_check = false;\r\n");
      out.write("\t\t    \t}else{\r\n");
      out.write("\t\t    \t\tage_check = true;\r\n");
      out.write("\t\t    \t}\r\n");
      out.write("\t\t        \r\n");
      out.write("\t            \r\n");
      out.write("\t            let issubmit = id_check && pw_check && pwck_check && email_check && name_check && age_check;\r\n");
      out.write("\t            console.log(issubmit);\r\n");
      out.write("\t            \r\n");
      out.write("\t            if (!issubmit){\r\n");
      out.write("\t                alert(\"입력이 되지 않았습니다.\");    \r\n");
      out.write("\t            }else{\r\n");
      out.write("\t                issubmit = true;\r\n");
      out.write("\t            }\r\n");
      out.write("\t            \r\n");
      out.write("\t          return issubmit;\r\n");
      out.write("\t        });\r\n");
      out.write("\t    });\r\n");
      out.write("\t</script>\t\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/Top.jsp", out, false);
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("    <div class=\"d-flex align-items-stretch\">\r\n");
      out.write("    \r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/Left.jsp", out, false);
      out.write("\r\n");
      out.write("    \r\n");
      out.write("      <div class=\"page-holder w-100 d-flex flex-wrap\">\r\n");
      out.write("        <div class=\"container-fluid px-xl-5\">\r\n");
      out.write("        \t\r\n");
      out.write("        \t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-12 data-padding\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card mb-5 mb-lg-0\">         \r\n");
      out.write("\t\t\t\t\t\t<div class=\"card-header text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t<h6>Sign Up</h6>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"card-body body-padding text-center\">\r\n");
      out.write("\t\t\t\t        \t<form id=\"signupForm\" action=\"signupok.jsp\" class=\"mt-4\" method=\"post\">\r\n");
      out.write("\t\t\t\t        \t\r\n");
      out.write("\t\t\t\t              <div class=\"form-group mb-4\"><!-- ID -->\r\n");
      out.write("\t\t\t\t                <input type=\"text\" name=\"id\" id='id' placeholder=\"Id\" class=\"form-control border-0 shadow form-control-lg\">\r\n");
      out.write("\t\t\t\t                <span id=spid></span>\r\n");
      out.write("\t\t\t\t              </div>\r\n");
      out.write("\t\t\t\t              \r\n");
      out.write("\t\t\t\t              <div class=\"form-group mb-4\"><!-- pw -->\r\n");
      out.write("\t\t\t\t                <input type=\"password\" name=\"pwd\" id='pwd' placeholder=\"Password\" class=\"form-control border-0 shadow form-control-lg text-violet\">\r\n");
      out.write("\t\t\t\t                <span id=sppw></span>\r\n");
      out.write("\t\t\t\t              </div>\r\n");
      out.write("\t\t\t\t              \r\n");
      out.write("\t\t\t\t              <div class=\"form-group mb-4\"><!-- pw체크 -->\r\n");
      out.write("\t\t\t\t                <input type=\"password\" id='pwdck' placeholder=\"Password\" class=\"form-control border-0 shadow form-control-lg text-violet\">\r\n");
      out.write("\t\t\t\t                <span id=sppwck></span>\r\n");
      out.write("\t\t\t\t              </div>\r\n");
      out.write("\t\t\t\t              \r\n");
      out.write("\t\t\t\t              <div class=\"form-group mb-4\"><!-- 이름 -->\r\n");
      out.write("\t\t\t\t                <input type=\"text\" name=\"name\" id='name' placeholder=\"Name\" class=\"form-control border-0 shadow form-control-lg text-violet\">\r\n");
      out.write("\t\t\t\t              </div>\r\n");
      out.write("\t\t\t\t              \r\n");
      out.write("\t\t\t\t              <div class=\"form-group mb-4\"><!-- 나이-->\r\n");
      out.write("\t\t\t\t                <input type=\"text\" name=\"age\" id='age' placeholder=\"Age\" class=\"form-control border-0 shadow form-control-lg text-violet\">\r\n");
      out.write("\t\t\t\t              </div>\r\n");
      out.write("\t\t\t\t              \r\n");
      out.write("\t\t\t\t              <div class=\"form-group mb-4\"><!-- 성별-->\r\n");
      out.write("\t\t\t\t              \t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t              \t<div class=\"col-lg-6\">\r\n");
      out.write("\t\t\t\t\t                \t<input type=\"radio\" name=\"gender\" id=\"gender\" value=\"여\" checked>여자\r\n");
      out.write("\t\t\t\t\t                </div>\r\n");
      out.write("\t\t\t\t\t                <div class=\"col-lg-6\">\r\n");
      out.write("\t\t\t\t\t                \t<input type=\"radio\" name=\"gender\" id=\"gender\" value=\"남\">남자\r\n");
      out.write("\t\t\t\t\t                </div>\r\n");
      out.write("\t\t\t\t                </div>\r\n");
      out.write("\t\t\t\t              </div>\r\n");
      out.write("\t\t\t\t              \r\n");
      out.write("\t\t\t\t              <div class=\"form-group mb-4\"><!-- email -->\r\n");
      out.write("\t\t\t\t                <input type=\"text\" name='email' id='email' placeholder=\"Email\" class=\"form-control border-0 shadow form-control-lg text-violet\">\r\n");
      out.write("\t\t\t\t                <span id=spemail></span>\r\n");
      out.write("\t\t\t\t              </div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t              <button type=\"submit\" id=\"submit\" class=\"btn btn-primary shadow px-5\">Sign up</button>\r\n");
      out.write("\t\t\t\t        \t</form>\r\n");
      out.write("        \t\t\t\t</div>\r\n");
      out.write("        \t\t\t</div>\r\n");
      out.write("        \t\t</div>\r\n");
      out.write("        \t</div>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/Bottom.jsp", out, false);
      out.write("\r\n");
      out.write("        ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
