package com.itlaoqi.springbootweb.controller;

import com.itlaoqi.springbootweb.entity.Dept;
import com.itlaoqi.springbootweb.entity.Emp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WebController {
    Logger logger = LoggerFactory.getLogger(WebController.class);
    private List<Emp> emps = new ArrayList<Emp>();
    private List<Dept> depts = new ArrayList<Dept>();

    public WebController() {
        emps.add(new Emp(7782, "CLARK", "DEVELOPER", "2017-01-02", 7780f, "RESEARCH"));
        emps.add(new Emp(7839, "KING", "CSO", "2018-03-04", 8820f, "SALES"));
        depts.add(new Dept(10,"REASERCH" , "2017-10-07"));
        depts.add(new Dept(20,"SALES" , "2015-12-01"));
        depts.add(new Dept(30,"ACCOUNTING" , "2013-03-02"));
    }
    /*
        常规配置，环境变量
        Spring MVC + thymeleaf 上下文取值
        AJAX
        文件上传
        输入日期格式的转换
        更换tomcat配置->Jetty
        注册Filter 日志打印
        自动跳转 404、500
        启动时加载Listener
    */

}
