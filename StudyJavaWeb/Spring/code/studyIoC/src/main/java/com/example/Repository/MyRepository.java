package com.example.Repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 叶意
 * @ClassName MyRepository
 * @Description TODO
 * @createTime 2021年10月21日  20:43:00
 */
@Repository
public class MyRepository {
    private Map<String, Double> score;
    MyRepository() {
        score = new HashMap<>();
        score.put("张三", 61.0);
        score.put("李四", 73.4);
    }

    public Double getScore(String name) {
        return score.get(name);
    }
}
