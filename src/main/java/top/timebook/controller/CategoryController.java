package top.timebook.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import top.timebook.core.result.OperationResult;
import top.timebook.core.result.ResponseResult;
import top.timebook.model.Category;
import top.timebook.service.CategoryService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiongzl
 * @since 2021-03-22
 */
@Slf4j
@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    @Resource
    private CategoryService categoryService;

    /**
     * 根据用户 id, type 获取所有的 categories
     * @param params
     * @return
     */
    @GetMapping("/userId")
    public ResponseResult<List<Category>> getCategories(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "CategoryController.getCategories", params);
        List<Category> categories = categoryService.getCategories(params);
        log.info("result: {}", categories);
        return OperationResult.makeOKRsp(categories);
    }

    /**
     * 根据 id 获取 category 详情
     * @param params
     * @return
     */
    @GetMapping
    public ResponseResult<Category> getCategory(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "CategoryController.getCategory", params);
        Category category = categoryService.getCategory(params);
        log.info("result: {}", category);
        return OperationResult.makeOKRsp(category);
    }

    /**
     * 添加Category
     * @param category
     * @return
     */
    @PostMapping
    public ResponseResult addCategory(@RequestBody Category category){
        log.info("methodName: {}, params: {}", "CategoryController.addCategory", category);
        Long id = categoryService.addCategory(category);
        log.info("result: {}", id);
        return OperationResult.makeOKRsp(id);
    }

    /**
     * 根据 id 删除Category
     * @param id
     * @return
     */
    @DeleteMapping
    public ResponseResult deleteCategory(@RequestParam Long id){
        log.info("methodName: {}, params: {}", "CategoryController.deleteCategory", id);
        categoryService.deleteCategory(id);
        return OperationResult.makeOKRsp();
    }

    /**
     * 更新Category
     * @param category
     * @return
     */
    @PutMapping
    public ResponseResult updateCategory(@RequestBody Category category){
        log.info("methodName: {}, params: {}", "CategoryController.updateCategory", category);
        categoryService.updateCategory(category);
        return OperationResult.makeOKRsp();
    }
    
}

