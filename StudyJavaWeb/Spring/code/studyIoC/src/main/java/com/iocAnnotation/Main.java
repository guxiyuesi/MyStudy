package com.iocAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 叶意
 * @ClassName Main
 * @Description TODO
 * @createTime 2021年10月21日  18:41:00
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-annotation.xml");
        Student student = applicationContext.getBean(Student.class);
        System.out.println(student);
    }
}
