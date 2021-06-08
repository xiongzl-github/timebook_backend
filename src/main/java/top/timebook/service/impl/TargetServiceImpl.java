package top.timebook.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.timebook.core.constant.BuzConstant;
import top.timebook.mapper.TargetMapper;
import top.timebook.model.Target;
import top.timebook.service.TargetService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-16
 */
@Service
public class TargetServiceImpl extends ServiceImpl<TargetMapper, Target> implements TargetService {

    @Resource
    private TargetMapper targetMapper;

    @Override
    public List<Map<String, Object>> getTargets(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.allEq(params, false);
        List<Map<String, Object>> targetList = targetMapper.selectMaps(queryWrapper);
        List<Map<String, Object>> parentTargets = new ArrayList<>(20);
        List<Map<String, Object>> childTargets = null;
        for (int i = 0; i < targetList.size(); i++) {
            Map<String, Object> target = targetList.get(i);
            if(ObjectUtil.equal(Integer.valueOf(target.get("parentId").toString()), BuzConstant.TARGET_PARENT_NODE)){
                parentTargets.add(target);
                targetList.remove(i);
            }
        }
        for (Map<String, Object> parentTarget : parentTargets) {
            childTargets = new ArrayList<>(10);
            for (Map<String, Object> target : targetList) {
                if(ObjectUtil.equal(parentTarget.get("id").toString(), target.get("parentId").toString())){
                    childTargets.add(target);
                }
            }
            parentTarget.put("childTargets", childTargets);
        }
        return parentTargets;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addTarget(Target target) {
        targetMapper.insert(target);
        return target.getId();
    }

    @Override
    public Target getTarget(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", params.get("id"));
        queryWrapper.eq("status", BuzConstant.SQL_STATUS_NORMAL);
        return targetMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTarget(Long id) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("updateTime", new Date());
        updateWrapper.set("status", BuzConstant.SQL_STATUS_DELETED);
        updateWrapper.eq("id", id);
        targetMapper.update(null, updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTarget(Target target) {
        targetMapper.updateById(target);
    }
}
