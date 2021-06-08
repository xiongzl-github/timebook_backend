package top.timebook.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.timebook.core.constant.BuzConstant;
import top.timebook.mapper.TimelineMapper;
import top.timebook.mapper.TodolistMapper;
import top.timebook.model.Timeline;
import top.timebook.service.TimelineService;

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
 * @since 2021-04-25
 */
@Service
public class TimelineServiceImpl extends ServiceImpl<TimelineMapper, Timeline> implements TimelineService {


    @Resource
    private TimelineMapper timelineMapper;

    @Resource
    private TodolistMapper todolistMapper;

    @Override
    public List<Map<String, Object>> getTimelineTodolists(Map<String, Object> params) {
        return todolistMapper.getTimelineTodolists(params);
    }

    @Override
    public List<Map<String, Object>> getTimelines(Map<String, Object> params) {
        List<Map<String, Object>> timelines = timelineMapper.getTimelines(params);
        for (Map<String, Object> timeline : timelines) {
            if(ObjectUtil.equal(timeline.get("display"), BuzConstant.TIMELINE_DISPLAY)){
                timeline.put("display", true);
            } else {
                timeline.put("display", false);
            }
        }
        return timelines;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addTimeline(Timeline timeline) {
        timelineMapper.insert(timeline);
        return timeline.getId();
    }

    @Override
    public Timeline getTimeline(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", params.get("id"));
        queryWrapper.eq("status", BuzConstant.SQL_STATUS_NORMAL);
        return timelineMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTimeline(Long id) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("updateTime", new Date());
        updateWrapper.set("status", BuzConstant.SQL_STATUS_DELETED);
        updateWrapper.eq("id", id);
        timelineMapper.update(null, updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTimeline(Timeline timeline) {
        timelineMapper.updateById(timeline);
    }
}
