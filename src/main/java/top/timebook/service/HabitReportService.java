package top.timebook.service;

import top.timebook.model.HabitReport;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiongzl
 * @since 2021-03-22
 */
public interface HabitReportService extends IService<HabitReport> {

    Long addHabitReport(HabitReport habitReport);

    void updateHabitReport(Map<String, Object> params);

    List<HabitReport> getHabitReports(Map<String, Object> params);
}
