package web.quizengine.quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quizengine.quiz.model.Quiz;
import web.quizengine.quiz.repositories.QuizSDJpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService{

    final
    QuizSDJpaRepository quizSDJpaRepository;

    public QuizServiceImpl(QuizSDJpaRepository quizSDJpaRepository) {
        this.quizSDJpaRepository = quizSDJpaRepository;
    }

    @Override
    public List<Quiz> findAll() {
        List<Quiz> quizList = new ArrayList<>();
        quizSDJpaRepository.findAll().forEach(quizList::add);
        return quizList;
    }

    @Override
    public Optional<Quiz> findById(Long aLong) {
        return quizSDJpaRepository.findById(aLong);
    }

    @Override
    public Quiz save(Quiz object) {
        return quizSDJpaRepository.save(object);
    }


    @Override
    public void delete(Quiz object) {
        quizSDJpaRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        quizSDJpaRepository.deleteById(aLong);
    }
}
