/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.26
 * Generated at: 2019-10-28 07:10:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class B_005ffoot_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        \r\n");
      out.write("    <footer id=\"footer\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-12\">\r\n");
      out.write("                    <div class=\"footer-sep\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"col-md-7\">\r\n");
      out.write("                    <div class=\"footer-copyright\">\r\n");
      out.write("                        <p>Copyrightⓒ 2019 Team1 All rights reseved.</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"col-md-5\">\r\n");
      out.write("                    <div class=\"footer-menu\" style=\"margin-top:0px;\">\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li><a href=\"\">Top</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer> <!-- End footer -->\r\n");
      out.write(" \r\n");
      out.write("    <!-- jQuery form CDN -->\r\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- Bootstrap form CDN -->\r\n");
      out.write("    <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- jQuery Counterup -->\r\n");
      out.write("    <script src=\"http://cdnjs.cloudflare.com/ajax/libs/waypoints/2.0.3/waypoints.min.js\"></script>\r\n");
      out.write("    <script src=\"js/jquery.counterup.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- jQuery sticky -->\r\n");
      out.write("    <script src=\"js/jquery.sticky.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- jQuery Strip Lightbox -->\r\n");
      out.write("    <script src=\"inc/strip/js/strip.pkgd.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- jQuery easing -->\r\n");
      out.write("    <script src=\"js/jquery.easing.1.3.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- jQuery tweet -->\r\n");
      out.write("    <script src=\"js/jquery.tweet.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- jQuery owl carousel -->\r\n");
      out.write("    <script src=\"js/owl.carousel.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- jQuery isotope filder -->\r\n");
      out.write("    <script src=\"js/isotope.pkgd.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- WOW Animation -->\r\n");
      out.write("    <script src=\"js/wow.min.js\"></script>\r\n");
      out.write("\t\t<!--Activating WOW Animation only for modern browser-->\r\n");
      out.write("\t\t<!--[if !IE]><!-->\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">new WOW().init();</script>\r\n");
      out.write("\t\t<!--<![endif]-->\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!--Oh Yes, IE 9+ Supports animation, lets activate for IE 9+-->\r\n");
      out.write("\t\t<!--[if gte IE 9]>\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">new WOW().init();</script>\r\n");
      out.write("\t\t<![endif]-->\t\t \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!--Opacity & Other IE fix for older browser-->\r\n");
      out.write("\t\t<!--[if lte IE 8]>\r\n");
      out.write("\t\t\t<script type=\"text/javascript\" src=\"js/ie-opacity-polyfill.js\"></script>\r\n");
      out.write("\t\t<![endif]-->\t    \r\n");
      out.write("    \r\n");
      out.write("    <!-- jQuery main script -->\r\n");
      out.write("    <script src=\"js/main.js\"></script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
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
