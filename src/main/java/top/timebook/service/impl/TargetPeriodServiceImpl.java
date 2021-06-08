package top.timebook.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.timebook.core.constant.BuzConstant;
import top.timebook.core.vo.ChosenTargetVO;
import top.timebook.mapper.CategoryMapper;
import top.timebook.mapper.TargetMapper;
import top.timebook.mapper.TargetPeriodMapper;
import top.timebook.model.TargetPeriod;
import top.timebook.service.TargetPeriodService;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-16
 */
@Service
public class TargetPeriodServiceImpl extends ServiceImpl<TargetPeriodMapper, TargetPeriod> implements TargetPeriodService {

    @Resource
    private TargetPeriodMapper targetPeriodMapper;

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private TargetMapper targetMapper;

    @Override
    public List<Map<String, Object>> getTargetPeriods(Map<String, Object> params) {
        List<Map<String, Object>> targetPeriods = targetPeriodMapper.getTargetPeriods(params);
        for (Map<String, Object> targetPeriod : targetPeriods) {
            if(ObjectUtil.equal(targetPeriod.get("display"), BuzConstant.TARGETPERIOD_DISPLAY)){
                targetPeriod.put("display", true);
            } else {
                targetPeriod.put("display", false);
            }
        }
        return targetPeriods;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addTargetPeriod(TargetPeriod targetPeriod) {
        targetPeriodMapper.insert(targetPeriod);
        return targetPeriod.getId();
    }

    @Override
    public TargetPeriod getTargetPeriod(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", params.get("id"));
        queryWrapper.eq("status", BuzConstant.SQL_STATUS_NORMAL);
        return targetPeriodMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTargetPeriod(Long id) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("updateTime", new Date());
        updateWrapper.set("status", BuzConstant.SQL_STATUS_DELETED);
        updateWrapper.eq("id", id);
        targetPeriodMapper.update(null, updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTargetPeriod(TargetPeriod targetPeriod) {
        targetPeriodMapper.updateById(targetPeriod);
    }

    @Override
    public List<Map<String, Object>> getTargetPeriodsOfTodolistCascader(Map<String, Object> params) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.allEq(params, false);
        List<TargetPeriod> targetPeriods = targetPeriodMapper.selectList(queryWrapper);
        List<Integer> targetIds = new ArrayList<>();
        for (TargetPeriod targetPeriod : targetPeriods) {
            Map<String, Object> map1 = new HashMap<>(10);
            map1.put("label", targetPeriod.getTargetPeriodName());
            map1.put("value", targetPeriod.getId());
            String chosenTargets = targetPeriod.getChosenTargets();
            List<ChosenTargetVO> chosenTargetVOS = JSON.parseArray(chosenTargets, ChosenTargetVO.class);
            for (ChosenTargetVO chosenTargetVO : chosenTargetVOS) {
                targetIds.add(Integer.valueOf(chosenTargetVO.getTargetId()));
            }
            List<Map<String, Object>> targetsOfCascader = targetMapper.getTargetsOfCascader(targetIds);
            List targetThemeList = new ArrayList();
            Map<String, Object> targetThemeMap = new HashMap<>(2);
            targetThemeMap.put("label", targetsOfCascader.get(0).get("themeName"));
            targetThemeMap.put("value", targetsOfCascader.get(0).get("targetThemeId"));
            targetThemeList.add(targetThemeMap);
            map1.put("children", targetThemeList);
            List<Map<String, Object>> parentTargetList = new ArrayList();
            for (Map<String, Object> map2 : targetsOfCascader) {
                Map<String, Object> parentTargetMap = new HashMap<>(10);
                if (ObjectUtil.isNotNull(map2.get("parentId"))) {
                    parentTargetMap.put("label", map2.get("parentTargetName"));
                    parentTargetMap.put("value", map2.get("parentId"));
                } else {
                    parentTargetMap.put("label", map2.get("targetName"));
                    parentTargetMap.put("value", map2.get("id"));
                }
                if (!parentTargetList.contains(parentTargetMap)) {
                    parentTargetList.add(parentTargetMap);
                }
            }
            for (Map<String, Object> parentMap : parentTargetList) {
                List<Map<String, Object>> targetList = new ArrayList<>(10);
                for (Map<String, Object> map3 : targetsOfCascader) {
                    if (ObjectUtil.equal(parentMap.get("value"), map3.get("parentId"))) {
                        Map<String, Object> targetMap = new HashMap<>(10);
                        targetMap.put("label", map3.get("targetName"));
                        targetMap.put("value", map3.get("id"));
                        targetList.add(targetMap);
                    }
                }
                parentMap.put("children", targetList);
            }
            targetThemeMap.put("children", parentTargetList);
            resultList.add(map1);
        }
        return resultList;
    }


}
