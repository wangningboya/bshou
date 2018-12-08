package cn.wy.bs.controller;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.dto.DemandLogDto;
import cn.wy.bs.service.DemandService;
import cn.wy.bs.utils.ResponseData;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/demand")
public class DemandController {

	@Resource
	private DemandService demandService;

	@RequestMapping(value = "/getDemandList", method = RequestMethod.GET)
	public ResponseData getDemandList(
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam HashMap<String, Object> map
	) {
		ResponseData responseData = new ResponseData();
		String a;
		try {
			PageInfo<DemandDto> demandList = demandService.getDemandList(pageNum, pageSize, map);
			responseData.setData(demandList);
			responseData.setRspCode("000000");
		} catch (Exception e) {
			responseData.setRspCode("999999");
			responseData.setRspMsg("查询失败");
			System.out.println(e);
			return responseData;
		}
		return responseData;
	}

	@RequestMapping(value = "/getDemand", method = RequestMethod.GET)
	public ResponseData getDemand(
			@RequestParam HashMap<String, Object> map
	) {
		ResponseData responseData = new ResponseData();
		JSONObject jsonObject = new JSONObject();
		try {
			DemandDto demandDto = demandService.getDemand(map);
			jsonObject.put("demand", demandDto);
			responseData.setData(jsonObject);
			responseData.setRspCode("000000");
		} catch (Exception e) {
			responseData.setRspCode("999999");
			responseData.setRspMsg("查询失败");
			System.out.println(e);
			return responseData;
		}
		return responseData;
	}

	@RequestMapping(value = "/getDemandListByDevId", method = RequestMethod.GET)
	public ResponseData getDemandListByDevId(
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam HashMap<String, Object> map
	) {
		ResponseData responseData = new ResponseData();
		try {
			PageInfo<DemandDto> demandList = demandService.getDemandListByDevId(pageNum, pageSize, map);
			responseData.setData(demandList);
			responseData.setRspCode("000000");
		} catch (Exception e) {
			responseData.setRspCode("999999");
			responseData.setRspMsg("查询失败");
			System.out.println(e);
			return responseData;
		}
		return responseData;
	}

	@RequestMapping(value = "/getDemandListByCreactName", method = RequestMethod.GET)
	public ResponseData getDemandListByCreactName(
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam HashMap<String, Object> map
	) {
		ResponseData responseData = new ResponseData();
		try {
			PageInfo<DemandDto> demandList = demandService.getDemandListByCreactName(pageNum, pageSize, map);
			responseData.setData(demandList);
			responseData.setRspCode("000000");
		} catch (Exception e) {
			responseData.setRspCode("999999");
			responseData.setRspMsg("查询失败");
			System.out.println(e);
			return responseData;
		}
		return responseData;
	}

	@RequestMapping(value = "/addDemand")
	public ResponseData addDemand(
			HttpSession session,
			@RequestParam HashMap<String, Object> map
	) {
		ResponseData responseData = new ResponseData();

		try {
			demandService.saveDemand(session, map);
			responseData.setRspMsg("操作成功");
			responseData.setRspCode("000000");
		} catch (Exception e) {
			responseData.setRspMsg(e.toString());
			responseData.setRspCode("999999");
		}
		return responseData;
	}

	@RequestMapping(value = "/updateDemand")
	public ResponseData updateDemand(
			HttpSession session,
			@RequestParam HashMap<String, Object> map
	) {
		ResponseData responseData = new ResponseData();
		try {
			demandService.updateDemand(session,map);
			responseData.setRspMsg("操作成功");
			responseData.setRspCode("000000");
		} catch (Exception e) {
			responseData.setRspMsg(e.toString());
			responseData.setRspCode("999999");
		}
		return responseData;
	}

	@RequestMapping(value = "/addDemandLog")
	public ResponseData addDemandLog(
			HttpSession session,
			@RequestParam HashMap<String, Object> map
	) {
		ResponseData responseData = new ResponseData();
		try {
			demandService.addDemandLog(session, map);
			responseData.setRspMsg("操作成功");
			responseData.setRspCode("000000");
		} catch (Exception e) {
			responseData.setRspMsg(e.toString());
			responseData.setRspCode("999999");
		}
		return responseData;
	}

	@RequestMapping(value = "/review")
	public ResponseData review(
			HttpSession session,
			@RequestParam HashMap<String, Object> map
	) {
		ResponseData responseData = new ResponseData();
		try {
			demandService.addDemandLog(session, map);
			responseData.setRspMsg("操作成功");
			responseData.setRspCode("000000");
		} catch (Exception e) {
			responseData.setRspMsg(e.toString());
			responseData.setRspCode("999999");
		}
		return responseData;
	}

	@RequestMapping(value = "/getDemandLogById", method = RequestMethod.GET)
	public ResponseData getDemandLogById(
			@RequestParam HashMap<String, Object> map
	) {
		ResponseData responseData = new ResponseData();
		List<DemandLogDto> demandLogDtoList = demandService.getDemandLogById(map);
		responseData.setData(demandLogDtoList);
		return responseData;
	}

}
