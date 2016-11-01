package com.drpeng.ordercenter.activiti.service.impl;

import com.drpeng.ordercenter.activiti.service.IActivitiBaseService;
import com.drpeng.ordercenter.persistence.entity.CfgBusinessProcess;
import com.drpeng.ordercenter.persistence.entity.CfgBusinessProcessExample;
import com.drpeng.ordercenter.persistence.mapper.CfgBusinessProcessMapper;
import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lifei13 on 2016/10/17.
 */
@Service
public class ActivitiBaseServiceImpl implements IActivitiBaseService {

    @Autowired
    RuntimeService runtimeService;
    @Autowired
    ProcessEngine processEngine;
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    TaskService taskService;
    @Autowired
    FormService formService;
    @Autowired
    CfgBusinessProcessMapper cfgBusinessProcessMapper;
    /**
     * 启动一个流程
     * @param businessId 业务编码;
     * @param regionId 地市编码 为空时查找"all"对应的配置;
     *
     */
    public void startProcessByBusi(int businessId, String regionId, Map<String,Object> varMap){
        /**
         * 1.根据业务编码和地市 获取对应的流程编码
         */
        if (null == regionId||regionId.isEmpty()){
            regionId = "all";
        }
        CfgBusinessProcessExample example = new CfgBusinessProcessExample();
        example.or()
                .andBusinessIdEqualTo(businessId)
                .andCityIdEqualTo(regionId)
                .andStatusEqualTo("0");
        List<CfgBusinessProcess> mappingList = cfgBusinessProcessMapper
                .selectByExample(example);
        CfgBusinessProcess cfgBusinessProcess = mappingList.get(0);

        //去找对应ProcessKey中版本最新的流程
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionKey(cfgBusinessProcess.getProcessKey())
                .latestVersion()
                .singleResult();

        runtimeService.startProcessInstanceById(processDefinition.getId(),String.valueOf(businessId),varMap);
        //formService.submitStartFormData(processDefinition.getId(),String.valueOf(businessId),varMap);
    }

    public void startProcessByKey(String processKey, Map<String,Object> varMap){
        runtimeService.startProcessInstanceByKey(processKey,varMap);
    }

    /**
     * 按任务参数查询任务
     * 查询待完成的任务
     * @param kvMap 查询条件
     * @param startIndex 初始索引
     * @param maxResults 查出来的最大数量
     */
    public List<Task> qryTaskByValuelike(Map<String,String> kvMap, int businessId,int startIndex,int maxResults){
        TaskQuery query = taskService.createTaskQuery();
        List<Task> tasks = null;
        //业务编码
        if (businessId != 0){
            query.processInstanceBusinessKey(String.valueOf(businessId));
        }

        //遍历查询条件，逐个添加到query中
        if (kvMap != null || !kvMap.isEmpty()){
            for (String key : kvMap.keySet()) {
                query.processVariableValueLike(key,kvMap.get(key));
            }

        }

        //如果分页条件为空，则返回未分页列表，如果有可用的分页条件，返回分页列表
        if (startIndex <0 || maxResults < 0){
            tasks = query.list();
        }else {
            tasks = query.listPage(startIndex,maxResults);
        }
        return tasks;
    }


    /**
     * 按条件查询任务总数
     *
     * @param kvMap
     * @return
     */
    public long countTaskByValueLike(Map<String,String> kvMap, int businessId){
        TaskQuery query = taskService.createTaskQuery();
        //业务编码
        if (businessId != 0){
            query.processInstanceBusinessKey(String.valueOf(businessId));
        }
        //遍历查询条件，逐个添加到query中
        if (kvMap != null && !kvMap.isEmpty()){
            for (String key : kvMap.keySet()) {
                query.processVariableValueLike(key,kvMap.get(key));
            }

        }
        return query.count();
    }


    /**
     * 根据任务id获取对应的表单数据
     * @param executionId 任务执行id
     * @return
     */
    public Map<String,Object>  qryTaskFormDataByExecutionId(String executionId){
        Map<String,Object> map = runtimeService.getVariables(executionId);
        return map;
    }

    /**
     * 实名制审批
     * @param approved 审批结果 "true"通过  "false"拒绝
     */
    public void approveRealName(String taskId,String approved){
        Map<String,String> map = new HashMap<String,String>();
        map.put("approved",approved);
        formService.submitTaskFormData(taskId,map);
    }


}
