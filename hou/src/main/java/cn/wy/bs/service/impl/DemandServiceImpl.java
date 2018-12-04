package cn.wy.bs.service.impl;

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

	@Override
	public void saveDemand(HttpSession session, HashMap<String, Object> map) {
		Demand demand = new Demand();
		DemandLog demandLog = new DemandLog();

		String uuid = BaseUtil.getUUID();
		demand.setCreateTime(new Date());
		demand.setCreateName(session.getAttribute("userName").toString());
		demand.setID(uuid);
		demand.setDemandName(map.get("demandName").toString());
		demand.setDemandDes(map.get("demandDes").toString());
		demand.setDemandNo(map.get("demandNo").toString());
		demand.setDemandType(Integer.parseInt(map.get("demandType").toString()));
		demand.setAccId(map.get("accId").toString());
		demand.setProjectId(map.get("projectId").toString());
		demand.setIsDelete(0);
		demand.setState(0);

		demandLog.setID(BaseUtil.getUUID());
		demandLog.setOpeId(session.getAttribute("userName").toString());
		demandLog.setCreateName(session.getAttribute("userName").toString());
		demandLog.setCreateTime(new Date());
		demandLog.setOpeId(session.getAttribute("userName").toString());
		demandLog.setOpeTime(new Date());
		demandLog.setDemandId(uuid);
		demandLog.setDemandState(0);
		demandLog.setIsDelete(0);
		demandMapper.insertSelective(demand);
		demandLogMapper.insertSelective(demandLog);
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
}
