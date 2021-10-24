package com.example.Controller;

import com.example.Service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * @author 叶意
 * @ClassName MyController
 * @Description TODO
 * @createTime 2021年10月21日  20:43:00
 */
@Controller
public class MyController {
    @Autowired
    private MyService myService;

    public String service(String name) {
        return myService.getGrade(name);
    }


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-grade.xml");
        MyController myController = applicationContext.getBean(MyController.class);
        System.out.println(myController.service("李四"));
    }
}
