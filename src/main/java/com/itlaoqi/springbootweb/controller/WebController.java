package com.itlaoqi.springbootweb.controller;

import com.itlaoqi.springbootweb.entity.Dept;
import com.itlaoqi.springbootweb.entity.Emp;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

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


    // RequestMethod.GET 只有请求访问这个方法，如果是POST则会提示405错误，405是无效的请求
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(){
        // 设置上下文数据，上下文数据说白了就是满足页面中要读取的记录
        /**
         * springmvc中常用的设置上下文有三种：
         * 1.ModeAndView（推荐）
         * 2.Modle
         * 3.WebRequst或者原生的HttpServletRequest对象（不推荐）
         */
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("emps",emps);
        return mav;
    }

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("emps", emps);
        return "index";
    }

    //WebRequest 是对Request对象的包装
    //这两者都是与J2EE容器强耦合，为了将来拓展性需要。不推荐使用
    public String index(WebRequest req, HttpServletRequest request){
        //setAttribute。是向当前的请求中放入对象，这种方式与web容器强耦合
        req.setAttribute("emps",emps);
        request.setAttribute("emps", emps);
        return  null;
    }*/



}
