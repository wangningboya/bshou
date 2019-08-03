package cn.wy.bs.workflow;//package com.cloud.servicemanage.activity;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.junit.Test;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @Author WY
 * @Date 2019/5/22
 **/
public class ActivitiTest {

	/**
	 * 1、部署流程
	 * 2、启动流程实例
	 * 3、请假人发出请假申请
	 * 4、班主任查看任务
	 * 5、班主任审批
	 * 6、最终的教务处Boss审批
	 */

	/**
	 * 1：部署一个Activiti流程
	 * 运行成功后，查看之前的数据库表，就会发现多了很多内容
	 */
	@Test
	public void creatActivitiTask() {
		//加载的那两个内容就是我们之前已经弄好的基础内容哦。
		//得到了流程引擎
		//方法1 通过bpmn和png资源进行部署
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getRepositoryService()
				.createDeployment()
				.addClasspathResource("processes/test01.bpmn")
				.addClasspathResource("processes/test01.png")
				.deploy();

		//方法2 通过 inputstream完成部署
//		InputStream bpmnStream = this.getClass().getClassLoader().getResourceAsStream("test01.bpmn");
//		//得到流程引擎
//		ProcessEngine processEngine2 = ProcessEngines.getDefaultProcessEngine();
//		processEngine2.getRepositoryService()
//				.createDeployment()
//				.addInputStream("test01.bpmn", bpmnStream)
//				.deploy();

		//方法3 通过zipinputstream完成部署
		//注意：这个的话，需要将bpmn和png文件进行压缩成zip文件，然后放在项目src目录下即可(当然其他目录也可以)
//		InputStream in = this.getClass().getClassLoader().getResourceAsStream("test01.zip");
//		ZipInputStream zipInputStream = new ZipInputStream(in);
//		ProcessEngine processEngine3 = ProcessEngines.getDefaultProcessEngine();
//		processEngine3.getRepositoryService()
//				.createDeployment()
//				.addZipInputStream(zipInputStream)
//				.deploy();

	}

	/**
	 * 2：启动流程实例
	 */
	@Test
	public void testStartProcessInstance() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getRuntimeService()
				.startProcessInstanceById("myProcess_1:1:4");  //这个是查看数据库中act_re_procdef表
	}

	public void asdfsdf(){
		org.activiti.engine.identity.User activitiUser;
	}

	/**
	 * 完成请假申请
	 */
	@Test
	public void testQingjia() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getTaskService()
				.complete("17502"); //查看act_ru_task表
	}

	/**
	 * 郭强查询当前正在执行任务
	 */
	@Test
	public void testQueryTask() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		List<Task> tasks = processEngine.getTaskService()
				.createTaskQuery()
				.taskAssignee("郭强")
				.list();
		System.out.println("============");
		System.out.println(tasks);
		System.out.println("============");
		for (Task task : tasks) {
			System.out.println("111");
			System.out.println(task.getName());
			System.out.println("111");
		}
	}

	/**
	 * 根据名称查询流程部署
	 */
	@Test
	public void testQueryDeploymentByName() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		List<Deployment> deployments = processEngine.getRepositoryService()
				.createDeploymentQuery()
				.orderByDeploymenTime()//按照部署时间排序
				.desc()//按照降序排序
				.deploymentName("请假流程")
				.list();
		for (Deployment deployment : deployments) {
			System.out.println(deployment.getId());
		}
	}

	/**
	 * 查询所有的部署流程
	 */
	@Test
	public void queryAllDeplyoment() {
		//得到流程引擎
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		List<Deployment> lists = processEngine.getRepositoryService()
				.createDeploymentQuery()
				.orderByDeploymenTime()//按照部署时间排序
				.desc()//按照降序排序
				.list();
		for (Deployment deployment : lists) {
			System.out.println(deployment.getId() + "    部署名称" + deployment.getName());
		}
	}

	/**
	 * 查询所有的流程定义
	 */
	@Test
	public void testQueryAllPD() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		List<ProcessDefinition> pdList = processEngine.getRepositoryService()
				.createProcessDefinitionQuery()
				.orderByProcessDefinitionVersion()
				.desc()
				.list();
		for (ProcessDefinition pd : pdList) {
			System.out.println(pd.getName());
		}
	}

	/**
	 * 查看流程图
	 * 根据deploymentId和name(在act_ge_bytearray数据表中)
	 */
	@Test
	public void testShowImage() throws Exception{
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		InputStream inputStream = processEngine.getRepositoryService()
				/**
				 * deploymentID
				 * 文件的名称和路径
				 */
				.getResourceAsStream("801","shenqing.png");
		OutputStream outputStream3 = new FileOutputStream("e:/processimg.png");
		int b = -1 ;
		while ((b=inputStream.read())!=-1){
			outputStream3.write(b);
		}
		inputStream.close();
		outputStream3.close();
	}

	/**
	 * 项目经理郭强完成任务
	 */
	@Test
	public void testFinishTask_manager() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		engine.getTaskService()
				.complete("5002"); //查看act_ru_task数据表
	}

	/**
	 * 银行经理赵欣苡完成的任务
	 */
	@Test
	public void testFinishTask_Boss() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getTaskService()
				.complete("7502");  //查看act_ru_task数据表
	}

	/**
	 * 删除已经部署的Activiti流程
	 */
	@Test
	public void testDelete() {
		//得到流程引擎
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		//第一个参数是部署的流程的ID，第二个true表示是进行级联删除
		processEngine.getRepositoryService()
				.deleteDeployment("601", true);
	}
}
