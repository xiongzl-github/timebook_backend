package top.timebook.mapper;

import org.apache.ibatis.annotations.Param;
import top.timebook.model.Timeline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-25
 */
public interface TimelineMapper extends BaseMapper<Timeline> {

    List<Map<String, Object>> getTimelines(@Param("params") Map<String, Object> params);
}
