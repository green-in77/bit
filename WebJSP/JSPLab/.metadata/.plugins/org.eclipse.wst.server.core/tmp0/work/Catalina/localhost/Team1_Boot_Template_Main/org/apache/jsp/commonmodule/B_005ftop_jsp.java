/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.26
 * Generated at: 2019-10-28 08:11:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.commonmodule;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class B_005ftop_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>민주주의인민공화국</title>\r\n");
      out.write("    \r\n");
      out.write("    <!-- Google Fonts -->\r\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300,700,900' rel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap css form cdn -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">\r\n");
      out.write("    \r\n");
      out.write("    <!-- Font awesome css -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css\">\r\n");
      out.write("    \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://localhost:8090/Team1_Boot_Template_Main/css/animate.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://localhost:8090/Team1_Boot_Template_Main/css/linecons.css\">\r\n");
      out.write("    \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://localhost:8090/Team1_Boot_Template_Main/inc/strip/css/strip.css\">\r\n");
      out.write("    \r\n");
      out.write("    <!-- Owl carousel 2 css -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://localhost:8090/Team1_Boot_Template_Main/css/owl.carousel.css\">\r\n");
      out.write("    \r\n");
      out.write("    <!-- Custom CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://localhost:8090/Team1_Boot_Template_Main/style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://localhost:8090/Team1_Boot_Template_Main/css/responsive.css\">\r\n");
      out.write("    \r\n");
      out.write("    <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!--Fontawesome CDN-->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("    \r\n");
      out.write("<body>\r\n");
      out.write("<header class=\"header\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-sm-2\">\r\n");
      out.write("                    <div class=\"logo\">\r\n");
      out.write("                        <h1><a href=\"\">Team1</a></h1>\r\n");
      out.write("                        \r\n");
      out.write("                        <div class=\"navbar-header\">\r\n");
      out.write("                            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\r\n");
      out.write("                                <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                                <span class=\"icon-bar\"></span>\r\n");
      out.write("                                <span class=\"icon-bar\"></span>\r\n");
      out.write("                                <span class=\"icon-bar\"></span>\r\n");
      out.write("                            </button>\r\n");
      out.write("                        </div>                         \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"col-sm-10\">\r\n");
      out.write("                         \r\n");
      out.write("\r\n");
      out.write("                    <div class=\"navbar-collapse collapse\">\r\n");
      out.write("                        <ul class=\"nav navbar-nav navbar-right text-uppercase\">\r\n");
      out.write("                            <li class=\"active\"><a href=\"#slider\">home</a></li>\r\n");
      out.write("                            <li><a href=\"#about\">about</a></li>\r\n");
      out.write("                            <li><a href=\"#member\">member</a></li>\r\n");
      out.write("                            <li><a href=\"#rolling\">rolling</a></li>\r\n");
      out.write("                            <li><a href=\"#constellation\">constellation</a></li>\r\n");
      out.write("                            <li><a href=\"#support\">support</a></li>\r\n");
      out.write("                            <li><a href=\"B_Login.jsp\">login</a></li>\r\n");
      out.write("                            <li><a href=\"B_sign_up.jsp\">sign up</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>                    \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header> <!-- End header -->\r\n");
      out.write("    \r\n");
      out.write("    <section id=\"slider\">\r\n");
      out.write("       \r\n");
      out.write("        <div data-velocity=\"-.2\" class=\"overlay-bg slide-bg\"></div>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-12\">\r\n");
      out.write("                    <div class=\"slide-text-table\">\r\n");
      out.write("                        <div class=\"slide-text-table-cell\">\r\n");
      out.write("                            <div class=\"slide-text wow fadeIn\">\r\n");
      out.write("                                <h1>당신의 후원이<br> 필요합니다.</h1>\r\n");
      out.write("                                <a href=\"\" class=\"learn-more\">read the rest</a>                     \r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </section> <!-- End slider -->");
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
