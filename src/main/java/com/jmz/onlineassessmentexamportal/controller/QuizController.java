package com.jmz.onlineassessmentexamportal.controller;


import com.jmz.onlineassessmentexamportal.entity.exam.Quiz;
import com.jmz.onlineassessmentexamportal.repo.QuizRepo;
import com.jmz.onlineassessmentexamportal.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    //add quiz service
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(quizService.addQuiz(quiz));
    }

    //update quiz
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get quizes
    @GetMapping("/")
    public ResponseEntity<?> quizzes()
    {
        return ResponseEntity.ok(this.quizService.getQuizes());
    }

    //get single quizz
    @GetMapping("/{quizId}")
    public ResponseEntity<?> quiz(@PathVariable("quizId") Long quizId)
    {
        return ResponseEntity.ok(this.quizService.getQuiz(quizId));
    }

    //delete quiz
    @DeleteMapping("/{quizId}")
    public void delete(@PathVariable("quizId") Long quizId)
    {
        this.quizService.deleteQuiz(quizId);
    }
    
}
