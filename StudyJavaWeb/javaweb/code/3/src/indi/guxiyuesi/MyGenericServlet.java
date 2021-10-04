package indi.guxiyuesi;

import javax.servlet.*;
import java.io.IOException;

//对Servlet接口中的方法做空实现,屏蔽了不重要的方法, 子类只需要重写需要的方法即可
public class MyGenericServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
