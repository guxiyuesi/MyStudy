package indi.guxiyuesi.studyServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/demo1")
public class FirstServlet implements Servlet {
    public FirstServlet() {
        System.out.println("创建了FirstServlet对象");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化了FirstServlet对象");
        System.out.println(servletConfig.getServletName());
        Enumeration<String> enumeration = servletConfig.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String s = enumeration.nextElement();
            System.out.println(servletConfig.getInitParameter(s));
        }

        ServletContext sc = servletConfig.getServletContext();
        //获取当前Servlet的虚拟路径 这里为空
        System.out.println(sc.getContextPath());
        //获取运行当前Servlet的Tomcat服务器信息
        System.out.println(sc.getServerInfo());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //接收来自客户端的参数
        String str = servletRequest.getParameter("id");
        //设置响应时的格式和编码
        servletResponse.setContentType("text/HTML; charset=UTF-8");
        //像客户端返回的内容
        servletResponse.getWriter().write("我已接收到客户端请求! 请求id="+str);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
