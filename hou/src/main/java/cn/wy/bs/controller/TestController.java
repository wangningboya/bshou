package cn.wy.bs.controller;

import cn.wy.bs.dto.DemandLogDto;
import cn.wy.bs.service.DemandService;
import cn.wy.bs.utils.EasypoiUtil;
import cn.wy.bs.utils.ResponseData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Resource
	private DemandService demandService;

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

	//修改
	@RequestMapping(value = "/idtest/{id2222}", method = RequestMethod.POST)
	public ResponseData idtest(
			@PathVariable String id2222,
			@RequestBody HashMap<String, Object> map
	) {
		ResponseData responseData = new ResponseData();
		System.out.println("aaa");
		responseData.setRspMsg("000000");
		return responseData;
	}

	@RequestMapping(value = "/requesttest", method = RequestMethod.GET)
	public ResponseData requesttest(
			@RequestParam HashMap<String, Object> map
	) {
		ResponseData responseData = new ResponseData();
		System.out.println("aaa");
		responseData.setRspMsg("000000");
		return responseData;
	}

	@RequestMapping(value = "/{requesttest2}", method = RequestMethod.POST)
	public ResponseData requesttest2(
			@PathVariable String requesttest2,
			@RequestParam HashMap<String, Object> map
	) {
		ResponseData responseData = new ResponseData();
		System.out.println("aaa");
		responseData.setRspMsg("000000");
		return responseData;
	}

	@RequestMapping(value = "/requesttest2", method = RequestMethod.POST)
	public ResponseData requesttest3(
			@RequestParam HashMap<String, Object> map
	) {
		ResponseData responseData = new ResponseData();
		System.out.println("aaa");
		responseData.setRspMsg("000000");
		return responseData;
	}

	@RequestMapping(value = "/postTest", method = RequestMethod.POST)
	public ResponseData postTest(
			@RequestParam HashMap<String, Object> map1,
			@RequestBody HashMap<String, Object> map2
	) {
		ResponseData responseData = new ResponseData();
		return responseData;
	}

	@RequestMapping(value = "/getTest", method = RequestMethod.GET)
	public ResponseData getTest(
			@RequestParam HashMap<String, Object> map
	) {
		ResponseData responseData = new ResponseData();
		return responseData;
	}

	@RequestMapping("/exportexcel")
	public void exportExcel(HttpServletResponse response) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("id","19157d47d12611e8a75900ff834fbc5d");
		List<DemandLogDto> demandLogDtoList = demandService.getDemandLogById(map);
		EasypoiUtil.exportExcel(demandLogDtoList,"123","456",DemandLogDto.class,"wyexcel.xls",response);
	}

	@RequestMapping("/importexcel")
	public void importexcel() {
		List<DemandLogDto> demandLogDtoList = EasypoiUtil.importExcel("C:\\Users\\Administrator\\Desktop\\wyexcel.xls",1,1,DemandLogDto.class);
		System.out.println("asd");
	}

}
