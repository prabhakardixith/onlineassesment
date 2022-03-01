package com.jmz.onlineassessmentexamportal.repo;

import com.jmz.onlineassessmentexamportal.entity.exam.Question;
import com.jmz.onlineassessmentexamportal.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Set;

public interface QuestionRepo extends JpaRepository<Question,Long> {

    @Transactional
    @Modifying
    @Query("delete from Question q where q.quesId=?1")
    void deleteQuestionById(Long questionId);


    Set<Question> findByQuiz(Quiz quiz);
}
