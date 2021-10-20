package com.guxiyuesi.springIoC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 叶意
 * @ClassName MainAutowire
 * @Description TODO
 * @createTime 2021年10月20日  19:47:00
 */
public class MainAutowire {
    public static void main(String[] args) {
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("spring-autowire.xml");
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person);
    }
}
