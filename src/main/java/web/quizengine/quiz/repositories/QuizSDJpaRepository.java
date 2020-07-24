package web.quizengine.quiz.repositories;

import org.springframework.data.repository.CrudRepository;
import web.quizengine.quiz.model.Quiz;

public interface QuizSDJpaRepository extends CrudRepository<Quiz, Long> {
}
