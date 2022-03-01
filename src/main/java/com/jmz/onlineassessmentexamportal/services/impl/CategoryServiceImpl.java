package com.jmz.onlineassessmentexamportal.services.impl;

import com.jmz.onlineassessmentexamportal.entity.exam.Category;
import com.jmz.onlineassessmentexamportal.repo.CategoryRepo;
import com.jmz.onlineassessmentexamportal.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    @Transactional
    public Category addCategory(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    @Transactional
    public Category updateCategory(Category category) {
        return this.categoryRepo.saveAndFlush(category);
    }

    @Override
    @Transactional
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepo.findAll());
    }

    @Override
    @Transactional
    public Category getCategory(Long categoryId) {

        return this.categoryRepo.findById(categoryId).orElse(null);
    }

    @Override
    @Transactional
    public void deleteCategory(Long categoryId) {
        this.categoryRepo.deleteCategoriesById(categoryId);
    }

}
