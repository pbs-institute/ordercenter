package com.drpeng.ordercenter;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by yuyang on 2016/10/26 0026.
 */
public class SystemConstants {
    @Value("${busi.url}")
    private String busiUrl;
    public final static String BUSI_REALNAMEREG_URL = busiUrl + "/realNameReg/findRealNameMsgs";
    public final static String API_ORGANIZES_URL = busiUrl + "/realNameReg/approval";
}
