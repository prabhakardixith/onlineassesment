package com.jmz.onlineassessmentexamportal.controller;

import com.jmz.onlineassessmentexamportal.entity.exam.Question;
import com.jmz.onlineassessmentexamportal.entity.exam.Quiz;
import com.jmz.onlineassessmentexamportal.services.QuestionService;
import com.jmz.onlineassessmentexamportal.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //add question
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody Question question)
    {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //update question
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Question question)
    {
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    //get all question of any quiz
    @GetMapping("/{quiz}/qid")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid)
    {
//        Quiz quiz = new Quiz();
//        quiz.setQid(qid);
//        return ResponseEntity.ok(this.questionService.getQuestionsOfQuiz(quiz));

        Quiz quiz = quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList(questions);
        if(list.size() > Integer.parseInt(quiz.getNumberOfQuestions()))
        {
            list = list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    //get single question
    @GetMapping("/{qid}")
    public ResponseEntity<?> get(@PathVariable("qid") Long qid)
    {
        return ResponseEntity.ok(this.questionService.getQuestion(qid));
    }

    //delete question
    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid") Long qid)
    {
        this.questionService.deleteQuestions(qid);
    }

    //get all questions
    @GetMapping("/")
    public ResponseEntity<?> questions()
    {
        return ResponseEntity.ok(this.questionService.getQuestions());
    }
}
