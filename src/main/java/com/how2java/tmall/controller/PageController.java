package com.how2java.tmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class PageController {
    @RequestMapping("registerPage")
    public String registerPage() {
        return "fore/register";
    }
    @RequestMapping("registerSuccessPage")
    public String registerSuccessPage() {
        return "fore/registerSuccess";
    }
    @RequestMapping("loginPage")
    public String loginPage() { return "fore/login"; }
    @RequestMapping("forealipay")
    public String alipay(){
        return "fore/alipay";
    }
    @RequestMapping("changePassWd")
    public String changePassWd(){return "fore/changePassWd";}


    // 商家登陆
    @RequestMapping("loginPageSeller")
    public String loginPageSeller(){return "fore/loginSeller";}
    // 商家注册
    @RequestMapping("registerPageSeller")
    public String registerPageSeller(){return "fore/registerSeller";}
}
