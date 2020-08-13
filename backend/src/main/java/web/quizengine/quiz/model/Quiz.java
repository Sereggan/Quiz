package web.quizengine.quiz.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "quiz")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Quiz {
    @Id
    @Column
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column
    String title;

    public String getTitle() {
        return title;
    }

    @NotBlank
    @Column
    String text;

    @Column
    @Size(min = 2,max = 4)
    @ElementCollection
    private List<String> options;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column
    @Size(min=1, max=2)
    @ElementCollection
    private List<Integer> answer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quiz)) return false;
        Quiz quiz = (Quiz) o;
        return getTitle().equals(quiz.getTitle()) &&
                getText().equals(quiz.getText()) &&
                getOptions().equals(quiz.getOptions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getText(), getOptions());
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", options=" + options +
                ", answer=" + answer +
                '}';
    }
}
