package com.drpeng.ordercenter.placeorder.processor.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by liurl3 on 2016/10/17.
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
      //  System.out.print("===========applicationContext:"+applicationContext);
    }
    public static ApplicationContext getConext(){
//        System.out.print("===========context:"+context);
        return context;
    }
}
