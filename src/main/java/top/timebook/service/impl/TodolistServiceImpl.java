package top.timebook.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.timebook.core.constant.BuzConstant;
import top.timebook.mapper.TodolistMapper;
import top.timebook.model.Todolist;
import top.timebook.service.TodolistService;

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
 * @since 2021-04-25
 */
@Service
public class TodolistServiceImpl extends ServiceImpl<TodolistMapper, Todolist> implements TodolistService {

    @Resource
    private TodolistMapper todolistsMapper;

    @Override
    public List<Map<String, Object>> getTodolists(Map<String, Object> params) {
        List<Map<String, Object>> todolists = todolistsMapper.getTodolists(params);
        for (Map<String, Object> todolist : todolists) {
            if(ObjectUtil.equal(todolist.get("display"), BuzConstant.TODOLIST_DISPLAY)){
                todolist.put("display", true);
            } else {
                todolist.put("display", false);
            }
        }
        return todolists;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addTodolist(Todolist todolist) {
        todolistsMapper.insert(todolist);
        return todolist.getId();
    }

    @Override
    public Todolist getTodolist(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", params.get("id"));
        queryWrapper.eq("status", BuzConstant.SQL_STATUS_NORMAL);
        return todolistsMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTodolist(Long id) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("updateTime", new Date());
        updateWrapper.set("status", BuzConstant.SQL_STATUS_DELETED);
        updateWrapper.eq("id", id);
        todolistsMapper.update(null, updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTodolist(Todolist todolists) {
        todolistsMapper.updateById(todolists);
    }
    
    
}
