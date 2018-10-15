package cn.wy.bs.mapper;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.entity.Demand;

import java.util.HashMap;
import java.util.List;

public interface DemandMapper {

    List<DemandDto> getDemand(HashMap<String, Object> map);

    void add(Demand demand);
}
