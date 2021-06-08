package top.timebook.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.timebook.core.constant.BuzConstant;
import top.timebook.mapper.HabitMapper;
import top.timebook.model.Habit;
import top.timebook.service.HabitService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiongzl
 * @since 2021-03-19
 */
@Service
public class HabitServiceImpl extends ServiceImpl<HabitMapper, Habit> implements HabitService {

    @Resource
    private HabitMapper habitMapper;

    @Override
    public List<Habit> getHabits(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userId", params.get("userId"));
        queryWrapper.eq("status", BuzConstant.HABIT_SQL_STATUS_NORMAL);
        return habitMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addHabit(Habit habit) {
        habitMapper.insert(habit);
        return habit.getId();
    }

    @Override
    public Habit getHabit(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", params.get("id"));
        queryWrapper.eq("status", BuzConstant.HABIT_SQL_STATUS_NORMAL);
        return habitMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteHabit(Long id) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("updateTime", new Date());
        updateWrapper.set("status", BuzConstant.HABIT_SQL_STATUS_DELETED);
        updateWrapper.eq("id", id);
        habitMapper.update(null, updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateHabit(Habit habit) {
        if(ObjectUtil.equal(habit.getApply(), BuzConstant.HABIT_NOT_USE)){
            habit.setStopUseTime(new Date());
        }
        habitMapper.updateById(habit);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void disabledHabit(Long id) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("updateTime", new Date());
        updateWrapper.set("status", BuzConstant.HABIT_SQL_STATUS_DISABLED);
        updateWrapper.eq("id", id);
        habitMapper.update(null, updateWrapper);
    }

    @Override
    public List<Map<String, Object>> getHabitList(Map<String, Object> params) {
        Long userId = Long.parseLong(params.get("userId").toString());
        String date = params.get("time").toString();
        List<Map<String, Object>> habitList = habitMapper.getHabitList(userId, date);
        for (Map<String, Object> map : habitList) {
            if(ObjectUtil.equal(map.get("hide"), BuzConstant.HABIT_DISPLAY)){
                map.put("display", true);
            } else {
                map.put("display", false);
            }
        }
        return habitList;
    }

}
