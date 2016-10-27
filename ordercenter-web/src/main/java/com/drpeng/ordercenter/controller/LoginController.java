package com.drpeng.ordercenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yuyang on 2016/10/13 0013.
 */
@Controller
public class LoginController {
    @RequestMapping("/")
    public String login(Model mode){
        return"login";
    }
    @RequestMapping("/menu")
    public String menu(Model mode){
        return"menu";

    }

}
