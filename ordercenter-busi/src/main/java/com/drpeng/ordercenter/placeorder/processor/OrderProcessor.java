package com.drpeng.ordercenter.placeorder.processor;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by liurl3 on 2016/10/14.
 */
public interface OrderProcessor {
    Map processor(JSONObject jsonObject);

}
