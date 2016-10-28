package com.drpeng.ordercenter.common;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yuyang on 2016/10/28 0028.
 */
public class SslInitialize {
    private static Logger log = LoggerFactory.getLogger(SslInitialize.class);
    public static void SslCreate(HttpClient httpClient) throws Exception {
        X509TrustManager xtm = new AITrustManager();
        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLS");
            // 使用TrustManager来初始化该上下文，TrustManager只是被SSL的Socket所使用
            ctx.init(null, new TrustManager[] { xtm }, null);
            // 创建SSLSocketFactory，并通过SchemeRegistry将SSLSocketFactory注册到我们的HttpClient上
            SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);
            socketFactory
                    .setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            httpClient.getConnectionManager().getSchemeRegistry()
                    .register(new Scheme("https", 443, socketFactory));
        } catch (NoSuchAlgorithmException e) {
            log.error("请求出现异常", e);
            throw new Exception(e.getMessage(), e);
        } catch (KeyManagementException e) {
            log.error("请求出现异常", e);
            throw new Exception(e.getMessage(), e);
        }
    }
}
