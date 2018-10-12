package cn.wy.bs.service.impl;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.entity.Demand;
import cn.wy.bs.mapper.DemandMapper;
import cn.wy.bs.service.DemandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class DemandServiceImpl implements DemandService{

    @Resource
    DemandMapper demandMapper;

    @Override
    public List<DemandDto> findDemand(HashMap<String, Object> map) {
        return demandMapper.findDemand(map);
    }

    @Override
    public void addDemand(Demand demand) {
        demandMapper.add(demand);
    }
}
