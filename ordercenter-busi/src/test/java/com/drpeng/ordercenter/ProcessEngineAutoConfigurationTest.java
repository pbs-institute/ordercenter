/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.drpeng.ordercenter;


import com.alibaba.fastjson.JSONObject;
import com.drpeng.ordercenter.activiti.service.IActivitiBaseService;
import com.drpeng.ordercenter.activiti.service.RealNameService;
import org.activiti.engine.*;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @author Lifei
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessEngineAutoConfigurationTest {


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


    @Test
    public void testProcessDefinitionDeployment() {

        List<ProcessDefinition> processDefinitionList =
                this.repositoryService.createProcessDefinitionQuery()
                        .processDefinitionKey("checkRealName")
                        .list();

        Assert.assertNotNull(processDefinitionList);
        Assert.assertTrue(processDefinitionList.size() > 0);

        ProcessDefinition processDefinition =
                processDefinitionList.iterator().next();
        Assert.assertEquals(processDefinition.getKey(), "checkRealName");
        for (ProcessDefinition definition : processDefinitionList) {
            System.out.println(definition.getName());
            System.out.println(definition.getKey());
            System.out.println(definition.getVersion());
        }

    }


    @Test
    public void testProcessEngineCreated() throws Throwable {
        Assert.assertNotNull(this.processEngine);
        Assert.assertNotNull(this.repositoryService);
        Assert.assertNotNull(this.runtimeService);
    }

    @Test
    public void testGetTaskToDo() throws Throwable {
        List<Task> tasks = taskService.createTaskQuery().orderByTaskId().asc().list();
        Map<String, String> variables;

        for (Task task : tasks) {
            System.out.println("-----------------------------");
            System.out.println("任务名：" + task.getName());
            System.out.println("进程id：" + task.getProcessDefinitionId());
            System.out.println("任务id：" + task.getId());
            TaskFormData data = formService.getTaskFormData(task.getId());
            List<FormProperty> properties = data.getFormProperties();
            for (FormProperty property : properties) {
                System.out.println("/tproperty.Id:" + property.getId());
                System.out.println("/tproperty.name:" + property.getName());
                System.out.println("/tproperty.value:" + property.getValue());
                System.out.println("/tproperty.required:" + property.isRequired());
            }
       /*     variables = new HashMap<String, String>();
            variables.put("approved","true");
            formService.submitTaskFormData(task.getId(),variables);*/
        }
    }

    @Test
    public void testDelProcessStarted() throws Throwable {
        List<ProcessInstance> processInstanceList = runtimeService.createProcessInstanceQuery().list();
        for (ProcessInstance processInstance : processInstanceList) {
          /*  //1.删除task
            List<Task> taskList = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();
            for (Task task : taskList) {
                taskService.deleteTask(task.getId(),"error");
            }*/
            //2.删除流程
            try{
                runtimeService.deleteProcessInstance(processInstance.getId(), "errorIns");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        //3.删除部署
        List<ProcessDefinition> processDefinitionList =
                this.repositoryService.createProcessDefinitionQuery()
                        .processDefinitionKey("checkRealName")
                        .list();
        for (ProcessDefinition processDefinition : processDefinitionList) {
            try {
                this.repositoryService.deleteDeployment(processDefinition.getId());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

    @Autowired
    IActivitiBaseService activitiBaseService;

    @Test
    public void testProcessStart() throws Throwable {

        Map<String, Object> varMap = new HashMap<String, Object>();
        varMap.put("bill_id", "16012312334");
        varMap.put("id_number", "222111222333666");
        varMap.put("name", "测试");
        varMap.put("front_side_photo", "/sidePhoto");
        varMap.put("back_side_photo", "/sidePhoto");
        varMap.put("hand_held_photo", "/sidePhoto");
        varMap.put("ord_order_id", "220000011112");

        activitiBaseService.startProcessByBusi(8000001, null, varMap);

    }

    @Test
    public void testTaskQryByValue() {

        Map<String,String> kmap = new HashMap<String,String>();
        kmap.put("bill_id","16012312334");
        kmap.put("id_number","222111222333666");
        List<Task> tasks = activitiBaseService.qryTaskByValuelike(kmap,0,10);
        List ordList = new ArrayList();
        JSONObject rtnObj = new JSONObject();
        for (Task task : tasks) {
            System.out.println("####################");
            System.out.println("taskId" + task.getId());
            Map<String, Object> map = activitiBaseService.qryTaskFormDataByExecutionId(task.getExecutionId());
            map.put("taskId", task.getId());
            Collection values = map.values();
            Object obj = JSONObject.toJSON(values);
            System.out.println("=======value:" + values);
            ordList.add(obj);
           /* for (String s : map.keySet()) {
                System.out.println("key:" + s + " value:" + map.get(s));
            }*/

/*
            activitiBaseService.approveRealName(task.getId(), "true");
*/
        }
        rtnObj.put("sEcho","22");
        rtnObj.put("iTotalRecords",10);
        rtnObj.put("iTotalDisplayRecords",10);
        rtnObj.put("data",ordList);
        System.out.println("==========rtnObj:" + rtnObj.toString());
    }


}
