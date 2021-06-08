package top.timebook.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.timebook.core.result.OperationResult;
import top.timebook.core.result.ResponseResult;
import top.timebook.model.TimelineCategory;
import top.timebook.service.TimelineCategoryService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiongzl
 * @since 2021-05-07
 */
@RestController
@Slf4j
@RequestMapping("/api/timelineCategories")
public class TimelineCategoryController {
    @Resource
    private TimelineCategoryService timelineCategoryService;

    /**
     * 根据用户 id 获取所有的 timelineCategories
     * @param params
     * @return
     */
    @GetMapping("/list")
    public ResponseResult<List<TimelineCategory>> getTimelineCategories(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "TimelineCategoryController.getTimelineCategories", params);
        List<TimelineCategory> categories = timelineCategoryService.getTimelineCategories(params);
        log.info("result: {}", categories);
        return OperationResult.makeOKRsp(categories);
    }

    /**
     * 根据 id 获取 timelineCategory 详情
     * @param params
     * @return
     */
    @GetMapping
    public ResponseResult<TimelineCategory> getTimelineCategory(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "TimelineCategoryController.getTimelineCategory", params);
        TimelineCategory timelineCategory = timelineCategoryService.getTimelineCategory(params);
        log.info("result: {}", timelineCategory);
        return OperationResult.makeOKRsp(timelineCategory);
    }

    /**
     * 添加Category
     * @param timelineCategory
     * @return
     */
    @PostMapping
    public ResponseResult addTimelineCategory(@RequestBody TimelineCategory timelineCategory){
        log.info("methodName: {}, params: {}", "TimelineCategoryController.addTimelineCategory", timelineCategory);
        Long id = timelineCategoryService.addTimelineCategory(timelineCategory);
        log.info("result: {}", id);
        return OperationResult.makeOKRsp(id);
    }

    /**
     * 根据 id 删除Category
     * @param id
     * @return
     */
    @DeleteMapping
    public ResponseResult deleteTimelineCategory(@RequestParam Long id){
        log.info("methodName: {}, params: {}", "TimelineCategoryController.deleteTimelineCategory", id);
        timelineCategoryService.deleteTimelineCategory(id);
        return OperationResult.makeOKRsp();
    }

    /**
     * 更新Category
     * @param timelineCategory
     * @return
     */
    @PutMapping
    public ResponseResult updateTimelineCategory(@RequestBody TimelineCategory timelineCategory){
        log.info("methodName: {}, params: {}", "TimelineCategoryController.updateTimelineCategory", timelineCategory);
        timelineCategoryService.updateTimelineCategory(timelineCategory);
        return OperationResult.makeOKRsp();
    }
}

