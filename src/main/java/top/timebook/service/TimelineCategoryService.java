package top.timebook.service;

import top.timebook.model.TimelineCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiongzl
 * @since 2021-05-07
 */
public interface TimelineCategoryService extends IService<TimelineCategory> {

    List<TimelineCategory> getTimelineCategories(Map<String, Object> params);

    TimelineCategory getTimelineCategory(Map<String, Object> params);

    Long addTimelineCategory(TimelineCategory timelineCategory);

    void deleteTimelineCategory(Long id);

    void updateTimelineCategory(TimelineCategory timelineCategory);
}
