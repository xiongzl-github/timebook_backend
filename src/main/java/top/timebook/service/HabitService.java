package top.timebook.service;

import top.timebook.model.Habit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiongzl
 * @since 2021-03-19
 */
public interface HabitService extends IService<Habit> {

    List<Habit> getHabits(Map<String, Object> params);

    Habit getHabit(Map<String, Object> params);

    Long addHabit(Habit habit);

    void deleteHabit(Long id);

    void updateHabit(Habit habit);

    void disabledHabit(Long id);

    List<Map<String, Object>> getHabitList(Map<String, Object> params);
}
