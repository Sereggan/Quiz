package com.nikolaychuk.quizapp.service;

import com.nikolaychuk.quizapp.model.Quiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface QuizService extends CrudService<Quiz, Long>{
}
