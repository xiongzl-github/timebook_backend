package top.timebook.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.timebook.core.result.OperationResult;
import top.timebook.core.result.ResponseResult;
import top.timebook.model.HabitReport;
import top.timebook.service.HabitReportService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiongzl
 * @since 2021-03-22
 */
@Slf4j
@RestController
@RequestMapping("/api/habitReports")
public class HabitReportController {

    @Resource
    private HabitReportService habitReportService;

    /**
     * 添加habitReport
     * @param habitReport
     * @return
     */
    @PostMapping
    public ResponseResult addHabitReport(@RequestBody HabitReport habitReport){
        log.info("methodName: {}, params: {}", "HabitReportController.addHabitReport", habitReport);
        Long id = habitReportService.addHabitReport(habitReport);
        log.info("result: {}", id);
        return OperationResult.makeOKRsp(id);
    }

    /**
     * 根据habitReportId 更新 habitResult
     * @param params
     * @return
     */
    @PutMapping
    public ResponseResult updateHabitReport(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "HabitReportController.updateHabitReport", params);
        habitReportService.updateHabitReport(params);
        return OperationResult.makeOKRsp();
    }

    /**
     * 根据habitId, startTime, endTime 查询 habitReports
     * @param params
     * @return
     */
    @GetMapping("/time_range")
    public ResponseResult<List<HabitReport>> getHabitReports(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "HabitReportController.getHabitReports", params);
        List<HabitReport> habitReports = habitReportService.getHabitReports(params);
        log.info("result: {}", habitReports);
        return OperationResult.makeOKRsp(habitReports);
    }



}

