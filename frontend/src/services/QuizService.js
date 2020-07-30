import axios from "axios";

const QUIZZES_API_BASE_URL = "http://localhost:8080/api/quizzes";

class QuizService {
  getQuizzes() {
    return axios.get(QUIZZES_API_BASE_URL);
  }
}

export default new QuizService();
