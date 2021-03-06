package cn.wy.bs.controller;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.dto.DemandLogDto;
import cn.wy.bs.mapper.DemandLogMapper;
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
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/demand")
public class DemandController {

    @Resource
    private DemandService demandService;

    @Resource
    private DemandLogMapper demandLogMapper;

    /**
     * 获取需求
     */
    @RequestMapping(value = "/getDemandList", method = RequestMethod.GET)
    public ResponseData getDemandList(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            PageInfo<DemandDto> demandList = demandService.getDemandList(pageNum, pageSize, map);
            responseData.setData(demandList);
            responseData.setRspCode("000000");
        } catch (Exception e) {
            responseData.setRspCode("999999");
            responseData.setRspMsg("查询失败");
            return responseData;
        }
        return responseData;
    }

    /**
     * 获取单个需求DTO
     */
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

    @RequestMapping(value = "/getDemandTimeById", method = RequestMethod.GET)
    public ResponseData getDemandTimeById(
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            Double demandTime = demandService.getTimeById(map.get("id").toString());
            BigDecimal bg = new BigDecimal(demandTime / 60);
            demandTime = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            responseData.setData(demandTime);
            responseData.setRspCode("000000");
            return responseData;
        } catch (Exception e) {
            responseData.setRspCode("999999");
            responseData.setRspMsg("查询失败");
            return responseData;
        }
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
            demandService.updateDemand(session, map);
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

    /**
     * 需求审核
     */
    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public ResponseData review(
            HttpSession session,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            demandService.review(session, map);
            responseData.setRspMsg("操作成功");
            responseData.setRspCode("000000");
        } catch (Exception e) {
            responseData.setRspMsg(e.toString());
            responseData.setRspCode("999999");
        }
        return responseData;
    }

    /**
     * 工时预估
     */
    @RequestMapping(value = "/predict", method = RequestMethod.GET)
    public ResponseData predict(
            HttpSession session,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            demandService.predict(session, map);
            responseData.setRspMsg("操作成功");
            responseData.setRspCode("000000");
        } catch (Exception e) {
            responseData.setRspMsg(e.toString());
            responseData.setRspCode("999999");
        }
        return responseData;
    }

    @RequestMapping(value = "/startDev", method = RequestMethod.GET)
    public ResponseData startDev(
            HttpSession session,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            demandService.startDev(session, map);
            responseData.setRspMsg("操作成功");
            responseData.setRspCode("000000");
        } catch (Exception e) {
            responseData.setRspMsg(e.toString());
            responseData.setRspCode("999999");
        }
        return responseData;
    }

    @RequestMapping(value = "/pauseDev", method = RequestMethod.GET)
    public ResponseData pauseDev(
            HttpSession session,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            demandService.pauseDev(session, map);
            responseData.setRspMsg("操作成功");
            responseData.setRspCode("000000");
        } catch (Exception e) {
            responseData.setRspMsg(e.toString());
            responseData.setRspCode("999999");
        }
        return responseData;
    }

    @RequestMapping(value = "/endDev", method = RequestMethod.GET)
    public ResponseData endDev(
            HttpSession session,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            demandService.endDev(session, map);
            responseData.setRspMsg("操作成功");
            responseData.setRspCode("000000");
        } catch (Exception e) {
            responseData.setRspMsg(e.toString());
            responseData.setRspCode("999999");
        }
        return responseData;
    }

    @RequestMapping(value = "/passDev", method = RequestMethod.GET)
    public ResponseData passDev(
            HttpSession session,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            demandService.passDev(session, map);
            responseData.setRspMsg("操作成功");
            responseData.setRspCode("000000");
            return responseData;
        } catch (Exception e) {
            responseData.setRspMsg(e.toString());
            responseData.setRspCode("999999");
            return responseData;
        }
    }

    @RequestMapping(value = "/failDev", method = RequestMethod.GET)
    public ResponseData failDev(
            HttpSession session,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            demandService.failDev(session, map);
            responseData.setRspMsg("操作成功");
            responseData.setRspCode("000000");
            return responseData;
        } catch (Exception e) {
            responseData.setRspMsg(e.toString());
            responseData.setRspCode("999999");
            return responseData;
        }
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
