package com.nikolaychuk.quizapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="answer")
public class Answer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    private Integer answer;

    @ManyToOne
    @JoinColumn(name="quiz_id",nullable = false)
    private Quiz quiz;
}
