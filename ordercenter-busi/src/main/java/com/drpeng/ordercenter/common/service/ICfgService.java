package com.drpeng.ordercenter.common.service;

import com.drpeng.ordercenter.persistence.entity.CfgBusiness;
import com.drpeng.ordercenter.persistence.entity.CfgBusinessImpl;

/**
 * Created by liurl3 on 2016/10/17.
 */
public interface ICfgService {
    /**
     * 查询业务操作配置信息
     * @return
     */
    public CfgBusiness findCfgBusiness(int businessId);
    /**
     * 查询业务操作实现配置信息
     */
    public CfgBusinessImpl findCfgBusinessImpl(int businessId,int delPartyId);
}
