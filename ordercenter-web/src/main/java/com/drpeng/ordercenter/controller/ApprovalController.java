package com.drpeng.ordercenter.controller;

import com.alibaba.fastjson.JSONObject;
import com.drpeng.ordercenter.common.HttpUtil;
import com.drpeng.ordercenter.common.SystemConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuyang on 2016/10/13 0013.
 */
@Controller
public class ApprovalController extends BaseController {

    @RequestMapping("/index")
    public String index(Model mode) {
        return "index";
    }
//    @RequestMapping(value = "/getData")
//    @ResponseBody
//    public Map getOrder(@RequestParam String page, String rows,String billId,String certCode){
//        Map map = new HashMap();
//        int totalRecord  = 25;//总记录数
//        int total=totalRecord % Integer.parseInt(rows) == 0 ? totalRecord
//                / Integer.parseInt(rows) : totalRecord / Integer.parseInt(rows)
//                + 1;//计算总页数
//        int iDisplayStar=1;//开始的记录数
//        int iDisplayEnd=Integer.valueOf(page) *Integer.valueOf(rows) ;//结束的记录数
//        if(Integer.valueOf(page)>1){
//            iDisplayStar=iDisplayEnd-Integer.valueOf(rows);
//        }
//    if(iDisplayEnd>totalRecord){
//        iDisplayEnd=totalRecord;
//    }
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

    /**
     * 获取实名制审批列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getRealNameTask")
    @ResponseBody
    public Map getOrder(HttpServletRequest request) throws Exception {
        String rows = request.getParameter("rows");
        String page = request.getParameter("page");
        String billId = request.getParameter("billId");
        String certCode = request.getParameter("certCode");
        JSONObject resMap = new JSONObject();
        ;
        resMap.put("rows", rows);
        resMap.put("page", page);
        resMap.put("billId", billId);
        resMap.put("certCode", certCode);
        System.out.println(busiUrl + SystemConstants.BUSI_REALNAMEREG_URL);
        Map result =sendGet(busiUrl + SystemConstants.BUSI_REALNAMEREG_URL, resMap,null);
        System.out.println(result);
        return result;
    }

    /**
     * 审批
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/approval", method = RequestMethod.POST)
    public String approveRealName(HttpServletRequest request) throws Exception {
        String taskId = request.getParameter("taskId");
        String approvalTag = request.getParameter("approval");
        JSONObject jsonRequest = new JSONObject();
        jsonRequest.put("taskId", taskId);
        jsonRequest.put("approval", approvalTag);
        System.out.println(busiUrl + SystemConstants.API_ORGANIZES_URL);
        Map result = sendPost(busiUrl + SystemConstants.API_ORGANIZES_URL, jsonRequest,null);
        return (String) result.get("result");
    }
}
