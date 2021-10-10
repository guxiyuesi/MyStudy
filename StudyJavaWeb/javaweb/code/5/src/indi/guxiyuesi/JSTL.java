package indi.guxiyuesi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/JSTL/index")
public class JSTL extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        users.add(new User("张三", 19, 86));
        users.add(new User("李四", 20, 68));
        users.add(new User("王五", 21, 35));
        users.add(new User("赵六", 22, 99));
        req.setAttribute("users", users);
        req.getRequestDispatcher("/JSTL/index.jsp").forward(req, resp);
    }
}
