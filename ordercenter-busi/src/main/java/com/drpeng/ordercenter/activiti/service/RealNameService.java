package com.drpeng.ordercenter.activiti.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by lifei13 on 2016/10/14.
 */

@Service
public class RealNameService implements Serializable {

    /**
     * 人工检查通过
     * @param delegateExecution 流程参数
     */
    public void manualCheckpassed(DelegateExecution delegateExecution){
        System.out.println("检查通过");

    }

    /**
     * 人工检查失败
     * @param delegateExecution 流程参数
     */
    public void manualCheckRefused(DelegateExecution delegateExecution){
        System.out.println("检查失败");
    }

}
