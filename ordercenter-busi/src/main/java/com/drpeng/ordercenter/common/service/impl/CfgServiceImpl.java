package com.drpeng.ordercenter.common.service.impl;

import com.drpeng.ordercenter.common.service.ICfgService;
import com.drpeng.ordercenter.persistence.entity.CfgBusiness;
import com.drpeng.ordercenter.persistence.entity.CfgBusinessExample;
import com.drpeng.ordercenter.persistence.entity.CfgBusinessImpl;
import com.drpeng.ordercenter.persistence.entity.CfgBusinessImplExample;
import com.drpeng.ordercenter.persistence.mapper.CfgBusinessImplMapper;
import com.drpeng.ordercenter.persistence.mapper.CfgBusinessMapper;
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
}
