package com.drpeng.ordercenter.activiti.service.impl;

import com.drpeng.ordercenter.activiti.service.IActivitiBaseService;
import com.drpeng.ordercenter.persistence.entity.CfgBusinessProcessMapping;
import com.drpeng.ordercenter.persistence.entity.CfgBusinessProcessMappingExample;
import com.drpeng.ordercenter.persistence.mapper.CfgBusinessMapper;
import com.drpeng.ordercenter.persistence.mapper.CfgBusinessProcessMappingMapper;
import org.activiti.engine.*;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
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
    CfgBusinessProcessMappingMapper cfgBusinessProcessMappingMapper;
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
        CfgBusinessProcessMappingExample example = new CfgBusinessProcessMappingExample();
        example.or()
                .andBusinessIdEqualTo(businessId)
                .andRegionIdEqualTo(regionId)
                .andStatusEqualTo("0");
        List<CfgBusinessProcessMapping> mappingList = cfgBusinessProcessMappingMapper
                .selectByExample(example);
        CfgBusinessProcessMapping processMapping = mappingList.get(0);

        //去找对应ProcessKey中版本最新的流程
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionKey(processMapping.getProcessId())
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
     */
    public List<Task> qryTaskByValuelike(String valueKey,String value){
        //查出所有待处理的任务
        List<Task> tasks = taskService.createTaskQuery()
                .processVariableValueLike(valueKey,value)
                .orderByDueDate().asc()
                .list();
        return tasks;
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
