package top.timebook.service;

import top.timebook.model.Todolist;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-25
 */
public interface TodolistService extends IService<Todolist> {

    List<Map<String, Object>> getTodolists(Map<String, Object> params);

    Todolist getTodolist(Map<String, Object> params);

    Long addTodolist(Todolist todolist);

    void deleteTodolist(Long id);

    void updateTodolist(Todolist todolist);
}
