import React from "react";

import { BrowsRouter as Router, Route, Switch } from "react-router-dom";
import "./App.css";
import ListQuizzesComponent from "./components/ListQuizzesComponent";
import CreateQuiz from "./components/CreateQuiz";

function App() {
  return (
    <Router>
      <div className="container">
        <Switch>
          <Route exact path="/" component={ListQuizzesComponent} />
          <Route path="/quizzes" component={ListQuizzesComponent} />
          <Route path="/add-quiz" component={CreateQuiz} />
          <Redirect to="/" />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
