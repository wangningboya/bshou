package cn.wy.bs.service.impl;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.dto.DemandLogDto;
import cn.wy.bs.entity.Demand;
import cn.wy.bs.entity.DemandLog;
import cn.wy.bs.mapper.DemandLogMapper;
import cn.wy.bs.mapper.DemandMapper;
import cn.wy.bs.service.DemandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DemandServiceImpl implements DemandService {

	@Resource
	private  DemandMapper demandMapper;

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
	public void saveDemand(Demand demand) {
		demandMapper.insertSelective(demand);
	}

	@Override
	public void updateDemand(Demand demand) {
		demandMapper.updateByPrimaryKeySelective(demand);
	}

	@Override
	public List<DemandLogDto> getDemandLogById(HashMap<String, Object> map) {
		return demandLogMapper.getByDemandId(map);
	}

	@Override
	public int addDemandLog(DemandLog demandLog) {
		return demandLogMapper.insertSelective(demandLog);
	}
}
