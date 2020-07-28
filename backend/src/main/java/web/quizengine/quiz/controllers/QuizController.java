package web.quizengine.quiz.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import web.quizengine.quiz.model.Quiz;
import web.quizengine.quiz.services.QuizService;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    final
    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    @GetMapping
    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizzes = new ArrayList<>(quizService.findAll());
         return quizzes;
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getQuizById(@PathVariable Long id){
        Optional<Quiz> quiz = quizService.findById(id);
        return quiz.<ResponseEntity<Object>>map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("Could not find quiz", HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Object> addQuiz(@Valid @RequestBody Quiz quiz){
        return new ResponseEntity<>(quizService.save(quiz),HttpStatus.OK);
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
    public Map<String, String> handleValidationExceptions(
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
