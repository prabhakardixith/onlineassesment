package com.jmz.onlineassessmentexamportal.services;

import com.jmz.onlineassessmentexamportal.entity.exam.Category;

import java.util.Set;

public interface CategoryService
{
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Set<Category> getCategories();
    public Category getCategory(Long categoryId);
    public void deleteCategory(Long categoryId);


}
