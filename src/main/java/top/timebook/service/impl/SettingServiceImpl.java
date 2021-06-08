package top.timebook.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.transaction.annotation.Transactional;
import top.timebook.core.constant.BuzConstant;
import top.timebook.mapper.SettingMapper;
import top.timebook.model.Setting;
import top.timebook.model.Setting;
import top.timebook.mapper.SettingMapper;
import top.timebook.service.SettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
public class SettingServiceImpl extends ServiceImpl<SettingMapper, Setting> implements SettingService {

    @Resource
    private SettingMapper settingMapper;
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addSetting(Setting setting) {
        settingMapper.insert(setting);
        return setting.getId();
    }

    @Override
    public Setting getSetting(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.allEq(params, false);
        return settingMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSetting(Setting setting) {
        settingMapper.updateById(setting);
    }
}
