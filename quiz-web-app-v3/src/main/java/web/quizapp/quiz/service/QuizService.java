package web.quizapp.quiz.service;

import web.quizapp.quiz.model.Quiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface QuizService extends CrudService<Quiz, Long>{
}
