package web.quizengine.quiz.model;

public class QuizSolution {
    private final boolean success ;
    private final String feedback;

    public QuizSolution(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public boolean isSuccess() {
        return success;
    }
}
