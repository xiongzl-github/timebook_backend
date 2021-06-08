package top.timebook.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import top.timebook.core.result.OperationResult;
import top.timebook.core.result.ResponseResult;
import top.timebook.model.Target;
import top.timebook.service.TargetService;

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
@RequestMapping("/api/targets")
public class TargetController {
    @Resource
    private TargetService targetService;

    /**
     * 根据用户 id, type 获取所有的 targets
     * @param params
     * @return
     */
    @GetMapping("/list")
    public ResponseResult<List<Map<String, Object>>> getTargets(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "TargetController.getTargets", params);
        List<Map<String, Object>> targets = targetService.getTargets(params);
        log.info("result: {}", targets);
        return OperationResult.makeOKRsp(targets);
    }

    /**
     * 根据 id 获取 target 详情
     * @param params
     * @return
     */
    @GetMapping
    public ResponseResult<Target> getTarget(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "TargetController.getTarget", params);
        Target target = targetService.getTarget(params);
        log.info("result: {}", target);
        return OperationResult.makeOKRsp(target);
    }

    /**
     * 添加Target
     * @param target
     * @return
     */
    @PostMapping
    public ResponseResult addTarget(@RequestBody Target target){
        log.info("methodName: {}, params: {}", "TargetController.addTarget", target);
        Long id = targetService.addTarget(target);
        log.info("result: {}", id);
        return OperationResult.makeOKRsp(id);
    }

    /**
     * 根据 id 删除Target
     * @param id
     * @return
     */
    @DeleteMapping
    public ResponseResult deleteTarget(@RequestParam Long id){
        log.info("methodName: {}, params: {}", "TargetController.deleteTarget", id);
        targetService.deleteTarget(id);
        return OperationResult.makeOKRsp();
    }

    /**
     * 更新Target
     * @param target
     * @return
     */
    @PutMapping
    public ResponseResult updateTarget(@RequestBody Target target){
        log.info("methodName: {}, params: {}", "TargetController.updateTarget", target);
        targetService.updateTarget(target);
        return OperationResult.makeOKRsp();
    }
}

