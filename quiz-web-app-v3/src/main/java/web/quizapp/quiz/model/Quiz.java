package web.quizapp.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty(message = "Answer can't be empty")
    @Column
    String answer;
}
