package indi.guxiyuesi;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class Check extends HttpServlet {
    //获取默认账号密码
    String user;
    String password;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //通过初始化函数获取web.xml中保存的默认账号密码
        this.user = config.getInitParameter("user");
        this.password = config.getInitParameter("password");
    }

    //通过doGet方法处理请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求时的参数
        String user = req.getParameter("user");
        String password = req.getParameter("password");

        //如果参数和默认密码相同, 将用户名写入HttpSession对象, 并进入Welcome.jsp页面
        if(this.user.equals(user) && this.password.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            //使用重定向但不会丢失登录状态, 因为账号保存在session中
            resp.sendRedirect("/login/Welcome.jsp");
        } else {
            resp.sendRedirect("/login/login.jsp");
        }
    }
}
