package com.iocAnnotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @author 叶意
 * @ClassName Student
 * @Description TODO
 * @createTime 2021年10月21日  18:39:00
 */
@Data
@Component
public class Student {
    @Value("1")
    private int id;
    @Value("张三")
    private String name;
    @Autowired
    @Qualifier(value = "myScore")
    private Score score;
}
