package top.timebook.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import top.timebook.core.result.OperationResult;
import top.timebook.core.result.ResponseResult;
import top.timebook.model.Habit;
import top.timebook.service.HabitService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiongzl
 * @since 2021-03-19
 */
@Slf4j
@RestController
@RequestMapping("/api/habits")
public class HabitController {

    @Resource
    private HabitService habitService;

    /**
     * 根据用户 id 获取所有用户 habit
     * @param params
     * @return
     */
    @GetMapping("/userId")
    public ResponseResult<List<Habit>> getHabits(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "HabitController.getHabits", params);
        List<Habit> habits = habitService.getHabits(params);
        log.info("result: {}", habits);
        return OperationResult.makeOKRsp(habits);
    }

    /**
     * 根据 id 查询habit
     * @param params
     * @return
     */
    @GetMapping("/list")
    public ResponseResult<List<Map<String, Object>>> getHabitList(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "HabitController.getHabitList", params);
        List<Map<String, Object>> habitList = habitService.getHabitList(params);
        log.info("result: {}", habitList);
        return OperationResult.makeOKRsp(habitList);
    }

    /**
     * 添加habit
     * @param habit
     * @return
     */
    @PostMapping
    public ResponseResult addHabit(@RequestBody Habit habit){
        log.info("methodName: {}, params: {}", "HabitController.addHabit", habit);
        long id = habitService.addHabit(habit);
        log.info("result: {}", id);
        return OperationResult.makeOKRsp(id);
    }

    /**
     * 根据 id 删除habit
     * @param id
     * @return
     */
    @DeleteMapping
    public ResponseResult deleteHabit(@RequestParam Long id){
        log.info("methodName: {}, params: {}", "HabitController.deleteHabit", id);
        habitService.deleteHabit(id);
        return OperationResult.makeOKRsp();
    }

    /**
     * 更新habit
     * @param habit
     * @return
     */
    @PutMapping
    public ResponseResult updateHabit(@RequestBody Habit habit){
        log.info("methodName: {}, params: {}", "HabitController.updateHabit", habit);
        habitService.updateHabit(habit);
        return OperationResult.makeOKRsp();
    }

    /**
     * 停用 habit
     * @param id
     * @return
     */
    @PutMapping("/disabled")
    public ResponseResult disabledHabit(@RequestParam Long id){
        log.info("methodName: {}, params: {}", "HabitController.disabledHabit", id);
        habitService.disabledHabit(id);
        return OperationResult.makeOKRsp();
    }







}

