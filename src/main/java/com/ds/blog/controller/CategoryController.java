package com.ds.blog.controller;

import com.ds.blog.VO.ResultVO;
import com.ds.blog.entity.Category;
import com.ds.blog.service.impl.CategoryServiceImpl;
import com.ds.blog.utils.ResultVOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
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
        Category serviceCategory = categoryService.createCategory(category);
        return ResultVOUtils.success(serviceCategory);
    }


    @DeleteMapping("/deleteCategory/{categoryId}")
    public ResultVO deleteCategory(@PathVariable(value = "categoryId") String categoryId) {
        Category category = categoryService.deleteCategory(categoryId);
        return ResultVOUtils.success(category);
    }

    @PostMapping("/updateCategory")
    public ResultVO updateCategory(Category category) {
        Category updateCategory = categoryService.updateCategory(category);
        return ResultVOUtils.success(updateCategory);
    }

    @GetMapping("/queryCategory/{categoryId}")
    public ResultVO queryCategory(@PathVariable(value = "categoryId") String categoryId) {
        Category category = categoryService.queryCategory(categoryId);
        return ResultVOUtils.success(category);
    }

    @GetMapping("/queryCategory")
    public ResultVO queryCategory(){
        List<Category> categoryList = categoryService.queryAllCategory();
        return ResultVOUtils.success(categoryList);
    }
}
