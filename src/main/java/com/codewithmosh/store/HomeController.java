package com.codewithmosh.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/")
    public String index(){
        String viewName = getViewName();
    return viewName;
    }
    @RequestMapping("/page1")
    public String page1(){
        return "page1.html";
    }

    private String getViewName(){
        System.out.println("appName : " + appName);
        return "index.html";
    }
}
