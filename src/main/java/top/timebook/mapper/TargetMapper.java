package top.timebook.mapper;

import top.timebook.model.Target;
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
public interface TargetMapper extends BaseMapper<Target> {

    List<Map<String, Object>> getTargetsOfCascader(List<Integer> targetIds);
}
