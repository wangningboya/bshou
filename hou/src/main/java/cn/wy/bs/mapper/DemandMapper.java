package cn.wy.bs.mapper;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.entity.Demand;

import java.util.HashMap;
import java.util.List;

public interface DemandMapper {

    public List<DemandDto> findDemand(HashMap<String,Object> map);

    public void add(Demand demand);
}
