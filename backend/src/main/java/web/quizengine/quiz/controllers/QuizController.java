package web.quizengine.quiz.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import web.quizengine.quiz.model.Answer;
import web.quizengine.quiz.model.Feedback;
import web.quizengine.quiz.model.Quiz;
import web.quizengine.quiz.services.QuizService;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
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

    @PostMapping(consumes = "application/json; charset=utf-8")
    public ResponseEntity<Object> addQuiz(@Valid @RequestBody Quiz quiz){
        return new ResponseEntity<>(quizService.save(quiz),HttpStatus.OK);
    }

    @PostMapping(value = "/solve/{id}", consumes = "application/json; charset=utf-8")
    public  ResponseEntity<Object>  solveQuiz(@PathVariable Long id,@Valid @RequestBody Answer answer){
        Optional<Quiz> quiz = quizService.findById(id);

        if(!quiz.isPresent()) return new ResponseEntity<>("Could not find quiz", HttpStatus.NOT_FOUND);
        try {
            if(answer.getAnswer().equals(quiz.get().getAnswer())){
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
