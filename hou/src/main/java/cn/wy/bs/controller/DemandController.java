package cn.wy.bs.controller;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.entity.Demand;
import cn.wy.bs.service.DemandService;
import cn.wy.bs.utils.ResponseData;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/demand")
public class DemandController {

    @Resource
    private DemandService demandService;

    @RequestMapping(value = "/findDemand" , method = RequestMethod.GET)
    public ResponseData findDemand(
            @RequestParam HashMap<String, Object> map
    ){
        ResponseData responseData = new ResponseData();
        JSONObject jsonObject = new JSONObject();
        try{
            List<DemandDto> demandList = demandService.getDemand(map);
            jsonObject.put("demandList", demandList);
            responseData.setData(jsonObject);
            responseData.setRspCode("000000");
        }catch (Exception e){
            ResponseData responseData1 = new ResponseData();
            responseData1.setRspCode("999999");
            responseData.setRspMsg("查询失败");
            System.out.println(e);
            return responseData1;
        }
        return responseData;
    }

    @RequestMapping(value = "/addDemand")
    public ResponseData addProject(
            HttpServletRequest request,
            @RequestParam HashMap<String, Object> map
    ){
        HttpSession session = request.getSession();
        ResponseData responseData = new ResponseData();
        Demand demand = new Demand();
        demand.setCreateTime(new Date());
        demand.setCreateName(session.getAttribute("userName").toString());
        demand.setDemandName(map.get("demandName").toString());
        demand.setDemandDes(map.get("demandDes").toString());
        demand.setDemandNo(map.get("demandNo").toString());
        demand.setDemandType(Integer.parseInt(map.get("demandType").toString()));
        demand.setAccId(map.get("accId").toString());
        demand.setProjectId(map.get("projectId").toString());
        demandService.saveDemand(demand);
        responseData.setRspCode("000000");
        return responseData;
    }
}
