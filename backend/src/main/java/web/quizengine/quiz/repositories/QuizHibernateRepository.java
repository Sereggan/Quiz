package web.quizengine.quiz.repositories;

import org.springframework.stereotype.Repository;
import web.quizengine.quiz.model.Quiz;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository("hibernateRepository")
public class QuizHibernateRepository {

    @PersistenceContext
    EntityManager em;

    public List findAll(){
        return em.createQuery("SELECT quiz from Quiz quiz")
                .getResultList();
    }

    public Optional<Quiz> findById(Long id){
        Optional<Quiz> quiz =  Optional.of(em.find(Quiz.class,id));
        return quiz;
    }

    public Quiz save(Quiz quiz){
         em.persist(quiz);
         return quiz;
    }


    public void delete(Quiz quiz){
        em.remove(quiz);
    }

    public void deleteById(Long id){
        Quiz quiz = em.find(Quiz.class,id);
        em.remove(quiz);
    }
}
