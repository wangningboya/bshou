package cn.wy.bs.controller;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.entity.Demand;
import cn.wy.bs.service.DemandService;
import cn.wy.bs.utils.Page;
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
import java.util.Map;

@RestController
@RequestMapping(value = "/demand")
public class DemandController {

    @Resource
    private DemandService demandService;

    @RequestMapping(value = "/getDemandList" , method = RequestMethod.GET)
    public ResponseData getDemandList(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam HashMap<String, Object> map
    ){
        ResponseData responseData = new ResponseData();
        JSONObject jsonObject = new JSONObject();
        try{
            Page<DemandDto> demandDtoPage = new Page<DemandDto>();
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("map",map);
            demandDtoPage.setParams(map1);
            demandDtoPage.setPageNum(pageNum);
            demandDtoPage.setPageSize(pageSize);
            demandDtoPage.setOffset((pageNum-1)*pageSize);
            demandDtoPage.setTotal(demandService.getDemandNum(map));
            List<DemandDto> demandList = demandService.getDemandList(demandDtoPage);
            jsonObject.put("demandList", demandList);
            Map<String, Object> demandListPage = new HashMap<String, Object>();
            demandListPage.put("total",demandDtoPage.getTotal());
            demandListPage.put("pages",demandDtoPage.getPages());
            demandListPage.put("pageNum",demandDtoPage.getPageNum());
            demandListPage.put("pageSize",demandDtoPage.getPageSize());
            jsonObject.put("demandListPage",demandListPage);
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

    @RequestMapping(value = "/getDemand" , method = RequestMethod.GET)
    public ResponseData getDemand(
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
    public ResponseData addDemand(
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
        try {
            demandService.saveDemand(demand);
            responseData.setRspMsg("操作成功");
            responseData.setRspCode("000000");
        }catch (Exception e){
            responseData.setRspMsg(e.toString());
            responseData.setRspCode("999999");
        }
        return responseData;
    }

    @RequestMapping(value = "/updateDemand")
    public ResponseData updateDemand(
            HttpServletRequest request,
            @RequestParam HashMap<String, Object> map
    ){
        HttpSession session = request.getSession();
        ResponseData responseData = new ResponseData();
        Demand demand = new Demand();
        demand.setID(map.get("id").toString());
        demand.setModifiTime(new Date());
        demand.setModifiName(session.getAttribute("userName").toString());
        demand.setDemandName(map.get("demandName").toString());
        demand.setDemandDes(map.get("demandDes").toString());
        demand.setDemandNo(map.get("demandNo").toString());
        demand.setDemandType(Integer.parseInt(map.get("demandType").toString()));
        demand.setAccId(map.get("accId").toString());
        demand.setProjectId(map.get("projectId").toString());
        try {
            demandService.updateDemand(demand);
            responseData.setRspMsg("操作成功");
            responseData.setRspCode("000000");
        }catch (Exception e){
            responseData.setRspMsg(e.toString());
            responseData.setRspCode("999999");
        }
        return responseData;
    }
}
