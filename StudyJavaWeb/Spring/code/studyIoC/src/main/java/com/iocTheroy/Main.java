package com.iocTheroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 叶意
 * @ClassName Main
 * @Description TODO
 * @createTime 2021年10月21日  16:41:00
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new MyApplicationContextImplement();
        Student student = (Student) applicationContext.getBean("student");
        Score score = (Score) applicationContext.getBean("score");
        System.out.println(score);
    }
}
