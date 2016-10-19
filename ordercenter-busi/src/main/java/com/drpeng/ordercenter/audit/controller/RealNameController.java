package com.drpeng.ordercenter.audit.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by liurl3 on 2016/10/19.
 */
@RestController
@RequestMapping("/realNameReg")
public class RealNameController {
    @RequestMapping(method = RequestMethod.GET,consumes = "application/json")
    public Map<String,Object> findRealNameMsgs(){

        return null;
    }
    @RequestMapping(value = "/{billId}/{idNumber}" ,method = RequestMethod.GET,consumes = "application/json")
    public Map<String,Object> findRealNameMsg(@PathVariable String billId,@PathVariable String idNumber){

        return null;
    }
}
