import React from "react";

import {
  BrowserRouter as Router,
  Route,
  Switch,
  Redirect,
} from "react-router-dom";
import "./App.css";
import ListQuizzesComponent from "./components/ListQuizzesComponent";
import CreateQuiz from "./components/CreateQuiz";
import SolveQuizComponents from "./components/SolveQuizComponents";

function App() {
  return (
    <Router>
      <div className="container">
        <Switch>
          <Route path="/" exact component={ListQuizzesComponent} />
          <Route path="/quizzes" component={ListQuizzesComponent} />
          <Route path="/add-quiz" component={CreateQuiz} />
          <Route path="/solve-quiz/:id" component={SolveQuizComponents} />
          <Redirect to="/" />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
