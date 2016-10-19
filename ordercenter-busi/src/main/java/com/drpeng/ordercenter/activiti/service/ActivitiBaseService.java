package com.drpeng.ordercenter.activiti.service;

import com.drpeng.ordercenter.persistence.entity.CfgBusinessProcessMapping;
import com.drpeng.ordercenter.persistence.entity.CfgBusinessProcessMappingExample;
import com.drpeng.ordercenter.persistence.mapper.CfgBusinessMapper;
import com.drpeng.ordercenter.persistence.mapper.CfgBusinessProcessMappingMapper;
import org.activiti.engine.*;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lifei13 on 2016/10/17.
 */
@Service
public class ActivitiBaseService {

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

        runtimeService.startProcessInstanceByKey(processMapping.getProcessId(),String.valueOf(businessId),varMap);
    }

    public void startProcessByKey(String processKey, Map<String,Object> varMap){
        runtimeService.startProcessInstanceByKey(processKey,varMap);
    }

    /**
     * 按任务类型查询待处理的任务
     * 查询待完成的任务
     */
    public Map<String,String> qryTask(){
        //查出所有待处理的任务
        List<Task> taskList = taskService.createTaskQuery().orderByTaskId().list();
        for (Task task : taskList) {
            //获取流程参数并展示
            TaskFormData data =formService.getTaskFormData(task.getId());
            List<FormProperty> properties = data.getFormProperties();


        }

        return null;

    }

}
