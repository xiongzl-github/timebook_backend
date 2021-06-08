package top.timebook.service;

import top.timebook.model.TargetPeriod;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-16
 */
public interface TargetPeriodService extends IService<TargetPeriod> {

    List<Map<String, Object>> getTargetPeriods(Map<String, Object> params);

    TargetPeriod getTargetPeriod(Map<String, Object> params);

    Long addTargetPeriod(TargetPeriod targetPeriod);

    void deleteTargetPeriod(Long id);

    void updateTargetPeriod(TargetPeriod targetPeriod);

    List<Map<String, Object>> getTargetPeriodsOfTodolistCascader(Map<String, Object> params);
}
