package web.quizengine.quiz.model;


import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quiz")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Quiz {
    @Id
    @Column
    @GeneratedValue
    private Long id;
    @NotNull
    @Column
    String title;
    @NotNull
    @Column
    String text;

    @Column
    @NotNull
    @ElementCollection
    private List<String> options;

}
