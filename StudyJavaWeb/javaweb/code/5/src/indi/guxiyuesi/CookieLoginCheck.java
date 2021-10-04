package indi.guxiyuesi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//登录检查逻辑
@WebServlet("/cookieLogin/check")
public class CookieLoginCheck extends HttpServlet {
    String user = "admin";
    String password = "admin";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("password");
        if(this.user.equals(user) && this.password.equals(password)) {
            Cookie cookie = new Cookie("user", user);
            resp.addCookie(cookie);
            resp.sendRedirect("/cookieLogin/Welcome.jsp");
        } else {
            resp.sendRedirect("/cookieLogin/login.jsp");
        }
    }
}
