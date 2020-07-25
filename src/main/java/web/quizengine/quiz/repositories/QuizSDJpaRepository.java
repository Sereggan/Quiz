package web.quizengine.quiz.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.quizengine.quiz.model.Quiz;

@Qualifier("springData")
@Repository
public interface QuizSDJpaRepository extends CrudRepository<Quiz, Long> {
}
