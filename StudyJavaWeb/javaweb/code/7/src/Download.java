import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/download")
public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应头, 调用下载器
        resp.setContentType("application/x-msdownload");
        String fileName = "test.html";
        resp.setHeader("Content-Disposition", "attachment;filename:"+fileName);
        //获取存储路径
        String path = req.getServletContext().getRealPath("/file/"+fileName);
        //输入输出流
        InputStream inputStream = new FileInputStream(path);
        OutputStream outputStream = resp.getOutputStream();
        //直接使用IOUtils工具类将输入流的内容通过输出流写入到响应中
        IOUtils.copy(inputStream, outputStream);
    }
}
