package web.quizengine.quiz.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import web.quizengine.quiz.services.QuizSDJpaService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class QuizControllerTest {

    @Mock
    QuizSDJpaService service;

    @InjectMocks
    QuizController controller;
    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllQuizzes() {
    }

    @Test
    void getQuizById() {
    }

    @Test
    void addQuiz() {
    }

    @Test
    void solveQuiz() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void hanleValidationExceptions() {
    }
}