package com.drpeng.ordercenter.common;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.*;
import java.io.*;
import java.util.Map;

/**
 * Created by yuyang on 2016/10/26 0026.
 */
public class HttpUtil {
    private static Logger log = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 组装参数
     *
     * @param map
     * @return
     */
    public static String getParam(Map map) {
        StringBuffer param = new StringBuffer();
        int i = 0;
        for (Object key : map.keySet()) {
            i++;
            if (i < map.size()) {
                param.append(key).append("=").append(map.get(key)).append("&");
            } else {
                param.append(key).append("=").append(map.get(key));
            }
        }
        System.out.println(param.toString());
        return param.toString();
    }

    /**
     * HTTP POST请求
     * @param url
     * @param param
     * @param charset
     * @return
     * @throws Exception
     */
    public  static Map doPost(String url, Map param, String charset) throws Exception {

        if (charset == null || charset == "") {
            charset = "UTF-8";
        }

        long responseLength = 0; // 响应长度
        String responseContent = null; // 响应内容
        HttpClient httpClient = new DefaultHttpClient(); // 创建默认的httpClient实例
        String urlParam= getParam(param);
        url= url+"?"+urlParam;
        try {
            // post请求
            HttpPost httpPost = new HttpPost(url);
            StringEntity postEntity;
            postEntity = new StringEntity(param.toString(), charset);
            httpPost.setEntity(postEntity);
            // 执行POST请求
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                responseLength = entity.getContentLength();
                responseContent = EntityUtils.toString(entity, charset);
                EntityUtils.consume(entity); // Consume response content
            }
            if (log.isDebugEnabled()) {
                log.debug("请求地址: " + httpPost.getURI() + "\r\n响应状态: "
                        + response.getStatusLine() + "\r\n响应长度: "
                        + responseLength + "\r\n响应内容: " + responseContent);
            }
        } catch (UnsupportedEncodingException e) {
            log.error("请求出现异常", e);
            throw new Exception(e.getMessage(), e);
        } catch (ClientProtocolException e) {
            log.error("请求出现异常", e);
            throw new Exception(e.getMessage(), e);
        } catch (IOException e) {
            log.error("请求出现异常", e);
            throw new Exception(e.getMessage(), e);
        }
        return (Map) JSONObject.parseObject(responseContent);
    }

    /**
     * HTTP GET请求
     * @param url
     * @param param
     * @param charset
     * @return
     * @throws Exception
     */
    public static Map doGet(String url,Map param ,String charset) throws Exception {

        if (charset == null || charset == "") {
            charset = "UTF-8";
        }
        String urlParam= getParam(param);
        url= url+"?"+urlParam;
        log.info("http get请求开始，请求URL:[" + url + "]");
        long responseLength = 0; // 响应长度
        String responseContent = null; // 响应内容
        HttpClient httpClient = new DefaultHttpClient(); // 创建默认的httpClient实例

        try {
            // post请求
            HttpGet httpGet = new HttpGet(url);
            // 执行POST请求
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                responseLength = entity.getContentLength();
                responseContent = EntityUtils.toString(entity, charset);
                EntityUtils.consume(entity); // Consume response content
            }
            if (log.isDebugEnabled()) {
                log.debug("请求地址: " + httpGet.getURI() + "\r\n响应状态: "
                        + response.getStatusLine() + "\r\n响应长度: "
                        + responseLength + "\r\n响应内容: " + responseContent);
            }
        } catch (UnsupportedEncodingException e) {
            log.error("请求出现异常", e);
            throw new Exception(e.getMessage(), e);
        } catch (ClientProtocolException e) {
            log.error("请求出现异常", e);
            throw new Exception(e.getMessage(), e);
        } catch (IOException e) {
            log.error("请求出现异常", e);
            throw new Exception(e.getMessage(), e);
        }
        return (Map) JSONObject.parseObject(responseContent);
    }


}
