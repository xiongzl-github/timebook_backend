package top.timebook.mapper;

import org.apache.ibatis.annotations.Param;
import top.timebook.model.Habit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiongzl
 * @since 2021-03-22
 */
public interface HabitMapper extends BaseMapper<Habit> {

    List<Map<String, Object>> getHabitList(@Param("userId") Long userId, @Param("date") String date);
}
