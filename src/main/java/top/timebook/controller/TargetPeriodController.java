package top.timebook.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import top.timebook.core.result.OperationResult;
import top.timebook.core.result.ResponseResult;
import top.timebook.model.TargetPeriod;
import top.timebook.service.TargetPeriodService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-16
 */
@Slf4j
@RestController
@RequestMapping("/api/targetPeriods")
public class TargetPeriodController {

    @Resource
    private TargetPeriodService targetPeriodService;

    /**
     * 查询 targetPeriod 列表
     * @param params
     * @return
     */
    @GetMapping("/list")
    public ResponseResult<List<Map<String, Object>>> getTargetPeriods(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "TargetPeriodController.getTargetPeriods", params);
        List<Map<String, Object>> targetPeriods = targetPeriodService.getTargetPeriods(params);
        log.info("result: {}", targetPeriods);
        return OperationResult.makeOKRsp(targetPeriods);
    }

    /**
     * 查询 targetPeriod 列表
     * @param params
     * @return
     */
    @GetMapping("/todolist/cascader")
    public ResponseResult<List<Map<String, Object>>> getTargetPeriodsOfTodolistCascader(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "TargetPeriodController.getTargetPeriodsOfTodolistCascader", params);
        List<Map<String, Object>> targetPeriods = targetPeriodService.getTargetPeriodsOfTodolistCascader(params);
        log.info("result: {}", targetPeriods);
        return OperationResult.makeOKRsp(targetPeriods);
    }

    /**
     * 根据 id 查血 targetPeriod
     * @param params
     * @return
     */
    @GetMapping
    public ResponseResult<TargetPeriod> getTargetPeriod(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "TargetPeriodController.getTargetPeriod", params);
        TargetPeriod targetPeriod = targetPeriodService.getTargetPeriod(params);
        log.info("result: {}", targetPeriod);
        return OperationResult.makeOKRsp(targetPeriod);
    }

    /**
     * 添加 targetPeriod
     * @param targetPeriod
     * @return
     */
    @PostMapping
    public ResponseResult addTargetPeriod(@RequestBody TargetPeriod targetPeriod){
        log.info("methodName: {}, params: {}", "TargetPeriodController.addTargetPeriod", targetPeriod);
        Long id = targetPeriodService.addTargetPeriod(targetPeriod);
        log.info("result: {}", id);
        return OperationResult.makeOKRsp(id);
    }

    /**
     * 根据 id 删除 targetPeriod
     * @param id
     * @return
     */
    @DeleteMapping
    public ResponseResult deleteTargetPeriod(@RequestParam Long id){
        log.info("methodName: {}, params: {}", "TargetPeriodController.deleteTargetPeriod", id);
        targetPeriodService.deleteTargetPeriod(id);
        return OperationResult.makeOKRsp();
    }

    /**
     * 更新 targetPeriod
     * @param targetPeriod
     * @return
     */
    @PutMapping
    public ResponseResult updateTargetPeriod(@RequestBody TargetPeriod targetPeriod){
        log.info("methodName: {}, params: {}", "TargetPeriodController.updateTargetPeriod", targetPeriod);
        targetPeriodService.updateTargetPeriod(targetPeriod);
        return OperationResult.makeOKRsp();
    }






}

