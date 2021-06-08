package top.timebook.service;

import top.timebook.model.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiongzl
 * @since 2021-03-22
 */
public interface CategoryService extends IService<Category> {

    List<Category> getCategories(Map<String, Object> params);

    Category getCategory(Map<String, Object> params);

    Long addCategory(Category category);

    void deleteCategory(Long id);

    void updateCategory(Category category);
}
