package com.ds.blog.service.impl;

import com.ds.blog.dao.CategoryDao;
import com.ds.blog.entity.Category;
import com.ds.blog.service.CategoryService;
import com.ds.blog.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category createCategory(Category category) {
        List<Category> categoryList = queryAllByCategoryTypeList(Arrays.asList(category.getCategoryType()));
        for (Category category1 : categoryList) {
            if (category1.getCategoryType().equals(category.getCategoryType())) {
                return null;
            }
        }
        category.setId(KeyUtil.genUniqueKey());
        return categoryDao.save(category);
    }

    @Override
    public Category deleteCategory(String categoryId) {
        Optional<Category> optionalCategory = categoryDao.findById(categoryId);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setIsDelete(1);
            return categoryDao.save(category);
        }
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Category queryCategory(String categoryId) {
        Optional<Category> optionalCategory = categoryDao.findById(categoryId);
        return optionalCategory.orElse(null);
    }

    @Override
    public List<Category> queryAllCategory() {
        return categoryDao.findAllByIsDeleteIsNot(1);
    }

    @Override
    public List<Category> queryAllByCategoryTypeList(List<String> categoryList) {
        return categoryDao.findAllByIsDeleteEqualsAndCategoryTypeIn(0, categoryList);
    }
}
