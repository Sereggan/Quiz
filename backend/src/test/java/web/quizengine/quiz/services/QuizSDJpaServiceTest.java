package web.quizengine.quiz.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import web.quizengine.quiz.model.Quiz;
import web.quizengine.quiz.repositories.QuizSDJpaRepository;

import javax.swing.text.html.Option;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuizSDJpaServiceTest {

    @Mock
    QuizSDJpaRepository repository;

    @InjectMocks
    QuizSDJpaService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        List<Quiz> quizzes = new ArrayList<>();
        quizzes.add(Quiz.builder().id(1L).title("test quiz1").answer(Arrays.asList(0,1)).options(Arrays.asList("opt1","opt2")).text("text1").build());
        quizzes.add(Quiz.builder().id(2L).title("test quiz2").answer(Arrays.asList(0,1)).options(Arrays.asList("opt3","opt4")).text("text2").build());
        when(repository.findAll()).thenReturn(quizzes);
        List<Quiz> quizList = service.findAll();
        assertNotNull(quizList);
        assertEquals(2,quizList.size());
    }

    @Test
    void findById() {
//        Optional<Quiz> newQuiz = Optional.of(Quiz.builder().id(1L).title("test quiz").answer(Arrays.asList(0,1)).options(Arrays.asList("opt1","opt2")).text("text").build());
//        when(repository.findById(1L)).thenReturn(newQuiz);
//        Optional quiz = service.findById(1L);
//        assertEquals("test quiz", );
    }

    @Test
    void findByIdNotFound(){
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        Optional<Quiz> quiz = service.findById(1L);

        assertFalse(quiz.isPresent());
    }

    @Test
    void save() {
        Quiz quiz = Quiz.builder().id(1L).title("test quiz").answer(Arrays.asList(0,1)).options(Arrays.asList("opt1","opt2")).text("text").build();
        when(repository.save(any())).thenReturn(quiz);
        Quiz savedQuiz = service.save(quiz);
        assertNotNull(savedQuiz);

    }

    @Test
    void delete() {
        Quiz quiz = Quiz.builder().id(1L).title("test quiz").answer(Arrays.asList(0,1)).options(Arrays.asList("opt1","opt2")).text("text").build();
        service.delete(quiz);
        verify(repository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(repository).deleteById(anyLong());
    }
}