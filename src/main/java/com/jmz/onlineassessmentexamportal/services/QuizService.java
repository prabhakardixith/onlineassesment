package com.jmz.onlineassessmentexamportal.services;

import com.jmz.onlineassessmentexamportal.entity.exam.Quiz;

import java.util.Set;

public interface QuizService
{
    Quiz addQuiz(Quiz quiz);

    Quiz updateQuiz(Quiz quiz);

    Set<Quiz> getQuizes();

    Quiz getQuiz(Long quizId);

    void deleteQuiz(Long quizId);
}
