package com.drpeng.ordercenter.common.service.impl;

import com.drpeng.ordercenter.common.service.ICfgService;
import com.drpeng.ordercenter.persistence.entity.*;
import com.drpeng.ordercenter.persistence.mapper.CfgBusinessImplMapper;
import com.drpeng.ordercenter.persistence.mapper.CfgBusinessMapper;
import com.drpeng.ordercenter.persistence.mapper.CfgExternalApiMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liurl3 on 2016/10/17.
 */
@Service
public class CfgServiceImpl implements ICfgService {
    @Autowired
    private CfgBusinessMapper cfgBusinessMapper;
    @Autowired
    private CfgBusinessImplMapper cfgBusinessImplMapper;
    @Autowired
    private CfgExternalApiMapper cfgExternalApiMapper;

    private Logger logger = LoggerFactory.getLogger(CfgServiceImpl.class);
    @Override
    public CfgBusiness findCfgBusiness(int businessId) {
        CfgBusinessExample cfgBusinessExample = new CfgBusinessExample();
        cfgBusinessExample.or().andBusinessIdEqualTo(businessId).andStatusEqualTo(0);
        List<CfgBusiness> cfgBusinessList = cfgBusinessMapper.selectByExample(cfgBusinessExample);
        if(cfgBusinessList != null && cfgBusinessList.size()>0)
            return cfgBusinessList.get(0);
        return null;
    }

    @Override
    public CfgBusinessImpl findCfgBusinessImpl(int businessId, int delPartyId) {
        CfgBusinessImplExample cfgBusinessImplExample = new CfgBusinessImplExample();
        cfgBusinessImplExample.or().andBusinessIdEqualTo(businessId).andDeliveryPartyEqualTo(delPartyId).andStatusEqualTo(0);
        List<CfgBusinessImpl> cfgBusinessImplList = cfgBusinessImplMapper.selectByExample(cfgBusinessImplExample);
        if(cfgBusinessImplList!= null && cfgBusinessImplList.size()>0)
            return cfgBusinessImplList.get(0);
        return null;
    }

    /**
     * @param webApiCode webapi编码
     * @Desciption 查询webapi信息
     * @author lifei
     * @date 2016/10/31
     */
    @Override
    public CfgExternalApi findExternalApi(String webApiCode) {
        CfgExternalApiExample example = new CfgExternalApiExample();
        example.or()
                .andApiCodeEqualTo(webApiCode)
                .andStatusEqualTo("0");
        List<CfgExternalApi> externalApiList = cfgExternalApiMapper.selectByExample(example);
        if (externalApiList != null && externalApiList.size() == 1){
            return externalApiList.get(0);
        }else {
            logger.error(webApiCode+"对应的[CFG_WEB_API]配置有问题，请检查");
            return null;
        }
    }
}
