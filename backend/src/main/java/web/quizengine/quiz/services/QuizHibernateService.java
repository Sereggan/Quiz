package web.quizengine.quiz.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import web.quizengine.quiz.model.Quiz;
import web.quizengine.quiz.repositories.QuizHibernateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Profile("hibernate")
public class QuizHibernateService implements QuizService{


    final QuizHibernateRepository repository;

    public QuizHibernateService(QuizHibernateRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Quiz> findAll() {
        List<Quiz> quizList = new ArrayList<>();
        List<Quiz> list;
        list = repository.findAll();
        quizList.addAll(list);
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
