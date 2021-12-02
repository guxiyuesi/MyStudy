package com.guxiyuesi.aggregate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 叶意
 * @ClassName MyHandler
 * @Description TODO
 * @createTime 2021年10月26日  16:44:00
 */
@Controller
@RequestMapping("/myHandler")
public class MyHandler {
    @RequestMapping(value = "/myList", method = RequestMethod.POST)
    @ResponseBody
    public String myList(UserList users) {
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : users.getUsers()) {
            stringBuilder.append(user.toString() + "<br/>");
        }
        return stringBuilder.toString();
    }

    @RequestMapping(value = "/myMap", method = RequestMethod.POST)
    @ResponseBody
    public String myMap(UserMap userMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (User user :
                userMap.getUsers().values()) {
            stringBuilder.append(user.toString() + "<br/>");
        }
        return stringBuilder.toString();
    }
}
