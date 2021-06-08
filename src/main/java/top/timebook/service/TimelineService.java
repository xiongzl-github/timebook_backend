package top.timebook.service;

import top.timebook.model.Timeline;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-25
 */
public interface TimelineService extends IService<Timeline> {

    List<Map<String, Object>> getTimelineTodolists(Map<String, Object> params);

    List<Map<String, Object>> getTimelines(Map<String, Object> params);

    Timeline getTimeline(Map<String, Object> params);

    Long addTimeline(Timeline timeline);

    void deleteTimeline(Long id);

    void updateTimeline(Timeline timeline);
}
