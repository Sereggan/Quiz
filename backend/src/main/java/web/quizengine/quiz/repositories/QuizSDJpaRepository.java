package web.quizengine.quiz.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import web.quizengine.quiz.model.Quiz;

@Qualifier("springData")
@Repository
public interface QuizSDJpaRepository extends PagingAndSortingRepository<Quiz, Long> {
}
