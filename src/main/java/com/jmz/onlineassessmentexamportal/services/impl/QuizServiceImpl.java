package com.jmz.onlineassessmentexamportal.services.impl;

import com.jmz.onlineassessmentexamportal.entity.exam.Quiz;
import com.jmz.onlineassessmentexamportal.repo.QuizRepo;
import com.jmz.onlineassessmentexamportal.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepo quizRepo;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepo.saveAndFlush(quiz);
    }

    @Override
    public Set<Quiz> getQuizes() {
        return new HashSet<>(this.quizRepo.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepo.getById(quizId);
    }

    @Override
    public void deleteQuiz(Long quizId) {
        this.quizRepo.deleteQuizById(quizId);
    }
}
