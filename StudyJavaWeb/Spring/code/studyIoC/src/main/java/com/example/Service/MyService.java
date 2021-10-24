package com.example.Service;

import com.example.Repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 叶意
 * @ClassName MyService
 * @Description TODO
 * @createTime 2021年10月21日  20:46:00
 */
@Service
public class MyService {
    @Autowired
    private MyRepository myRepository;

    public String getGrade(String name){
        Double score = myRepository.getScore(name);
        String grade = "";
        if(score < 60) {
            grade = "不及格";
        }
        else if (score < 80) {
            grade = "及格";
        } else {
            grade = "优秀";
        }
        return grade;
    }
}
