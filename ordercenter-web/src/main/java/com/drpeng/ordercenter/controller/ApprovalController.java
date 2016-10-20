package com.drpeng.ordercenter.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.drpeng.ordercenter.entity.OrderInfo;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuyang on 2016/10/13 0013.
 */
@Controller
public class ApprovalController {

    @RequestMapping("/")
    public String index(Model mode){
        return"index";
    }
    @RequestMapping(value = "/getData")
    @ResponseBody
    public String getOrder(@RequestParam String pam,String billId,String certCode){
        String sEcho = null;
        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 0; // 每页显示的行数
        JSONArray jsonarray = JSONArray.parseArray(pam);
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();

            if (obj.get("name").equals("iDisplayStart"))
                iDisplayStart = obj.getIntValue("value");

            if (obj.get("name").equals("iDisplayLength"))
                iDisplayLength = obj.getIntValue("value");
        }


        List<String[]> list = new ArrayList<String[]>();
        JSONObject getObj = new JSONObject();
        for(int i=0;i<25;i++){
            String[] or = { "170908511"+i, "qqqqqqqqqqq" ,"asdf","反面","正面","手持","EWQREQWERQWERQWERQEWRQ"};
            list.add(or);
        }
        int iDisplayEnd=iDisplayStart + iDisplayLength;
        if(iDisplayEnd>list.size()){
            iDisplayEnd=list.size();
        }
        getObj.put("sEcho",sEcho);
        getObj.put("iTotalRecords",list.size());
        getObj.put("iTotalDisplayRecords",list.size());
        getObj.put("data",list.subList(iDisplayStart,iDisplayEnd));
        System.out.println("JSONObject.toJSON(map).toString==="+getObj.toString());
        return getObj.toString();
    }

//    @RequestMapping(value = "/getData")
//    @ResponseBody
//    public String findRealNameMsgs(@RequestParam String pam,String billId,String certCode){
//        JSONObject rtnObj = new JSONObject();
////        String sEcho = null;
////        int iDisplayStart = 0; // 起始索引
////        int iDisplayLength = 0; // 每页显示的行数
////        Map map = new HashMap();
////        if(jsonObject.containsKey("sEcho"))
////            sEcho = jsonObject.getString("sEcho");
////        if(jsonObject.containsKey("iDisplayStart"))
////            iDisplayStart = jsonObject.getIntValue("iDisplayStart");
////        if(jsonObject.containsKey("iDisplayLength"))
////            iDisplayLength = jsonObject.getIntValue("iDisplayLength");
////        if(jsonObject.containsKey("billId"))
////            map.put("bill_id",jsonObject.get("billId"));
////        if(jsonObject.containsKey("idNumber"))
////            map.put("id_number",jsonObject.get("idNumber"));
//        String sEcho = null;
//        int iDisplayStart = 0; // 起始索引
//        int iDisplayLength = 0; // 每页显示的行数
//        JSONArray jsonarray = JSONArray.parseArray(pam);
//        for (int i = 0; i < jsonarray.size(); i++) {
//            JSONObject obj = (JSONObject) jsonarray.get(i);
//            if (obj.get("name").equals("sEcho"))
//                sEcho = obj.get("value").toString();
//
//            if (obj.get("name").equals("iDisplayStart"))
//                iDisplayStart = obj.getIntValue("value");
//
//            if (obj.get("name").equals("iDisplayLength"))
//                iDisplayLength = obj.getIntValue("value");
//        }
//
////        for(int i=0;i<25;i++){
////            String[] or = { "170908511"+i, "qqqqqqqqqqq" ,"asdf","反面","正面","手持","EWQREQWERQWERQWERQEWRQ"};
////            list.add(or);
////        }
////        int iDisplayEnd=iDisplayStart + iDisplayLength;
////        if(iDisplayEnd>list.size()){
////            iDisplayEnd=list.size();
////        }
////        long totalCount = activitiBaseService.countTaskByValueLike(map);
////        List<Task> taskList = activitiBaseService.qryTaskByValuelike(map, iDisplayStart, iDisplayLength);
////        List ordList = new ArrayList();
////        for(Task task:taskList){
////            Map ordMap = activitiBaseService.qryTaskFormDataByExecutionId(task.getExecutionId());
////            String taskId = task.getId();
////            ordMap.put("taskId",taskId);
////            Object obj = JSONObject.toJSON(ordMap);
////            ordList.add(obj);
////        }
//        List<String[]> list = new ArrayList<String[]>();
//        JSONObject getObj = new JSONObject();
//        for(int i=0;i<25;i++){
//            String[] or = { "170908511"+i, "qqqqqqqqqqq" ,"asdf","反面","正面","手持","EWQREQWERQWERQWERQEWRQ"};
//            list.add(or);
//        }
//        int iDisplayEnd=iDisplayStart + iDisplayLength;
//        if(iDisplayEnd>list.size()){
//            iDisplayEnd=list.size();
//        }
//        rtnObj.put("sEcho",sEcho);
//        rtnObj.put("iTotalRecords",list.size());
//        rtnObj.put("iTotalDisplayRecords",list.size());
//        rtnObj.put("data",list.subList(iDisplayStart,iDisplayEnd));
//        return rtnObj.toString();
//    }
}
