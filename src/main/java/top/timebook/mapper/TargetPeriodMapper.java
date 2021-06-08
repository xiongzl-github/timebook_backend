package top.timebook.mapper;

import org.apache.ibatis.annotations.Param;
import top.timebook.model.TargetPeriod;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-16
 */
public interface TargetPeriodMapper extends BaseMapper<TargetPeriod> {

    List<Map<String, Object>> getTargetPeriods(@Param("params") Map<String, Object> params);
}
