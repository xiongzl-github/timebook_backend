package top.timebook.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.timebook.core.constant.BuzConstant;
import top.timebook.mapper.TimelineCategoryMapper;
import top.timebook.model.TimelineCategory;
import top.timebook.service.TimelineCategoryService;

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
 * @since 2021-05-07
 */
@Service
public class TimelineCategoryServiceImpl extends ServiceImpl<TimelineCategoryMapper, TimelineCategory> implements TimelineCategoryService {

    @Resource
    private TimelineCategoryMapper timelineCategoryMapper;

    @Override
    public List<TimelineCategory> getTimelineCategories(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.allEq(params, false);
        return timelineCategoryMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addTimelineCategory(TimelineCategory timelineCategory) {
        timelineCategoryMapper.insert(timelineCategory);
        return timelineCategory.getId();
    }

    @Override
    public TimelineCategory getTimelineCategory(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.allEq(params, false);
        return timelineCategoryMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTimelineCategory(Long id) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("updateTime", new Date());
        updateWrapper.set("status", BuzConstant.SQL_STATUS_DELETED);
        updateWrapper.eq("id", id);
        timelineCategoryMapper.update(null, updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTimelineCategory(TimelineCategory timelineCategory) {
        timelineCategoryMapper.updateById(timelineCategory);
    }
    
}
