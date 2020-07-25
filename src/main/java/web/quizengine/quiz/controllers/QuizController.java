package web.quizengine.quiz.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.quizengine.quiz.model.Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    private List<Quiz> quizList = new ArrayList<>();

    public QuizController() {
       List<String> options = Arrays.asList("option1", "option 2");
        quizList.add(new Quiz(0L,"Test 1","Text 1",options));
    }

    @GetMapping
    public Quiz getQuiz() {
        return quizList.get(0);
    }

    @PostMapping
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
        
    }
}
