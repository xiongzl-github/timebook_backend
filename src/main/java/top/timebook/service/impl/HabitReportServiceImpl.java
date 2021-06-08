package top.timebook.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.transaction.annotation.Transactional;
import top.timebook.model.HabitReport;
import top.timebook.mapper.HabitReportMapper;
import top.timebook.service.HabitReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
 * @since 2021-03-22
 */
@Service
public class HabitReportServiceImpl extends ServiceImpl<HabitReportMapper, HabitReport> implements HabitReportService {

    @Resource
    private HabitReportMapper habitReportMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addHabitReport(HabitReport habitReport) {
        habitReportMapper.insert(habitReport);
        return habitReport.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateHabitReport(Map<String, Object> params) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("habitResult", params.get("habitResult"));
        updateWrapper.set("updateTime", new Date());
        updateWrapper.eq("id", params.get("id"));
        habitReportMapper.update(null, updateWrapper);
    }

    @Override
    public List<HabitReport> getHabitReports(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("habitId", params.get("habitId"));
        queryWrapper.ge("habitTime", params.get("startTime"));
        queryWrapper.lt("habitTime", params.get("endTime"));
        return habitReportMapper.selectList(queryWrapper);
    }
}
