package top.timebook.service;

import top.timebook.model.Setting;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiongzl
 * @since 2021-05-07
 */
public interface SettingService extends IService<Setting> {

    Setting getSetting(Map<String, Object> params);

    Long addSetting(Setting setting);

    void updateSetting(Setting setting);
}
