package cn.wy.bs.controller;

import cn.wy.bs.utils.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public ResponseData test(
//			@RequestParam int a
//			@RequestBody Test test
			@RequestParam HashMap<String,Object> map
	) {
		ResponseData responseData = new ResponseData();

//		System.out.println(a);
//		System.out.println(test.toString());
		System.out.println(map.get("test1"));
		System.out.println(map.get("test2"));
		return responseData;
	}

	@RequestMapping(value = "/exceptionTest", method = RequestMethod.POST)
	public void test(
	) {
		int a=8/0;
	}

}
