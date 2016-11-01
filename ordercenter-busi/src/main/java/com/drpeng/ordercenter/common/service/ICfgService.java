package com.drpeng.ordercenter.common.service;

import com.drpeng.ordercenter.persistence.entity.CfgBusiness;
import com.drpeng.ordercenter.persistence.entity.CfgBusinessImpl;
import com.drpeng.ordercenter.persistence.entity.CfgExternalApi;

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


    /**
     * @Desciption 查询webapi信息
     * @param webApiCode webapi编码
     * @author lifei
     * @date 2016/10/31
     */
    public CfgExternalApi findExternalApi(String webApiCode);
}
