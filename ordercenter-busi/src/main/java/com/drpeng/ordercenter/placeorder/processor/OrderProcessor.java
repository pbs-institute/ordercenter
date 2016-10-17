package com.drpeng.ordercenter.placeorder.processor;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by liurl3 on 2016/10/14.
 */
public interface OrderProcessor {
    void processor(JSONObject jsonObject) throws Exception;

}
