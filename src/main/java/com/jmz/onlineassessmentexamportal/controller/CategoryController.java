package com.jmz.onlineassessmentexamportal.controller;

import com.jmz.onlineassessmentexamportal.entity.exam.Category;
import com.jmz.onlineassessmentexamportal.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/category")
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;

    //add category
    @PostMapping("/")
    ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1) ;
    }

    ///get category
    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getCategory(@PathVariable("categoryId") Long categoryId)
    {
        Category category = this.categoryService.getCategory(categoryId);
        if(category != null)
        {
          return ResponseEntity.ok(category);
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//       return this.categoryService.getCategory(categoryId);
    }

    //get all categories
    @GetMapping("/")
    public ResponseEntity<Set<Category>> getCategories()
    {
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    //update category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category)
    {
        return this.categoryService.updateCategory(category);
    }

    //delete category
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId)
    {
        this.categoryService.deleteCategory(categoryId);
    }

}
