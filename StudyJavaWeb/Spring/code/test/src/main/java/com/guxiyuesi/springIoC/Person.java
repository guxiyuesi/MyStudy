package com.guxiyuesi.springIoC;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 叶意
 * @ClassName Person
 * @Description TODO
 * @createTime 2021年10月20日  19:43:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String name;
    private Car car2;
}
