package cn.wy.bs.controller;

import cn.wy.bs.entity.Arch;
import cn.wy.bs.service.ArchService;
import cn.wy.bs.utils.ResponseData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author wy
 * @date 2019-01-09
 */
@RestController
@RequestMapping(value = "/arch")
public class ArchController {

    @Resource
    private ArchService archService;

    /**
     * 获取所有架构
     */
    @RequestMapping(value = "/getArchs", method = RequestMethod.GET)
    public ResponseData getArchs() {
        ResponseData responseData = new ResponseData();
        try {
            List<Arch> archList = archService.getArchs();
            responseData.setData(archList);
            responseData.setRspCode("000000");
            return responseData;
        } catch (Exception e) {
            responseData.setRspCode("999999");
            responseData.setRspMsg("查询失败");
            return responseData;
        }
    }

    /**
     * 新增架构
     */
    @RequestMapping(value = "/archCreate", method = RequestMethod.POST)
    public ResponseData archCreate(
            HttpSession session,
            @RequestBody(required = false) Arch arch
//            @RequestParam HashMap<String ,Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            archService.add(session, arch);
            responseData.setRspCode("000000");
            responseData.setRspMsg("新增成功");
            return responseData;
        } catch (Exception e) {
            responseData.setRspCode("999999");
            responseData.setRspMsg("新增失败");
            return responseData;
        }
    }

    /**
     * 修改架构
     */
    @RequestMapping(value = "/archUpdate", method = RequestMethod.GET)
    public ResponseData archUpdate(
            HttpSession session,
            @RequestParam HashMap<String ,Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            archService.update(session, map);
            responseData.setRspCode("000000");
            responseData.setRspMsg("修改成功");
            return responseData;
        } catch (Exception e) {
            responseData.setRspCode("999999");
            responseData.setRspMsg("修改失败");
            return responseData;
        }
    }

    /**
     * 删除架构
     */
    @RequestMapping(value = "/archRemove", method = RequestMethod.GET)
    public ResponseData archRemove(
            HttpSession session,
            @RequestParam HashMap<String ,Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            archService.delete(session, map);
            responseData.setRspCode("000000");
            responseData.setRspMsg("删除成功");
            return responseData;
        } catch (Exception e) {
            responseData.setRspCode("999999");
            responseData.setRspMsg("删除失败");
            return responseData;
        }
    }

}
