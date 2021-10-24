package com.iocAnnotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 叶意
 * @ClassName Score
 * @Description TODO
 * @createTime 2021年10月21日  18:44:00
 */

@Data
@Component(value = "myScore")
public class Score {
    @Value("78.0")
    private float englishScore;
    @Value("88.5")
    private float mathScore;
}
