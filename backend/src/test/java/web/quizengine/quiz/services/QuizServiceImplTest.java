package web.quizengine.quiz.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import web.quizengine.quiz.model.Quiz;
import web.quizengine.quiz.repositories.QuizSDJpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class QuizServiceImplTest {

    @Mock
    QuizSDJpaRepository repository;

    @InjectMocks
    QuizService service;


    @Test
    void findAll() {
        List options = Arrays.asList("opt1","opt2");
        List quizList = Arrays.asList(new Quiz(1L,"title1","text1",options,Arrays.asList(1,2)));
        when(repository.findAll()).thenReturn(quizList);
        assertEquals(1,service.findAll().size());

    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}