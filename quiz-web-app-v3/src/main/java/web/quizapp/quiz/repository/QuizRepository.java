package web.quizapp.quiz.repository;

import web.quizapp.quiz.model.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
