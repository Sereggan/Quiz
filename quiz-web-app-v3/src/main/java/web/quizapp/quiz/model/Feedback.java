package web.quizapp.quiz.model;

public class Feedback {
    private final boolean success ;
    private final String feedback;

    public Feedback(boolean success, String feedback) {
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