package com.jmz.onlineassessmentexamportal.services;

import com.jmz.onlineassessmentexamportal.entity.exam.Question;
import com.jmz.onlineassessmentexamportal.entity.exam.Quiz;

import java.util.Set;

public interface QuestionService
{
    Question addQuestion(Question question);
    Question updateQuestion(Question question);
    Set<Question> getQuestions();
    Question getQuestion(Long questionId);
    void deleteQuestions(Long questionId);
    Set<Question> getQuestionsOfQuiz(Quiz quiz);

}
