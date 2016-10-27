package com.drpeng.ordercenter.controller;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by yuyang on 2016/10/13 0013.
 */
public class BaseController{
    @Value("${busi.url}")
    public  String busiUrl;
}
