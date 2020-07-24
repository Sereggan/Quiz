package web.quizengine.quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import web.quizengine.quiz.model.Quiz;
import web.quizengine.quiz.repositories.QuizSDJpaRepository;

import java.util.Set;

public class QuizServiceImpl implements QuizService{

    @Autowired
    QuizSDJpaRepository quizSDJpaRepository;

    @Override
    public Set<Quiz> findAll() {
        return null;
    }

    @Override
    public Quiz findById(Long aLong) {
        return null;
    }

    @Override
    public Quiz save(Quiz object) {
        return null;
    }

    @Override
    public void delete(Quiz object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
