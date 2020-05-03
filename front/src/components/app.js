import React from "react";
import { Router, Route } from "react-router-dom";
import history from "../history";
import Home from "./home";

class App extends React.Component {  
  render() {
    return (
      <div className="container-fluid">
        <Router history={history}>
          <React.Fragment>
            <Route path="/" exact component={Home} />
          </React.Fragment>
        </Router>
      </div>
    );
  }
}

export default App;
