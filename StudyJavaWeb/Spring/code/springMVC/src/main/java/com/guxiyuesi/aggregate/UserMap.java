package com.guxiyuesi.aggregate;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 叶意
 * @ClassName UserMap
 * @Description TODO
 * @createTime 2021年10月26日  17:12:00
 */
@Data
public class UserMap {
    private Map<String, User> users = new HashMap<>();
}
