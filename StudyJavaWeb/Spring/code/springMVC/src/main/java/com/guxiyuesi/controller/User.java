package com.guxiyuesi.controller;

import lombok.Data;

/**
 * @author 叶意
 * @ClassName User
 * @Description TODO
 * @createTime 2021年10月24日  16:44:00
 */

@Data
public class User {
    private String name;
    private int id;
    private Address address;
}
