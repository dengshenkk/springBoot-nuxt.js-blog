package com.ds.blog.service;

import com.ds.blog.entity.Category;

import java.util.List;

public interface CategoryService {
    public Category createCategory(Category category);

    public Category deleteCategory(String categoryId);

    public Category updateCategory(Category category);

    public Category queryCategory(String categoryId);

    public List<Category> queryAllCategory();
}
