package com.ds.blog.service;

import com.ds.blog.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    Category deleteCategory(String categoryId);

    Category updateCategory(Category category);

    Category queryCategory(String categoryId);

    List<Category> queryAllCategory();

    List<Category> queryAllByCategoryTypeList(List<String> categoryList);
}
