package cn.wy.bs.workflow;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author WY
 * @Date 2019/5/22
 **/
public class ActivitiUtil {

	@Autowired
	private RuntimeService runtimeService;

	/**
	 * 1：部署一个Activiti流程
	 * 运行成功后，查看之前的数据库表，就会发现多了很多内容
	 */
	public static void creatActivitiTask(String bpmn, String png) {
		//方法1 通过bpmn和png资源进行部署
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getRepositoryService()
				.createDeployment()
				.addClasspathResource(bpmn)
				.addClasspathResource(png)
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
	public static void startProcessInstance() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getRuntimeService()
				.startProcessInstanceById("myProcess_1:1:4");  //这个是查看数据库中act_re_procdef表
	}

	/**
	 * 完成请假申请
	 */
	public static void complete() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getTaskService()
				.complete("17502"); //查看act_ru_task表
	}

	/**
	 * 查询当前正在执行任务
	 */
	public static void queryTask() {
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
	public static void queryDeploymentByName() {
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
	public static void queryAllDeplyoment() {
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
	 * 删除已经部署的Activiti流程
	 */
	public static void testDelete() {
		//得到流程引擎
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		//第一个参数是部署的流程的ID，第二个true表示是进行级联删除
		processEngine.getRepositoryService()
				.deleteDeployment("601", true);
	}
}
