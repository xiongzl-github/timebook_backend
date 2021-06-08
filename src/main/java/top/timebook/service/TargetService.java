package top.timebook.service;

import top.timebook.model.Target;
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
public interface TargetService extends IService<Target> {

    List<Map<String, Object>> getTargets(Map<String, Object> params);

    Target getTarget(Map<String, Object> params);

    Long addTarget(Target target);

    void updateTarget(Target target);

    void deleteTarget(Long id);
}
