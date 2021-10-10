import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/file")
public class FileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String text = req.getParameter("text");
//        System.out.println(text);
//        InputStream inputStream = req.getInputStream();
//        //读取时防止乱码: InputStream 转为 Reader时指定编码格式为 UTF-8
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
//        String path = req.getServletContext().getRealPath("file/copy.txt");
//        OutputStream outputStream = new FileOutputStream(path);
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
//        String str = "";
//        while ((str=bufferedReader.readLine()) != null) {
//            bufferedWriter.write(str + "\n");
//        }
//        bufferedReader.close();
//        inputStream.close();
//        bufferedWriter.close();
//        outputStream.close();

        //判断是否是多段数据
        if(ServletFileUpload.isMultipartContent(req)) {
            //是多段数据
            //创建FileItemFactory的工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload的实例对象
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                //解析上传的数据
                List<FileItem> fileItems = servletFileUpload.parseRequest(req);

                //对于多个表单项, 逐个判断是否是文件
                for (FileItem fileItem:fileItems) {
                    if(fileItem.isFormField()) {
                        //是普通表单项
                        System.out.println("表单项属性名: " + fileItem.getFieldName());
                        System.out.println("表单内容: " + fileItem.getString("UTF-8"));
                    }
                    else {
                        //是上传的文件
                        System.out.println("表单项属性名: " + fileItem.getFieldName());
                        System.out.println("上传的文件名: " + fileItem.getName());
                        //将上传的文件保存到硬盘中
                        String path = req.getServletContext().getRealPath("file/" + fileItem.getName());
                        fileItem.write(new File(path));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
