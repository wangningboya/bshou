package cn.wy.bs.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice  //不指定包默认加了@Controller和@RestController都能控制
//@ControllerAdvice(basePackages ="com.example.demo.controller")
public class GlobalException {

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Map<String, Object> exceptionHandler(Exception e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1001);
		map.put("mag", e.getMessage());
		System.out.println("bug");
		System.out.println(e.getMessage());
		System.out.println("bug");
		//发生异常进行日志记录，写入数据库或者其他处理，此处省略
		return map;
	}

}
