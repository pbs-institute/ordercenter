package com.drpeng.ordercenter.activiti.service;

import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;

/**
 * Created by lifei13 on 2016/10/19.
 */
public interface IActivitiBaseService {

    /**
     * 启动一个流程
     * @param businessId 业务编码;
     * @param regionId 地市编码 为空时查找"all"对应的配置;
     *
     */
    public void startProcessByBusi(int businessId, String regionId, Map<String,Object> varMap);

    public void startProcessByKey(String processKey, Map<String,Object> varMap);

    /**
     * 按任务参数查询任务
     * 查询待完成的任务
     */
    public List<Task> qryTaskByValuelike(String valueKey, String value);

    /**
     * 根据任务id获取对应的表单数据
     * @param executionId 任务执行id
     * @return
     */
    public Map<String,Object>  qryTaskFormDataByExecutionId(String executionId);
    /**
     * 实名制审批
     * @param approved 审批结果 "true"通过  "false"拒绝
     */
    public void approveRealName(String taskId,String approved);
}
