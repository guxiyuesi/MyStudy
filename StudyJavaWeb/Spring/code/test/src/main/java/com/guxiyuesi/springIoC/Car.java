package com.guxiyuesi.springIoC;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 叶意
 * @ClassName Car
 * @Description TODO
 * @createTime 2021年10月18日  22:36:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int id;
    private String name;
    private String brand;
}
