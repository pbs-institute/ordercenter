package com.drpeng.ordercenter.common.service.impl;

import com.drpeng.ordercenter.common.service.IIdGeneratorService;
import com.drpeng.ordercenter.persistence.mapper.SequenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huangxiaomao on 10/26/2016.
 */

@Service
public class IdGeneratorServiceImpl implements IIdGeneratorService {
    @Autowired
    private SequenceMapper sequenceMapper;

    public String getNextOrdNumber() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String strDate = dateFormat.format(now);

        sequenceMapper.replaceOrdNumber();
        long lastId =  sequenceMapper.getLastInsertId();

        return strDate + String.valueOf(lastId % 100000000 + 100000000).substring(1);
    }
}
