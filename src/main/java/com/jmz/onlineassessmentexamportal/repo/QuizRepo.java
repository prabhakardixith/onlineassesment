package com.jmz.onlineassessmentexamportal.repo;

import com.jmz.onlineassessmentexamportal.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface QuizRepo extends JpaRepository<Quiz,Long>
{
    @Modifying
    @Transactional
    @Query("Delete from Quiz z where z.qid =?1")
    void deleteQuizById(Long QuizId);
}
