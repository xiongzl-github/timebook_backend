package top.timebook.mapper;

import org.apache.ibatis.annotations.Param;
import top.timebook.model.Todolist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-25
 */
public interface TodolistMapper extends BaseMapper<Todolist> {

    List<Map<String, Object>> getTodolists(@Param("params") Map<String, Object> params);

    List<Map<String, Object>> getTimelineTodolists(@Param("params") Map<String, Object> params);
}
