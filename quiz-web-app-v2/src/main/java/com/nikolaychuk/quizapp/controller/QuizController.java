package com.nikolaychuk.quizapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.nikolaychuk.quizapp.model.*;
import com.nikolaychuk.quizapp.service.QuizService;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/quizzes")
public class QuizController {

    final
    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public String getAllQuizzes(Model model) {
        model.addAttribute("quizzes",quizService.findAll());

        return "home";
    }

    @PostMapping(consumes = "application/json; charset=utf-8")
    public ResponseEntity<Object> addQuiz(@Valid @RequestBody Quiz quiz){
        return new ResponseEntity<>(quizService.save(quiz),HttpStatus.OK);
    }

    @PostMapping(value = "/solve/{id}", consumes = "application/json; charset=utf-8")
    public  ResponseEntity<Object>  solveQuizJson(@PathVariable Long id,@RequestBody Answer answer){
        Optional<Quiz> quiz = quizService.findById(id);

        if(!quiz.isPresent()) return new ResponseEntity<>("Could not find quiz", HttpStatus.NOT_FOUND);
        try {
            if(answer.getAnswer().equals(quiz.get().getAnswers())){
                return new ResponseEntity<>(new Feedback(true,"Congratulations, you're right!"),HttpStatus.OK);
            }else  return new ResponseEntity<>(new Feedback(false,"You are wrong, Try again!"),HttpStatus.OK);

        }catch (NullPointerException e){
            return new ResponseEntity<>("Answer can't be null)", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        Optional<Quiz> quiz = quizService.findById(id);
        if(!quiz.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        quizService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)  // Handling @Valid errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> hanleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}