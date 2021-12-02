package com.guxiyuesi.aggregate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 叶意
 * @ClassName JsonType
 * @Description TODO
 * @createTime 2021年10月26日  18:01:00
 */
@Controller
@RequestMapping("/jsonType")
public class JsonType {
    @RequestMapping("json")
    @ResponseBody
    public String jsonType(User user) {
        return null;
    }
}
