package indi.guxiyuesi.studyServlet;

import java.lang.reflect.Constructor;

/* 运行时报错: Exception in thread "main" java.lang.NoClassDefFoundError: javax/servlet/Servlet
* 原因: javax/servlet/Servlet 在Tomcat的库下, javase无法访问, 需要额外导库
* 解决方案:
*   1. 在项目目录/web目录下再创建一个lib目录, 将所需的 servlet-api.jar 包放入其中
*   2. 点击 File -> Product Structure -> Library -> + -> 将lib目录下的 servlet-api.jar 包引入为library
*   之后该程序就可以运行了
* */
public class Main {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("indi.guxiyuesi.studyServlet.FirstServlet");
            Constructor constructor = c.getConstructor();
            FirstServlet fs = (FirstServlet) constructor.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
