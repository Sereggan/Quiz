package web.quizapp.quiz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import web.quizapp.quiz.model.Quiz;
import web.quizapp.quiz.service.QuizService;

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
    public String showQuizList(Model model) {
        model.addAttribute("quizzes",quizService.findAll());
        return "index";
    }

    @GetMapping("/add-quiz-page")
    public String showAddQuizPage(Quiz quiz){
        return "add-quiz";
    }

    @PostMapping("/add")
    public String addQuiz(@Valid Quiz quiz, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-quiz";
        }

        quizService.save(quiz);
        return "redirect:";
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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping("/404")
    public String handleResourceNotFoundException() {
        return "error/notfound";
    }

}