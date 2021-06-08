package top.timebook.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.timebook.core.result.OperationResult;
import top.timebook.core.result.ResponseResult;
import top.timebook.model.Timeline;
import top.timebook.service.TimelineService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-25
 */
@Slf4j
@RestController
@RequestMapping("/api/timelines")
public class TimelineController {

    @Resource
    private TimelineService timelineService;

    /**
     * 获取当天所需要完成的所有任务
     * @param params
     * @return
     */
    @GetMapping("/todolists")
    public ResponseResult<List<Map<String, Object>>> getTimelineTodolists(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "TimelineController.getTimelineTodolists", params);
        List<Map<String, Object>> timelines = timelineService.getTimelineTodolists(params);
        log.info("result: {}", timelines);
        return OperationResult.makeOKRsp(timelines);
    }

    /**
     * 根据用户 id 获取timelines
     * @param params
     * @return
     */
    @GetMapping("/list")
    public ResponseResult<List<Map<String, Object>>> getTimelines(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "TimelineController.getTimelines", params);
        List<Map<String, Object>> timelines = timelineService.getTimelines(params);
        log.info("result: {}", timelines);
        return OperationResult.makeOKRsp(timelines);
    }

    /**
     * 根据 id 查询 timeline
     * @param params
     * @return
     */
    @GetMapping
    public ResponseResult<Timeline> getTimeline(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "TimelineController.getTimeline", params);
        Timeline timeline = timelineService.getTimeline(params);
        log.info("result: {}", timeline);
        return OperationResult.makeOKRsp(timeline);
    }

    /**
     * 添加 timeline
     * @param timeline
     * @return
     */
    @PostMapping
    public ResponseResult addTimeline(@RequestBody Timeline timeline){
        log.info("methodName: {}, params: {}", "TimelineController.addTimeline", timeline);
        Long id = timelineService.addTimeline(timeline);
        log.info("result: {}", id);
        return OperationResult.makeOKRsp(id);
    }

    /**
     * 根据 id 删除 timeline
     * @param id
     * @return
     */
    @DeleteMapping
    public ResponseResult deleteTimeline(@RequestParam Long id){
        log.info("methodName: {}, params: {}", "TimelineController.deleteTimeline", id);
        timelineService.deleteTimeline(id);
        return OperationResult.makeOKRsp();
    }

    /**
     * 更新 timeline
     * @param timeline
     * @return
     */
    @PutMapping
    public ResponseResult updateTimeline(@RequestBody Timeline timeline){
        log.info("methodName: {}, params: {}", "TimelineController.updateTimeline", timeline);
        timelineService.updateTimeline(timeline);
        return OperationResult.makeOKRsp();
    }



}

