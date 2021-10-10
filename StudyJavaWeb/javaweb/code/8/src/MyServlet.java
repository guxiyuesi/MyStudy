import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/check")
public class MyServlet extends HttpServlet {
    private Set<String> names;

    public MyServlet() {
        names = new HashSet<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        if(names.contains(name)) {
            resp.getWriter().write("该用户名已被注册!");
        } else {
            resp.getWriter().write("该用户名可用");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if(names.contains(names)) {
            resp.getWriter().write("注册失败");
        } else {
            names.add(name);
            resp.getWriter().write(name);
        }
    }
}
