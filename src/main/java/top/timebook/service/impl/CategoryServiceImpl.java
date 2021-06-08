package top.timebook.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.timebook.core.constant.BuzConstant;
import top.timebook.mapper.CategoryMapper;
import top.timebook.model.Category;
import top.timebook.service.CategoryService;

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
 * @since 2021-03-22
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategories(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("type", params.get("type"));
        queryWrapper.eq("userId", params.get("userId"));
        queryWrapper.eq("status", BuzConstant.SQL_STATUS_NORMAL);
        return categoryMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addCategory(Category category) {
        categoryMapper.insert(category);
        return category.getId();
    }

    @Override
    public Category getCategory(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", params.get("id"));
        queryWrapper.eq("status", BuzConstant.SQL_STATUS_NORMAL);
        return categoryMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCategory(Long id) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("updateTime", new Date());
        updateWrapper.set("status", BuzConstant.SQL_STATUS_DELETED);
        updateWrapper.eq("id", id);
        categoryMapper.update(null, updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCategory(Category category) {
        categoryMapper.updateById(category);
    }
}
