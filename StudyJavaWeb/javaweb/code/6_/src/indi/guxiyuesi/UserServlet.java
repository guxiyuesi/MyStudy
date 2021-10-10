package indi.guxiyuesi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**前后端交互类 UserServlet类*/
@WebServlet("/index")
public class UserServlet extends HttpServlet {
    /** users 保存用户信息, 用来在request中保存后进入其他jsp界面
     *  无论UserServlet类被访问几次, users只创建一次, 因为UserServlet是单例模式
     * */
    private Map<Integer, User> users;

    /** 初始化users中的参数 模拟从数据库中取值
     * */
    public  UserServlet() {
        users = new HashMap<>();
        users.put(1, new User(1, "张三", 86));
        users.put(2, new User(2, "李四", 78));
        users.put(3, new User(3, "王五", 10));
    }

    /** doGet 类主要负责浏览器 或 a标签提交的请求
     * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码形式, 防止乱码
        req.setCharacterEncoding("UTF-8");
        //获取请求中的method参数, 如果为null, 赋予默认值为findAll
        String method = req.getParameter("method");
        if(method == null) {
            method = "findAll";
        }

        /** method == findAll : 展示数据
         *  method == add : 进入添加数据界面
         *  method == delete : 直接删除数据并展示删除后的数据
         *  method == update : 进入修改数据界面
         * */
        if(method.equals("findAll")) {
            req.setAttribute("users", users);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else if(method.equals("add")) {
            resp.sendRedirect("add.jsp");
        } else if(method.equals("delete")) {
            int key = Integer.parseInt(req.getParameter("key"));
            users.remove(key);
            resp.sendRedirect("/index");
        } else if(method.equals("update")) {
            int key = Integer.parseInt(req.getParameter("key"));
            User user = users.get(key);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/update.jsp").forward(req, resp);
        }
    }

    /** doPost 主要负责从表单中传递的数据*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id =req.getParameter("id");
        String name = req.getParameter("name");
        String age =req.getParameter("age");
        try {
            users.put(Integer.parseInt(id), new User(Integer.parseInt(id), name, Integer.parseInt(age)));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //重新进入并展示添加或修改后的数据
            resp.sendRedirect("/index");
        }

    }
}
