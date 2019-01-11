package cn.wy.bs.service;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.dto.DemandLogDto;
import cn.wy.bs.entity.Demand;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public interface DemandService {

    /**
     * 获取需求信息
     */
    DemandDto getDemand(HashMap<String, Object> map);

    /**
     * 获取需求信息列表
     */
    PageInfo<DemandDto> getDemandList(Integer pageNum, Integer pageSize, HashMap<String, Object> map);

    /**
     * 根据开发人员获取需求信息列表
     */
    PageInfo<DemandDto> getDemandListByDevId(Integer pageNum, Integer pageSize, HashMap<String, Object> map);

    /**
     * 根据创建人员获取需求信息列表
     */
    PageInfo<DemandDto> getDemandListByCreactName(int pageNum, int pageSize, HashMap<String, Object> map);

    /**
     * 添加需求
     */
    void saveDemand(HttpSession session, HashMap<String, Object> map);

    /**
     * 修改需求
     */
    void updateDemand(HttpSession session, HashMap<String, Object> map);

    /**
     * 获取需求日志
     */
    List<DemandLogDto> getDemandLogById(HashMap<String, Object> map);

    /**
     * 新增需求日志
     */
    void addDemandLog(HttpSession session, HashMap<String, Object> map);

    /**
     * 需求评审
     */
    void review(HttpSession session, HashMap<String, Object> map);

    /**
     * 工时预估
     */
    void predict(HttpSession session, HashMap<String, Object> map);

    /**
     * 开始开发
     */
    void startDev(HttpSession session, HashMap<String, Object> map);

    /**
     * 开始暂停
     */
    void pauseDev(HttpSession session, HashMap<String, Object> map);

    /**
     * 开发结束
     */
    void endDev(HttpSession session, HashMap<String, Object> map);

    /**
     * 验收通过
     */
    void passDev(HttpSession session, HashMap<String, Object> map);

    /**
     * 验收未通过
     */
    void failDev(HttpSession session, HashMap<String, Object> map);

    /**
     * 问题转需求
     */
    void issueToDemand(HttpSession session, HashMap<String, Object> map);

    /**
     * 根据ID计算需求工时
     */
    Double getTimeById(String id);

    /**
     * 根据ID计算需求本月工时
     */
    Double getTimeByIdDuringTheMonth(String id);

    void updateDemandState(int originalState, int currentState);

}
