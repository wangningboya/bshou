package cn.wy.bs.controller;

import cn.wy.bs.entity.Demand;
import cn.wy.bs.service.DemandService;
import cn.wy.bs.utils.ResponseData;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/demand")
public class DemandController {

    @Resource
    private DemandService demandService;

    @RequestMapping(value = "/findDemand" , method = RequestMethod.GET)
    public ResponseData findDemand(
            @RequestParam HashMap<String,Object> map
    ){
        ResponseData responseData=new ResponseData();
        JSONObject jsonObject = new JSONObject();
        try{
            List<Demand> demandList=demandService.findDemand(map);
            jsonObject.put("demandList",demandList);
            responseData.setData(jsonObject);
            responseData.setRspCode("000000");
        }catch (Exception e){
            ResponseData responseData1 = new ResponseData();
            responseData1.setRspCode("999999");
            responseData.setRspMsg("查询失败");
            return responseData1;
        }
        return responseData;
    }
}
