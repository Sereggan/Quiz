package com.nikolaychuk.quizapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "quiz")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Quiz {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    String title;

    @NotBlank
    @Column
    String text;

//    private List<Integer> answer;
}
