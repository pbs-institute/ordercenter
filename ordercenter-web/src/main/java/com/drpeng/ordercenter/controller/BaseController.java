package com.drpeng.ordercenter.controller;

import com.drpeng.ordercenter.common.HttpUtil;
import com.drpeng.ordercenter.common.SslInitialize;
import com.drpeng.ordercenter.common.SystemConstants;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

/**
 * Created by yuyang on 2016/10/13 0013.
 */
public class BaseController{
    @Value("${busi.url}")
    public  String busiUrl;
    @Value("${send.key}")
    public  String sendKey;
    public Map sendPost(String url, Map param, String charset) throws Exception {
        HttpClient httpClient = new DefaultHttpClient(); // 创建默认的httpClient实例
        if(sendKey.equals("https")){
            SslInitialize.SslCreate(httpClient);
        }
        Map retMap=  HttpUtil.doPost(url, param,null,httpClient);
        return retMap;
    }
    public Map sendGet(String url, Map param, String charset) throws Exception {
        HttpClient httpClient = new DefaultHttpClient(); // 创建默认的httpClient实例
        if(sendKey.equals("https")){
            SslInitialize.SslCreate(httpClient);
        }
        Map retMap=  HttpUtil.doGet(url, param,null,httpClient);
        return retMap;
    }
}
