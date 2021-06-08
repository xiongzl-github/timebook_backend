package top.timebook.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.timebook.core.constant.BuzConstant;
import top.timebook.mapper.MottoMapper;
import top.timebook.model.Motto;
import top.timebook.service.MottoService;

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
public class MottoServiceImpl extends ServiceImpl<MottoMapper, Motto> implements MottoService {

    @Resource
    private MottoMapper mottoMapper;

    @Override
    public List<Motto> getMottos(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userId", params.get("userId"));
        queryWrapper.eq("status", BuzConstant.SQL_STATUS_NORMAL);
        return mottoMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addMotto(Motto motto) {
        mottoMapper.insert(motto);
        return motto.getId();
    }

    @Override
    public Motto getMotto(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", params.get("id"));
        queryWrapper.eq("status", BuzConstant.SQL_STATUS_NORMAL);
        return mottoMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteMotto(Long id) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("updateTime", new Date());
        updateWrapper.set("status", BuzConstant.SQL_STATUS_DELETED);
        updateWrapper.eq("id", id);
        mottoMapper.update(null, updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMotto(Motto motto) {
        mottoMapper.updateById(motto);
    }
}
