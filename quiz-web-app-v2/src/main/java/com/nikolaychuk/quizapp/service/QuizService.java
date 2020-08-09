package com.nikolaychuk.quizapp.service;

import com.nikolaychuk.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuizService {

    final
    QuizRepository repository;

    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }
}
