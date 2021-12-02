package com.guxiyuesi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author 叶意
 * @ClassName HelloHandler
 * @Description TODO
 * @createTime 2021年10月24日  15:15:00
 */

@Controller
@RequestMapping(value = "/myTest")
public class HelloHandler {
    //配置浏览器进入该方法的路径 相当于@WebServlet
    @RequestMapping( value = "/index/{name}/{id}", method = RequestMethod.GET)
    public String index(@PathVariable("name") String myName, @PathVariable("id") Integer id) {
        System.out.println("name="+myName + "  id=" + id);
        return "index";
    }

    @RequestMapping( value = "/cookie", method = RequestMethod.GET)
    public String myCookie(@CookieValue("JSESSIONID") String sessionID) {
        System.out.println(sessionID);
        return "index";
    }

    @RequestMapping(value = "/pojo")
    @ResponseBody
    public String myPOJO(User user) {
        System.out.println(user);
        return user.toString();
    }

    @RequestMapping(value = "/forward")
    public String forwardRespond() {
        return "forward:/index.jsp";
    }

    @RequestMapping(value = "/redirect")
    public String redirectRespond(){
        return "redirect:/index.jsp";
    }

    @RequestMapping("/arrayType")
    @ResponseBody
    public String arrayType(String[] names){
        StringBuilder stringBuilder = new StringBuilder();
        for (String name:names) {
            stringBuilder.append(name + " ");
        }
        return stringBuilder.toString();
    }
}
