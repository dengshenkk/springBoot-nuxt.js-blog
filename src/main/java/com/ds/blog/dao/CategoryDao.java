package com.ds.blog.dao;

import com.ds.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, String> {
    List<Category> findAllByIsDeleteIsNot(Integer isDelete);

    List<Category> findAllByIsDeleteEqualsAndCategoryTypeIn(Integer isDelete, List<String> categoryList);
}
