package com.ds.blog.controller;

import com.ds.blog.VO.ResultVO;
import com.ds.blog.entity.Category;
import com.ds.blog.service.impl.CategoryServiceImpl;
import com.ds.blog.utils.ResultVOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@EnableSwagger2
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @PostMapping("/createCategory")
    public ResultVO createCategory(@RequestBody Category category) {
        System.out.println(category.toString());
        try {
            Category serviceCategory = categoryService.createCategory(category);
            if (serviceCategory == null) {
                return ResultVOUtils.error("该分类类型已存在");
            }
            return ResultVOUtils.success(serviceCategory);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }
    }


    @DeleteMapping("/deleteCategory/{categoryId}")
    public ResultVO deleteCategory(@PathVariable(value = "categoryId") String categoryId) {
        try {
            Category category = categoryService.deleteCategory(categoryId);
            return ResultVOUtils.success(category);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }
    }

    @PostMapping("/updateCategory/{id}")
    public ResultVO updateCategory(@PathVariable(value = "id") String categoryId, Map<String, Object> reqMap) {
        try {
            Category queryCategory = categoryService.queryCategory(categoryId);
            if (queryCategory == null) {
                return ResultVOUtils.error("分类ID错误");
            }
            queryCategory.setCategoryType(reqMap.get("categoryType").toString());
            queryCategory.setCategoryName(reqMap.get("categoryName").toString());
            Category updateCategory = categoryService.updateCategory(queryCategory);
            return ResultVOUtils.success(updateCategory);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }
    }

    @GetMapping("/queryCategory/{categoryId}")
    public ResultVO queryCategory(@PathVariable(value = "categoryId") String categoryId) {
        try {
            Category category = categoryService.queryCategory(categoryId);
            return ResultVOUtils.success(category);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }
    }

    @GetMapping("/queryCategory")
    public ResultVO queryCategory() {
        try {
            List<Category> categoryList = categoryService.queryAllCategory();
            return ResultVOUtils.success(categoryList);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }
    }

    @GetMapping("/queryCategoryType")
    public ResultVO queryCategoryType(@RequestBody List<String> categoryList) {
        try {
            List<Category> categoryTypeList = categoryService.queryAllByCategoryTypeList(categoryList);
            return ResultVOUtils.success(categoryTypeList);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }
    }
}
