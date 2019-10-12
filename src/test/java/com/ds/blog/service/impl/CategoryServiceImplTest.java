package com.ds.blog.service.impl;

import com.ds.blog.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void createCategory() {
        Category category = new Category();
        category.setId("1122");
        category.setCategoryName("技术");
        category.setCategoryType("11");
        Category serviceCategory = categoryService.createCategory(category);
        System.out.println(serviceCategory);
        Assert.assertNotNull(serviceCategory);
    }

    @Test
    public void deleteCategory() {
        Category category = categoryService.deleteCategory("1122");
        System.out.println(category);
        Assert.assertNotNull(category);
    }

    @Test
    public void updateCategory() {
        Category category = new Category();
        category.setId("1122");
        category.setCategoryName("技术new");
        category.setCategoryType("11");
        Category serviceCategory = categoryService.updateCategory(category);
        System.out.println(serviceCategory);
        Assert.assertNotNull(serviceCategory);
    }

    @Test
    public void queryCategory() {
        Category category = categoryService.queryCategory("1122");
        System.out.println(category);
        Assert.assertNotNull(category);
    }

    @Test
    public void queryAllCategory() {
        List<Category> categoryList = categoryService.queryAllCategory();
        System.out.println(categoryList);
        Assert.assertEquals(categoryList.size() > 0, categoryList.size() > 0);
    }
}
