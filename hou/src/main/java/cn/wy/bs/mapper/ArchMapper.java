package cn.wy.bs.mapper;


import cn.wy.bs.entity.Arch;
import cn.wy.bs.utils.BaseMapper;

import java.util.List;

/**
 * @author wy
 * @date 2019-01-09
 */
public interface ArchMapper extends BaseMapper<Arch>{

    List<Arch> getArchs();
}
