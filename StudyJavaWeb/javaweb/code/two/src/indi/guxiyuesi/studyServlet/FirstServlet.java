package indi.guxiyuesi.studyServlet;

import javax.servlet.*;
import java.io.IOException;

public class FirstServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

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
