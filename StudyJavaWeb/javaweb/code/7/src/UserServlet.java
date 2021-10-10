import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/info")
public class UserServlet extends HttpServlet {
    Map<Integer, User> users;

    public UserServlet() {
        this.users = new HashMap<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        users.put(1, new User("张三", 1, 66));
        users.put(2, new User("李四", 2, 77));
        users.put(3, new User("王五", 3, 88));
        req.setAttribute("users", users);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String)req.getAttribute("name");
        int id = Integer.parseInt(req.getParameter("id"));
        int score = Integer.parseInt(req.getParameter("score"));
        users.put(id, new User(name, id, score));
        req.setAttribute("users", users);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
