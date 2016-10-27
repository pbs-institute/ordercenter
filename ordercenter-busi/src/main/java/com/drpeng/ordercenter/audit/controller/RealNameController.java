package com.drpeng.ordercenter.audit.controller;

import com.drpeng.ordercenter.activiti.service.IActivitiBaseService;
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
    @ResponseBody
    @RequestMapping(value = "/findRealNameMsgs",method = RequestMethod.GET)
    public Map findRealNameMsgs(@RequestParam String page, String rows,String billId,String certCode){
        Map map = new HashMap();
        if(billId!=null&&!billId.equals("")){
            map.put("bill_id",billId);
        }
        if(certCode!=null&&!certCode.equals("")){
            map.put("id_number",certCode);
        }
        int totalRecord  = (int)activitiBaseService.countTaskByValueLike(map);//总记录数
        int total=totalRecord % Integer.parseInt(rows) == 0 ? totalRecord
                / Integer.parseInt(rows) : totalRecord / Integer.parseInt(rows)
                + 1;//计算总页数
        int iDisplayStar=0;//开始的记录数
        int iDisplayEnd=Integer.valueOf(page) *Integer.valueOf(rows) ;//结束的记录数
        if(Integer.valueOf(page)>1){
            iDisplayStar=iDisplayEnd-Integer.valueOf(rows);
        }
        List<Task> taskList = activitiBaseService.qryTaskByValuelike(map, iDisplayStar, Integer.valueOf(rows));
        List ordList = new ArrayList();
        for(Task task:taskList){
            Map ordMap = activitiBaseService.qryTaskFormDataByExecutionId(task.getExecutionId());
            String taskId = task.getId();
            ordMap.put("taskId",taskId);
            ordList.add(ordMap);
        }
        Map retMap=new HashMap();
        retMap.put("total", String.valueOf(total));
        retMap.put("page",page);
        retMap.put("records",totalRecord);
        retMap.put("rows",ordList);
        System.out.println(ordList.get(0));
        return retMap;
    }
    @ResponseBody
    @RequestMapping(value="/approval",method = RequestMethod.POST)
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
        rtnMap.put("result",approval);
//        rtnMap.put("message", "SUCCESS");
//        rtnMap.put("taskId","12341234");
//        rtnMap.put("result","true");
        return rtnMap;
    }
//    @RequestMapping(value = "/getRealNameTask")
//    @ResponseBody
//    public Map getOrder(@RequestParam String page, String rows,String billId,String certCode){
////        String rows=request.getParameter("rows");
////        String page=request.getParameter("page");
////        String billId=request.getParameter("billId");
////        String certCode=request.getParameter("certCode");
//        Map map = new HashMap();
//
//        int totalRecord  = 25;//总记录数
//        int total=totalRecord % Integer.parseInt(rows) == 0 ? totalRecord
//                / Integer.parseInt(rows) : totalRecord / Integer.parseInt(rows)
//                + 1;//计算总页数
//        int iDisplayStar=1;//开始的记录数
//        int iDisplayEnd=Integer.valueOf(page) *Integer.valueOf(rows) ;//结束的记录数
//        if(Integer.valueOf(page)>1){
//            iDisplayStar=iDisplayEnd-Integer.valueOf(rows);
//        }
//        if(iDisplayEnd>totalRecord){
//            iDisplayEnd=totalRecord;
//        }
//        List list=new ArrayList();
//        for (int i=0;i<25;i++){
//            Map map1=new HashMap();
//            map1.put("taskId","1341"+i);
//            map1.put("ord_order_id","asdfasdfadsfad");
//            map1.put("name","于洋"+i);
//            map1.put("bill_id","1709085"+i);
//            map1.put("id_number","adfasfdasdf");
//            map1.put("back_side_photo","bbbbbbbbb");
//            map1.put("front_side_photo","ffffffffff");
//            map1.put("hand_held_photo","hhhhhhhhh");
//            list.add(map1);
//        }
//
//        Map retMap=new HashMap();
//        retMap.put("total", String.valueOf(total));
//        retMap.put("page",page);
//        retMap.put("records",25);
//        retMap.put("rows",list.subList(iDisplayStar,iDisplayEnd));
//        return retMap;
//    }
}
