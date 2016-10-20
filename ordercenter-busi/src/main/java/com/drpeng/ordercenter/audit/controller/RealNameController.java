package com.drpeng.ordercenter.audit.controller;

import com.alibaba.fastjson.JSONObject;
import com.drpeng.ordercenter.activiti.service.IActivitiBaseService;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liurl3 on 2016/10/19.
 */
@RestController
@RequestMapping("/realNameReg")
public class RealNameController {
    @Autowired
    private IActivitiBaseService activitiBaseService;
    @RequestMapping(value = "/d",method = RequestMethod.GET,consumes = "application/json")
    public Map<String,Object> findRealNameMsgsd(@RequestParam(value="billId",required = false) String billId,@RequestParam(value="idNumber",required = false) String idNumber){
        Map map = new HashMap();
        if(billId != null && !billId.isEmpty())
            map.put("bill_id",billId);
        if(idNumber != null && !idNumber.isEmpty())
            map.put("id_number",idNumber);
        List<Task> taskList = activitiBaseService.qryTaskByValuelike(map,0,10);
        return null;
    }
    @RequestMapping(method = RequestMethod.GET,consumes = "application/json")
    public String findRealNameMsgs(@RequestBody JSONObject jsonObject){
        JSONObject rtnObj = new JSONObject();
        String sEcho = null;
        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 0; // 每页显示的行数
        Map map = new HashMap();
        if(jsonObject.containsKey("sEcho"))
            sEcho = jsonObject.getString("sEcho");
        if(jsonObject.containsKey("iDisplayStart"))
            iDisplayStart = jsonObject.getIntValue("iDisplayStart");
        if(jsonObject.containsKey("iDisplayLength"))
            iDisplayLength = jsonObject.getIntValue("iDisplayLength");
        if(jsonObject.containsKey("billId"))
            map.put("bill_id",jsonObject.get("billId"));
        if(jsonObject.containsKey("idNumber"))
            map.put("id_number",jsonObject.get("idNumber"));
        long totalCount = activitiBaseService.countTaskByValueLike(map);
        List<Task> taskList = activitiBaseService.qryTaskByValuelike(map, iDisplayStart, iDisplayLength);
        List ordList = new ArrayList();
        for(Task task:taskList){
            Map ordMap = activitiBaseService.qryTaskFormDataByExecutionId(task.getExecutionId());
            String taskId = task.getId();
            ordMap.put("taskId",taskId);
            Object obj = JSONObject.toJSON(ordMap);
            ordList.add(obj);
        }
        rtnObj.put("sEcho",sEcho);
        rtnObj.put("iTotalRecords",totalCount);
        rtnObj.put("iTotalDisplayRecords",totalCount);
        rtnObj.put("data",ordList);
        return rtnObj.toString();
    }
    @RequestMapping(value="/approval",method = RequestMethod.POST,consumes = "application/json")
    public Map<String,Object> approveRealName(@RequestParam(value ="approval") String approval,@RequestParam(value = "taskId") String taskId){
        Map rtnMap = new HashMap();
        activitiBaseService.approveRealName(taskId, approval);
        String approvalTag = "";
        if("true".equals(approval))
            approvalTag="通过";
        else
            approvalTag="不通过";
        rtnMap.put("message", "SUCCESS");
        rtnMap.put("taskId",taskId);
        rtnMap.put("result",approvalTag);
        return rtnMap;
    }
}
