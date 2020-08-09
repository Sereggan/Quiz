package com.nikolaychuk.quizapp.repository;

import com.nikolaychuk.quizapp.model.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
