package top.timebook.service;

import top.timebook.model.Motto;
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
public interface MottoService extends IService<Motto> {

    List<Motto> getMottos(Map<String, Object> params);

    Motto getMotto(Map<String, Object> params);

    Long addMotto(Motto motto);

    void deleteMotto(Long id);

    void updateMotto(Motto motto);
}
