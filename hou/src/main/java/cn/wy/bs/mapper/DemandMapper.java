package cn.wy.bs.mapper;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.entity.Demand;
import cn.wy.bs.utils.BaseMapper;
import java.util.HashMap;
import java.util.List;

public interface DemandMapper extends BaseMapper<Demand>{

    DemandDto getDemand(HashMap<String, Object> map);

	List<DemandDto> getDemandListByDevId(HashMap<String, Object> map);

	List<DemandDto> getDemandListByCreactName(HashMap<String, Object> map);

    List<DemandDto> getDemandList(HashMap<String, Object> map);

    void add(Demand demand);


}
