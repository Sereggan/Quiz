package com.nikolaychuk.quizapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Title can't be empty")
    @Column(name = "title")
    String title;

    @NotEmpty(message = "Description can't be empty")
    @Column
    String description;

    @NotEmpty(message = "Answer can't be empty")
    @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    @NotEmpty(message = "Options can't be empty")
    @Column
    @Size(min = 2,max = 4)
    @ElementCollection
    private List<String> options;
}
