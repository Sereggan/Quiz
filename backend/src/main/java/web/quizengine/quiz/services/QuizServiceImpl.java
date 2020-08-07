package web.quizengine.quiz.services;

import org.springframework.stereotype.Service;
import web.quizengine.quiz.model.Quiz;
import web.quizengine.quiz.repositories.QuizHibernateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService{

    // Если хотите Spring data Jpa
//    final
//    QuizSDJpaRepository repository;
//
//    public QuizServiceImpl(QuizSDJpaRepository quizSDJpaRepository) {
//        this.repository = quizSDJpaRepository;
//    }

    final QuizHibernateRepository repository;

    public QuizServiceImpl(QuizHibernateRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Quiz> findAll() {
        List<Quiz> quizList = new ArrayList<>();
        List<Quiz> list = new ArrayList<>();
        list = repository.findAll();
        list.forEach(quizList::add);
        return quizList;
    }

    @Override
    public Optional<Quiz> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public Quiz save(Quiz object) {
        return repository.save(object);
    }

    @Override
    public void delete(Quiz object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
