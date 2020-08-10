package com.nikolaychuk.quizapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
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
    String description;

    @NotBlank
    @Column
    String text;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    @Column
    @Size(min = 2,max = 4)
    @ElementCollection
    private List<String> options;
}
