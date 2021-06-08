package top.timebook.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import top.timebook.core.result.OperationResult;
import top.timebook.core.result.ResponseResult;
import top.timebook.model.Todolist;
import top.timebook.service.TodolistService;

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
@RequestMapping("/api/todolists")
public class TodolistController {

    @Resource
    private TodolistService todolistService;

    /**
     * 根据用户 id 获取收集箱中所有的事项
     * @param params
     * @return
     */
    @GetMapping("/list")
    public ResponseResult<List<Map<String, Object>>> getTodolists(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "TodolistController.getTodolists", params);
        List<Map<String, Object>> todolists = todolistService.getTodolists(params);
        log.info("result: {}", todolists);
        return OperationResult.makeOKRsp(todolists);
    }

    /**
     * 根据 id 查询收集箱事项
     * @param params
     * @return
     */
    @GetMapping
    public ResponseResult<Todolist> getTodolist(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "TodolistController.getTodolist", params);
        Todolist todolist = todolistService.getTodolist(params);
        log.info("result: {}", todolist);
        return OperationResult.makeOKRsp(todolist);
    }

    /**
     * 添加收集箱事项
     * @param todolist
     * @return
     */
    @PostMapping
    public ResponseResult addTodolist(@RequestBody Todolist todolist){
        log.info("methodName: {}, params: {}", "TodolistController.addTodolist", todolist);
        Long id = todolistService.addTodolist(todolist);
        log.info("result: {}", id);
        return OperationResult.makeOKRsp(id);
    }

    /**
     * 根据 id 删除收集箱事项
     * @param id
     * @return
     */
    @DeleteMapping
    public ResponseResult deleteTodolist(@RequestParam Long id){
        log.info("methodName: {}, params: {}", "TodolistController.deleteTodolist", id);
        todolistService.deleteTodolist(id);
        return OperationResult.makeOKRsp();
    }

    /**
     * 更新收集箱事项
     * @param todolist
     * @return
     */
    @PutMapping
    public ResponseResult updateTodolist(@RequestBody Todolist todolist){
        log.info("methodName: {}, params: {}", "TodolistController.updateTodolist", todolist);
        todolistService.updateTodolist(todolist);
        return OperationResult.makeOKRsp();
    }

    
    

}

