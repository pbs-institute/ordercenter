package com.drpeng.ordercenter.common.service.impl;

import com.drpeng.ordercenter.common.service.IIdGeneratorService;
import com.drpeng.ordercenter.persistence.mapper.SequenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huangxiaomao on 10/26/2016.
 */

@Service
public class IdGeneratorServiceImpl implements IIdGeneratorService {
    @Autowired
    private SequenceMapper sequenceMapper;

    public long getNextOrdNumber() {
        sequenceMapper.replaceOrdNumber();
        return sequenceMapper.getLastInsertId();
    }
}
