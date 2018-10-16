package cn.wy.bs.mapper;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.entity.Demand;
import cn.wy.bs.utils.Page;

import java.util.HashMap;
import java.util.List;

public interface DemandMapper {

    List<DemandDto> getDemand(HashMap<String, Object> map);

    int getDemandNum(HashMap<String, Object> map);

    List<DemandDto> getDemandList(Page<DemandDto> demandDtoPage);

    void add(Demand demand);
}
