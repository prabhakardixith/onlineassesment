package com.jmz.onlineassessmentexamportal.services.impl;

import com.jmz.onlineassessmentexamportal.entity.exam.Question;
import com.jmz.onlineassessmentexamportal.entity.exam.Quiz;
import com.jmz.onlineassessmentexamportal.repo.QuestionRepo;
import com.jmz.onlineassessmentexamportal.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepo.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepo.saveAndFlush(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepo.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepo.findById(questionId).get();
    }

    @Override
    public void deleteQuestions(Long questionId) {
        this.questionRepo.deleteQuestionById(questionId);
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return this.questionRepo.findByQuiz(quiz);
    }
}
