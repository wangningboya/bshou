package cn.wy.bs.service.impl;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.entity.Demand;
import cn.wy.bs.mapper.DemandMapper;
import cn.wy.bs.service.DemandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
@Transactional
public class DemandServiceImpl implements DemandService {

	@Resource
	DemandMapper demandMapper;

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
	public int getDemandNum(HashMap<String, Object> map) {
		return demandMapper.getDemandNum(map);
	}

	@Override
	public PageInfo<DemandDto> getDemandList(Integer pageNum, Integer pageSize, HashMap<String, Object> map) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<DemandDto> demandDtoPageInfo = new PageInfo<DemandDto>(demandMapper.getDemandList(map));
		return demandDtoPageInfo;
	}

	@Override
	public void saveDemand(Demand demand) {
		demandMapper.add(demand);
	}

	@Override
	public void updateDemand(Demand demand) {
		demandMapper.updateById(demand);
	}


}
