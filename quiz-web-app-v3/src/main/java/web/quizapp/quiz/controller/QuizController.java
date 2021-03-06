package web.quizapp.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    @Qualifier("H2Database")
    QuizService quizService;

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
        quiz.setAnswer(quiz.getAnswer().toLowerCase());
        quizService.save(quiz);
        return "redirect:";
    }

    @GetMapping("/solve-quiz-page/{id}")
    public String showSolveQuizPage(@PathVariable("id") long id, Model model) {
        Quiz quiz = quizService.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid quiz Id:" + id));
        model.addAttribute("quiz", quiz);
        model.addAttribute("wrongAnswer",false);
        return "solve-quiz";
    }

    @PostMapping("solve/{id}")
    public String updateStudent(@PathVariable("id") long id,
                                Model model, @RequestParam(value = "answer",required = false) String answer) {
        String correctAnswer = quizService.findById(id).get().getAnswer();
        if(Objects.equals(correctAnswer,answer.toLowerCase())){
            return "right-answer";
        }
        model.addAttribute("quiz", quizService.findById(id).get());
        model.addAttribute("wrongAnswer",true);
        return "solve-quiz";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Quiz quiz = quizService.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid quiz Id:" + id));
        quizService.delete(quiz);
        model.addAttribute("quizzes", quizService.findAll());
        return "index";
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