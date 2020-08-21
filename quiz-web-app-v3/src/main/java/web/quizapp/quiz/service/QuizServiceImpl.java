package web.quizapp.quiz.service;

import web.quizapp.quiz.model.Quiz;
import web.quizapp.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService{

    final QuizRepository repository;

    public QuizServiceImpl(QuizRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Quiz> findAll() {  //for Spring data Jpa
        List<Quiz> quizList = new ArrayList<>();
        repository.findAll().forEach(quizList::add);
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
