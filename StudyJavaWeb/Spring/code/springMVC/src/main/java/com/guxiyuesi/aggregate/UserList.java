package com.guxiyuesi.aggregate;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 叶意
 * @ClassName UserList
 * @Description TODO
 * @createTime 2021年10月26日  16:43:00
 */
    @Data
    public class UserList {
        List<User> users = new ArrayList<>();
    }
