/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-10-26 12:07:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/page/login/../commons/messageModals.jsp", Long.valueOf(1540546160000L));
    _jspx_dependants.put("/WEB-INF/page/login/../commons/commons.jsp", Long.valueOf(1540546160000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--Success Modal Templates-->\r\n");
      out.write("    <div id=\"modal-success\" class=\"modal modal-message modal-success fade\" style=\"display: none;\" aria-hidden=\"true\">\r\n");
      out.write("        <div class=\"modal-dialog\">\r\n");
      out.write("            <div class=\"modal-content\">\r\n");
      out.write("                <div class=\"modal-header\">\r\n");
      out.write("                    <i class=\"glyphicon glyphicon-check\"></i>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-title\" id=\"modal-title-success\">Success</div>\r\n");
      out.write("\r\n");
      out.write("<!--                 <div class=\"modal-body\">You have done great!</div> -->\r\n");
      out.write("                <div class=\"modal-footer\">\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-success\" data-dismiss=\"modal\">OK</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div> <!-- / .modal-content -->\r\n");
      out.write("        </div> <!-- / .modal-dialog -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--End Success Modal Templates-->\r\n");
      out.write("    <!--Info Modal Templates-->\r\n");
      out.write("    <div id=\"modal-info\" class=\"modal modal-message modal-info fade\" style=\"display: none;\" aria-hidden=\"true\">\r\n");
      out.write("        <div class=\"modal-dialog\">\r\n");
      out.write("            <div class=\"modal-content\">\r\n");
      out.write("                <div class=\"modal-header\">\r\n");
      out.write("                    <i class=\"fa fa-envelope\"></i>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-title\" id=\"modal-title-info\">Alert</div>\r\n");
      out.write("\r\n");
      out.write("<!--                 <div class=\"modal-body\">You'vd got mail!</div> -->\r\n");
      out.write("                <div class=\"modal-footer\">\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-info\" data-dismiss=\"modal\">OK</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div> <!-- / .modal-content -->\r\n");
      out.write("        </div> <!-- / .modal-dialog -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--End Info Modal Templates-->\r\n");
      out.write("    <!--Danger Modal Templates-->\r\n");
      out.write("    <div id=\"modal-danger\" class=\"modal modal-message modal-danger fade\" style=\"display: none;\" aria-hidden=\"true\">\r\n");
      out.write("        <div class=\"modal-dialog\">\r\n");
      out.write("            <div class=\"modal-content\">\r\n");
      out.write("                <div class=\"modal-header\">\r\n");
      out.write("                    <i class=\"glyphicon glyphicon-fire\"></i>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-title\" id=\"modal-title-danger\">Alert</div>\r\n");
      out.write("\r\n");
      out.write("<!--                 <div class=\"modal-body\">You'vd done bad!</div> -->\r\n");
      out.write("                <div class=\"modal-footer\">\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">OK</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div> <!-- / .modal-content -->\r\n");
      out.write("        </div> <!-- / .modal-dialog -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--End Danger Modal Templates-->\r\n");
      out.write("    <!--Danger Modal Templates-->\r\n");
      out.write("    <div id=\"modal-warning\" class=\"modal modal-message modal-warning fade\" style=\"display: none;\" aria-hidden=\"true\">\r\n");
      out.write("        <div class=\"modal-dialog\">\r\n");
      out.write("            <div class=\"modal-content\">\r\n");
      out.write("                <div class=\"modal-header\">\r\n");
      out.write("                    <i class=\"fa fa-warning\"></i>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-title\" id=\"modal-title-warning\">Warning</div>\r\n");
      out.write("\r\n");
      out.write("<!--                 <div class=\"modal-body\">Is something wrong?</div> -->\r\n");
      out.write("                <div class=\"modal-footer\">\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-warning\" data-dismiss=\"modal\">OK</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div> <!-- / .modal-content -->\r\n");
      out.write("        </div> <!-- / .modal-dialog -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--End Danger Modal Templates-->\r\n");
      out.write("    \r\n");
      out.write("    <script>\r\n");
      out.write("    \tfunction successAlert(message){\r\n");
      out.write("    \t\t$('#modal-title-success').html(message);\r\n");
      out.write("    \t\t$('#modal-success').modal('toggle')\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \tfunction infoAlert(message){\r\n");
      out.write("    \t\t$('#modal-title-info').html(message);\r\n");
      out.write("    \t\t$('#modal-info').modal('toggle')\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \tfunction dangerAlert(message){\r\n");
      out.write("    \t\t$('#modal-title-danger').html(message);\r\n");
      out.write("    \t\t$('#modal-danger').modal('toggle')\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \tfunction warningAlert(message){\r\n");
      out.write("    \t\t$('#modal-title-warning').html(message);\r\n");
      out.write("    \t\t$('#modal-warning').modal('toggle')\r\n");
      out.write("    \t}\r\n");
      out.write("    </script>");
      out.write('\r');
      out.write('\n');
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/page/login/../commons/commons.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("ctx");
      // /WEB-INF/page/login/../commons/commons.jsp(6,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(request.getContextPath());
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      out.write("\r\n");
      out.write(" <link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/img/favicon.png\" type=\"image/x-icon\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/jedate/jedate.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/js/jquery-2.0.3.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/js/jquery.form.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!--Basic Styles-->\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/css/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link id=\"bootstrap-rtl-link\" href=\"\" rel=\"stylesheet\" />\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/css/font-awesome.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/css/weather-icons.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/css/fileinput.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <!--Fonts-->\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,600,700,300\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write(" \t\r\n");
      out.write(" \t<!--Bootstrap Date Picker-->\r\n");
      out.write(" \t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/js/datetime/bootstrap-datepicker.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/js/validation/bootstrapValidator.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("    <!--Beyond styles-->\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/css/beyond.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/css/demo.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/css/typicons.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/css/animate.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link id=\"skin-link\" href=\"\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("    <!--Page Related styles-->\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/css/dataTables.bootstrap.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/js/skins.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/js/jquery.form.js\"></script>\r\n");
      out.write("    <!-- å¾çä¸ä¼  -->\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/js/upload/uploadPic.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/js/upload/fileinput.min.js\" </script>\r\n");
      out.write("    \r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/assets/js/bootbox/bootbox.js\"></script>\r\n");
      out.write("    <style>\r\n");
      out.write("    \t.page-body{\r\n");
      out.write("    \t\tpadding-top: 0px;\r\n");
      out.write("    \t\tpadding-left: 0px;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t.widget{\r\n");
      out.write("    \t\tpadding-left: 0px;\r\n");
      out.write("    \t}\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<!--Head-->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//如果不是顶级窗口，则先获取顶级窗口，再跳转到登录界面\r\n");
      out.write("\tif(!(window.parent == window)){\r\n");
      out.write("\t\tvar topWin= (function (p,c){\r\n");
      out.write("\t\t    while(p!=c){\r\n");
      out.write("\t\t        c = p        \r\n");
      out.write("\t\t        p = p.parent\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    return c\r\n");
      out.write("\t\t})(window.parent,window);\r\n");
      out.write("\t\ttopWin.location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("' + \"/welcome.do\";\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"https://cdn.bootcss.com/jquery/1.8.1/jquery.min.js\"></script>\r\n");
      out.write("<head>\r\n");
      out.write("<title>登录</title>\r\n");
      out.write("  <style>\r\n");
      out.write("    body {\r\n");
      out.write("      background: #16a085;\r\n");
      out.write("      font-family: 'Montserrat', sans-serif;\r\n");
      out.write("      color: #fff;\r\n");
      out.write("      line-height: 1.3;\r\n");
      out.write("      -webkit-font-smoothing: antialiased;\r\n");
      out.write("    }\r\n");
      out.write("  html, body {\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    height: 100%;\r\n");
      out.write("    overflow: hidden;\r\n");
      out.write("  }\r\n");
      out.write("  #particles {\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    position: fixed;\r\n");
      out.write("    height: 100%;\r\n");
      out.write("    overflow: hidden;\r\n");
      out.write("    top: 0;\r\n");
      out.write("    left: 0;\r\n");
      out.write("    background-color: #16a085;\r\n");
      out.write("    z-index: -1;\r\n");
      out.write("  }\r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("<!--Head Ends-->\r\n");
      out.write("<!--Body-->\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"login-container animated fadeInDown\">\r\n");
      out.write("\t\t<div class=\"loginbox bg-white\" style=\"height: 220px!important;top: 180px;\">\r\n");
      out.write("\t\t\t<div class=\"loginbox-title\">登录</div>\r\n");
      out.write("\t\t\t<div class=\"loginbox-textbox\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"phone\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"passport\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"loginbox-textbox\">\r\n");
      out.write("\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"password\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"Password\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"loginbox-forgot\">\r\n");
      out.write("\t\t\t\t<span class=\"error_msg\" style=\"color:red\"> </span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"loginbox-submit\" >\r\n");
      out.write("\t\t\t\t<input type=\"button\" class=\"btn btn-primary btn-block\" value=\"Login\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("<!-- \t\t\t<div class=\"loginbox-signup\"> -->\r\n");
      out.write("<!-- \t\t\t\t<a href=\"register.html\">Forgot Password?</a> -->\r\n");
      out.write("<!-- \t\t\t</div> -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<img alt=\"\" src=\"static/assets/img/gwht.png\" style=\"\r\n");
      out.write("    position: fixed;\r\n");
      out.write("    vertical-align: middle;\r\n");
      out.write("    top: 20%;\r\n");
      out.write("    left: 50%;\r\n");
      out.write("    margin-left: -352px;\r\n");
      out.write("\">\r\n");
      out.write("<div id=\"particles\"></div>\r\n");
      out.write("  <script>\r\n");
      out.write("!function(a){function b(b,d){function e(){if(w){$canvas=a('<canvas class=\"pg-canvas\"></canvas>'),v.prepend($canvas),p=$canvas[0],q=p.getContext(\"2d\"),f();for(var b=Math.round(p.width*p.height/d.density),c=0;b>c;c++){var e=new l;e.setStackPos(c),x.push(e)}a(window).on(\"resize\",function(){h()}),a(document).on(\"mousemove\",function(a){y=a.pageX,z=a.pageY}),B&&!A&&window.addEventListener(\"deviceorientation\",function(){D=Math.min(Math.max(-event.beta,-30),30),C=Math.min(Math.max(-event.gamma,-30),30)},!0),g(),o(\"onInit\")}}function f(){p.width=v.width(),p.height=v.height(),q.fillStyle=d.dotColor,q.strokeStyle=d.lineColor,q.lineWidth=d.lineWidth}function g(){if(w){s=a(window).width(),t=a(window).height(),q.clearRect(0,0,p.width,p.height);for(var b=0;b<x.length;b++)x[b].updatePosition();for(var b=0;b<x.length;b++)x[b].draw();E||(r=requestAnimationFrame(g))}}function h(){for(f(),i=x.length-1;i>=0;i--)(x[i].position.x>v.width()||x[i].position.y>v.height())&&x.splice(i,1);var a=Math.round(p.width*p.height/d.density);if(a>x.length)for(;a>x.length;){var b=new l;x.push(b)}else a<x.length&&x.splice(a);for(i=x.length-1;i>=0;i--)x[i].setStackPos(i)}function j(){E=!0}function k(){E=!1,g()}function l(){switch(this.stackPos,this.active=!0,this.layer=Math.ceil(3*Math.random()),this.parallaxOffsetX=0,this.parallaxOffsetY=0,this.position={x:Math.ceil(Math.random()*p.width),y:Math.ceil(Math.random()*p.height)},this.speed={},d.directionX){case\"left\":this.speed.x=+(-d.maxSpeedX+Math.random()*d.maxSpeedX-d.minSpeedX).toFixed(2);break;case\"right\":this.speed.x=+(Math.random()*d.maxSpeedX+d.minSpeedX).toFixed(2);break;default:this.speed.x=+(-d.maxSpeedX/2+Math.random()*d.maxSpeedX).toFixed(2),this.speed.x+=this.speed.x>0?d.minSpeedX:-d.minSpeedX}switch(d.directionY){case\"up\":this.speed.y=+(-d.maxSpeedY+Math.random()*d.maxSpeedY-d.minSpeedY).toFixed(2);break;case\"down\":this.speed.y=+(Math.random()*d.maxSpeedY+d.minSpeedY).toFixed(2);break;default:this.speed.y=+(-d.maxSpeedY/2+Math.random()*d.maxSpeedY).toFixed(2),this.speed.x+=this.speed.y>0?d.minSpeedY:-d.minSpeedY}}function m(a,b){return b?void(d[a]=b):d[a]}function n(){v.find(\".pg-canvas\").remove(),o(\"onDestroy\"),v.removeData(\"plugin_\"+c)}function o(a){void 0!==d[a]&&d[a].call(u)}var p,q,r,s,t,u=b,v=a(b),w=!!document.createElement(\"canvas\").getContext,x=[],y=0,z=0,A=!navigator.userAgent.match(/(iPhone|iPod|iPad|Android|BlackBerry|BB10|mobi|tablet|opera mini|nexus 7)/i),B=!!window.DeviceOrientationEvent,C=0,D=0,E=!1;return d=a.extend({},a.fn[c].defaults,d),l.prototype.draw=function(){q.beginPath(),q.arc(this.position.x+this.parallaxOffsetX,this.position.y+this.parallaxOffsetY,d.particleRadius/2,0,2*Math.PI,!0),q.closePath(),q.fill(),q.beginPath();for(var a=x.length-1;a>this.stackPos;a--){var b=x[a],c=this.position.x-b.position.x,e=this.position.y-b.position.y,f=Math.sqrt(c*c+e*e).toFixed(2);f<d.proximity&&(q.moveTo(this.position.x+this.parallaxOffsetX,this.position.y+this.parallaxOffsetY),d.curvedLines?q.quadraticCurveTo(Math.max(b.position.x,b.position.x),Math.min(b.position.y,b.position.y),b.position.x+b.parallaxOffsetX,b.position.y+b.parallaxOffsetY):q.lineTo(b.position.x+b.parallaxOffsetX,b.position.y+b.parallaxOffsetY))}q.stroke(),q.closePath()},l.prototype.updatePosition=function(){if(d.parallax){if(B&&!A){var a=(s-0)/60;pointerX=(C- -30)*a+0;var b=(t-0)/60;pointerY=(D- -30)*b+0}else pointerX=y,pointerY=z;this.parallaxTargX=(pointerX-s/2)/(d.parallaxMultiplier*this.layer),this.parallaxOffsetX+=(this.parallaxTargX-this.parallaxOffsetX)/10,this.parallaxTargY=(pointerY-t/2)/(d.parallaxMultiplier*this.layer),this.parallaxOffsetY+=(this.parallaxTargY-this.parallaxOffsetY)/10}switch(d.directionX){case\"left\":this.position.x+this.speed.x+this.parallaxOffsetX<0&&(this.position.x=v.width()-this.parallaxOffsetX);break;case\"right\":this.position.x+this.speed.x+this.parallaxOffsetX>v.width()&&(this.position.x=0-this.parallaxOffsetX);break;default:(this.position.x+this.speed.x+this.parallaxOffsetX>v.width()||this.position.x+this.speed.x+this.parallaxOffsetX<0)&&(this.speed.x=-this.speed.x)}switch(d.directionY){case\"up\":this.position.y+this.speed.y+this.parallaxOffsetY<0&&(this.position.y=v.height()-this.parallaxOffsetY);break;case\"down\":this.position.y+this.speed.y+this.parallaxOffsetY>v.height()&&(this.position.y=0-this.parallaxOffsetY);break;default:(this.position.y+this.speed.y+this.parallaxOffsetY>v.height()||this.position.y+this.speed.y+this.parallaxOffsetY<0)&&(this.speed.y=-this.speed.y)}this.position.x+=this.speed.x,this.position.y+=this.speed.y},l.prototype.setStackPos=function(a){this.stackPos=a},e(),{option:m,destroy:n,start:k,pause:j}}var c=\"particleground\";a.fn[c]=function(d){if(\"string\"==typeof arguments[0]){var e,f=arguments[0],g=Array.prototype.slice.call(arguments,1);return this.each(function(){a.data(this,\"plugin_\"+c)&&\"function\"==typeof a.data(this,\"plugin_\"+c)[f]&&(e=a.data(this,\"plugin_\"+c)[f].apply(this,g))}),void 0!==e?e:this}return\"object\"!=typeof d&&d?void 0:this.each(function(){a.data(this,\"plugin_\"+c)||a.data(this,\"plugin_\"+c,new b(this,d))})},a.fn[c].defaults={minSpeedX:.1,maxSpeedX:.7,minSpeedY:.1,maxSpeedY:.7,directionX:\"center\",directionY:\"center\",density:1e4,dotColor:\"#666666\",lineColor:\"#666666\",particleRadius:7,lineWidth:1,curvedLines:!1,proximity:100,parallax:!0,parallaxMultiplier:5,onInit:function(){},onDestroy:function(){}}}(jQuery),\r\n");
      out.write("function(){for(var a=0,b=[\"ms\",\"moz\",\"webkit\",\"o\"],c=0;c<b.length&&!window.requestAnimationFrame;++c)window.requestAnimationFrame=window[b[c]+\"RequestAnimationFrame\"],window.cancelAnimationFrame=window[b[c]+\"CancelAnimationFrame\"]||window[b[c]+\"CancelRequestAnimationFrame\"];window.requestAnimationFrame||(window.requestAnimationFrame=function(b){var c=(new Date).getTime(),d=Math.max(0,16-(c-a)),e=window.setTimeout(function(){b(c+d)},d);return a=c+d,e}),window.cancelAnimationFrame||(window.cancelAnimationFrame=function(a){clearTimeout(a)})}();\r\n");
      out.write("  </script>\t\r\n");
      out.write("<script>\r\n");
      out.write("  $(document).ready(function() {\r\n");
      out.write("  $('#particles').particleground({\r\n");
      out.write("    dotColor: '#5cbdaa',\r\n");
      out.write("    lineColor: '#5cbdaa'\r\n");
      out.write("  });\r\n");
      out.write("  $('.intro').css({\r\n");
      out.write("      'margin-top': -($('.intro').height() / 2)\r\n");
      out.write("    });\r\n");
      out.write("  });\r\n");
      out.write("</script>\r\n");
      out.write("\t<!--Google Analytics::Demo Only-->\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$(\"body\").keydown(function() {\r\n");
      out.write("\t\t\t\t    if (event.keyCode == \"13\") {//keyCode=13是回车键\r\n");
      out.write("\t\t\t\t        $('.btn-block').click();\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t});  \r\n");
      out.write("        (function (i, s, o, g, r, a, m) {\r\n");
      out.write("            i['GoogleAnalyticsObject'] = r; i[r] = i[r] || function () {\r\n");
      out.write("                (i[r].q = i[r].q || []).push(arguments)\r\n");
      out.write("            }, i[r].l = 1 * new Date(); a = s.createElement(o),\r\n");
      out.write("            m = s.getElementsByTagName(o)[0]; a.async = 1; a.src = g; m.parentNode.insertBefore(a, m)\r\n");
      out.write("        })(window, document, 'script', 'http://www.google-analytics.com/analytics.js', 'ga');\r\n");
      out.write("\r\n");
      out.write("        ga('create', 'UA-52103994-1', 'auto');\r\n");
      out.write("        ga('send', 'pageview');\r\n");
      out.write("\t\t\r\n");
      out.write("         \t       // 请求搜狐获取用户ip和地区\r\n");
      out.write("    /* $.ajax({\r\n");
      out.write("        cache: true,\r\n");
      out.write("        dataType: 'jsonp',\r\n");
      out.write("        jsonp: 'callback',\r\n");
      out.write("        url: \"https://pv.sohu.com/cityjson?ie=utf-8\",\r\n");
      out.write("        data: '',\r\n");
      out.write("        async: false,\r\n");
      out.write("        error: function(request) {\r\n");
      out.write("            // console.log('失败了')\r\n");
      out.write("            // console.log(returnCitySN);\r\n");
      out.write("        },\r\n");
      out.write("        success: function(data) {\r\n");
      out.write("            // console.log('成功')\r\n");
      out.write("            // console.log(returnCitySN)\r\n");
      out.write("        }\r\n");
      out.write("    }); */\r\n");
      out.write("        \r\n");
      out.write("        $('.btn-block').click(function(){        \t\r\n");
      out.write("        \tvar phone = $('#phone').val();\r\n");
      out.write("        \tvar password = $('#password').val();\r\n");
      out.write("        \tif(!phone){\r\n");
      out.write("        \t\t$('.error_msg').html('帐号不能为空！');\r\n");
      out.write("        \t\treturn false;\r\n");
      out.write("        \t}\r\n");
      out.write("        \tif(!password){\r\n");
      out.write("        \t\t$('.error_msg').html('密码不能为空！');\r\n");
      out.write("        \t\treturn false;\r\n");
      out.write("        \t}\r\n");
      out.write("        \t\r\n");
      out.write(" \r\n");
      out.write("        \t\r\n");
      out.write("        \tvar sendData = {\r\n");
      out.write("    \t\t\t\t\"passport\": phone,\r\n");
      out.write("    \t\t\t\t\"passwd\": password,\r\n");
      out.write("    \t\t\t\t/* \"ip\": returnCitySN.cip */\r\n");
      out.write("    \t\t\t};\r\n");
      out.write("    \t\t\t$.post(\"getLogin.do\",sendData, function(backData) {\r\n");
      out.write("    \t\t\t\tif(backData.status == 1){\r\n");
      out.write("    \t\t\t\t\twindow.location.href = \"home.do\";\r\n");
      out.write("    \t\t\t\t} else{\r\n");
      out.write("    \t\t\t\t\t$('.error_msg').html(backData.message[0].msg);\r\n");
      out.write("    \t\t\t\t}\r\n");
      out.write("    \t\t\t});\r\n");
      out.write("    \t\t  \r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("<!--Body Ends-->\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}