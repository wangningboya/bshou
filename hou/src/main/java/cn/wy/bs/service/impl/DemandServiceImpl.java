package cn.wy.bs.service.impl;

import cn.wy.bs.constant.enums.DemandStateEnum;
import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.dto.DemandLogDto;
import cn.wy.bs.entity.Demand;
import cn.wy.bs.entity.DemandLog;
import cn.wy.bs.mapper.DemandLogMapper;
import cn.wy.bs.mapper.DemandMapper;
import cn.wy.bs.service.DemandService;
import cn.wy.bs.utils.BaseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DemandServiceImpl implements DemandService {

    private static final String STATE = "state";

    @Resource
    private DemandMapper demandMapper;

    @Resource
    private DemandLogMapper demandLogMapper;

    @Override
    public DemandDto getDemand(HashMap<String, Object> map) {
        return demandMapper.getDemand(map);
    }

    @Override
    public PageInfo<DemandDto> getDemandListByDevId(Integer pageNum, Integer pageSize, HashMap<String, Object> map) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<DemandDto> demandDtoPageInfo = new PageInfo<DemandDto>(demandMapper.getDemandListByDevId(map));
        return demandDtoPageInfo;
    }

    @Override
    public PageInfo<DemandDto> getDemandListByCreactName(int pageNum, int pageSize, HashMap<String, Object> map) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<DemandDto> demandDtoPageInfo = new PageInfo<DemandDto>(demandMapper.getDemandListByCreactName(map));
        return demandDtoPageInfo;
    }

    @Override
    public PageInfo<DemandDto> getDemandList(Integer pageNum, Integer pageSize, HashMap<String, Object> map) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<DemandDto> demandDtoPageInfo = new PageInfo<DemandDto>(demandMapper.getDemandList(map));
        return demandDtoPageInfo;
    }

    /**
     * 新增需求
     *
     * @param session
     * @param map
     */
    @Override
    public void saveDemand(HttpSession session, HashMap<String, Object> map) {
        Demand demand = new Demand();

        demand.setCreateTime(new Date());
        demand.setCreateName(session.getAttribute("userName").toString());
        demand.setID(BaseUtil.getUUID());
        demand.setDemandName(map.get("demandName").toString());
        demand.setDemandDes(map.get("demandDes").toString());
        demand.setDemandNo(map.get("demandNo").toString());
        demand.setDemandType(Integer.parseInt(map.get("demandType").toString()));
        demand.setAccId(map.get("accId").toString());
        demand.setProjectId(map.get("projectId").toString());
        demand.setIsDelete(0);
        demand.setState(DemandStateEnum.T01.getIndex());

        demandMapper.insertSelective(demand);
        addDemandLogg(session, demand, DemandStateEnum.T01);
    }

    @Override
    public void updateDemand(HttpSession session, HashMap<String, Object> map) {
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

        demandMapper.updateByPrimaryKeySelective(demand);
    }

    @Override
    public List<DemandLogDto> getDemandLogById(HashMap<String, Object> map) {
        return demandLogMapper.getByDemandId(map);
    }

    @Override
    public void addDemandLog(HttpSession session, HashMap<String, Object> map) {
        DemandLog demandLog = new DemandLog();
        Demand demand = new Demand();

        demandLog.setID(BaseUtil.getUUID());
        demandLog.setOpeTime(new Date());
        demandLog.setOpeId(session.getAttribute("userName").toString());
        demandLog.setDemandState(Integer.parseInt(map.get("state").toString()));
        demandLog.setDemandId(map.get("id").toString());
        demandLog.setIsDelete(0);
        demandLog.setCreateTime(new Date());
        demandLog.setCreateName(session.getAttribute("userName").toString());

        demand.setID(map.get("id").toString());
        demand.setState(Integer.parseInt(map.get("state").toString()));
        demand.setModifiTime(new Date());
        demand.setModifiName(session.getAttribute("userName").toString());
        if (map.containsKey("expTime")) {
            if (map.get("expTime").toString() != null && map.get("expTime").toString() != "") {
                demand.setExpTime(Integer.parseInt(map.get("expTime").toString()));
            }
        }
        if (map.containsKey("devId")) {
            if (map.get("devId").toString() != null && map.get("devId").toString() != "") {
                demand.setDevId(map.get("devId").toString());
            }
        }
        if (map.containsKey("reviewDes")) {
            if (map.get("reviewDes").toString() != null && map.get("reviewDes").toString() != "") {
                demand.setReviewDes(map.get("reviewDes").toString());
            }
        }
        demandLogMapper.insertSelective(demandLog);
        demandMapper.updateByPrimaryKeySelective(demand);
    }

    /**
     * 需求评审
     *
     * @param session
     * @param map
     */
    @Override
    public void review(HttpSession session, HashMap<String, Object> map) {
        Demand demand = new Demand();

        demand.setID(map.get("id").toString());
        if (1 == Integer.parseInt(map.get(STATE).toString())) {
            demand.setState(DemandStateEnum.T02.getIndex());
        }
        if (0 == Integer.parseInt(map.get(STATE).toString())) {
            demand.setState(DemandStateEnum.T03.getIndex());
        }
        demand.setModifiTime(new Date());
        demand.setModifiName(session.getAttribute("userName").toString());

//		if (map.get("reviewDes").toString() != null && map.get("reviewDes").toString() != "") {
        demand.setReviewDes(map.get("reviewDes").toString());
//		}
        demandMapper.updateByPrimaryKeySelective(demand);
        if (1 == Integer.parseInt(map.get(STATE).toString())) {
            addDemandLogg(session, demand, DemandStateEnum.T02);
        }
        if (0 == Integer.parseInt(map.get(STATE).toString())) {
            addDemandLogg(session, demand, DemandStateEnum.T03);
        }

    }

    /**
     * 工时预估
     *
     * @param session
     * @param map
     */
    @Override
    public void predict(HttpSession session, HashMap<String, Object> map) {
        Demand demand = new Demand();

        demand.setID(map.get("id").toString());
        demand.setState(DemandStateEnum.T04.getIndex());
        demand.setModifiTime(new Date());
        demand.setModifiName(session.getAttribute("userName").toString());
        demand.setDevId(map.get("devId").toString());
        demand.setExpTime(Integer.parseInt(map.get("expTime").toString()));

        demandMapper.updateByPrimaryKeySelective(demand);
        addDemandLogg(session, demand, DemandStateEnum.T04);

    }

    /**
     * 开发开始
     * @param session
     * @param map
     */
    @Override
    public void startDev(HttpSession session, HashMap<String, Object> map) {
        Demand demand = new Demand();

        demand.setID(map.get("id").toString());
        demand.setState(DemandStateEnum.T05.getIndex());
        demand.setModifiTime(new Date());
        demand.setModifiName(session.getAttribute("userName").toString());

        demandMapper.updateByPrimaryKeySelective(demand);
        addDemandLogg(session, demand, DemandStateEnum.T05);
    }

    /**
     * 开发暂停
     * @param session
     * @param map
     */
    @Override
    public void pauseDev(HttpSession session, HashMap<String, Object> map) {
        Demand demand = new Demand();

        demand.setID(map.get("id").toString());
        demand.setState(DemandStateEnum.T06.getIndex());
        demand.setModifiTime(new Date());
        demand.setModifiName(session.getAttribute("userName").toString());

        demandMapper.updateByPrimaryKeySelective(demand);
        addDemandLogg(session, demand, DemandStateEnum.T06);
    }


    /**
     * 开发结束
     * @param session
     * @param map
     */
    @Override
    public void endDev(HttpSession session, HashMap<String, Object> map) {
        Demand demand = new Demand();

        demand.setID(map.get("id").toString());
        demand.setState(DemandStateEnum.T07.getIndex());
        demand.setModifiTime(new Date());
        demand.setModifiName(session.getAttribute("userName").toString());

        demandMapper.updateByPrimaryKeySelective(demand);
        addDemandLogg(session, demand, DemandStateEnum.T07);
    }

    /**
     * 新增需求日志
     *
     * @param session
     * @param demand
     * @param demandStateEnum
     */
    void addDemandLogg(
            HttpSession session,
            Demand demand,
            DemandStateEnum demandStateEnum
    ) {
        DemandLog demandLog = new DemandLog();
        demandLog.setID(BaseUtil.getUUID());
        demandLog.setOpeId(session.getAttribute("userName").toString());
        demandLog.setOpeTime(new Date());
        demandLog.setDemandId(demand.getID());
        demandLog.setDemandState(demandStateEnum.getIndex());
        demandLog.setDemandStateName(demandStateEnum.getName());
        demandLog.setCreateName(session.getAttribute("userName").toString());
        demandLog.setCreateTime(new Date());
        demandLog.setIsDelete(0);
        session.getAttribute("userName").toString();
        demandLogMapper.insert(demandLog);
    }
}
