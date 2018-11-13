package cn.wy.bs.mapper;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.dto.DemandLogDto;
import cn.wy.bs.entity.Demand;
import cn.wy.bs.entity.DemandLog;
import cn.wy.bs.utils.BaseMapper;

import java.util.HashMap;
import java.util.List;

public interface DemandLogMapper extends BaseMapper<DemandLog> {


	List<DemandLogDto> getByDemandId(HashMap<String, Object> map);
}
