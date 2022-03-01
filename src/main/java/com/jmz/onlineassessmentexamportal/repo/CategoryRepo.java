package com.jmz.onlineassessmentexamportal.repo;

import com.jmz.onlineassessmentexamportal.entity.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface CategoryRepo extends JpaRepository<Category,Long> {

    @Modifying
    @Query("Delete from Category c where c.cid =?1")
    void deleteCategoriesById(Long categoryId);
}
