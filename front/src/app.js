import React from "react";
import { connect } from "react-redux";
import { Router, Route, Switch } from "react-router-dom";
import Header from "./shared/header";
import history from "./core/history";
import Home from "./features/home";
import Admin from "./features/admin";
import Users from "./features/users";

class App extends React.Component {
  renderHeader() {
    return this.props.isSignedIn ? <Header /> : null;
  }

  render() {
    return (
      <React.Fragment>
        <Router history={history}>
          <React.Fragment>
            {this.renderHeader()}
            <div className="container-fluid">
              <Switch>
                <Route path="/" exact component={Home} />
                <Route path="/admin" exact component={Admin} />
                <Route path="/users" exact component={Users} />
              </Switch>
            </div>
          </React.Fragment>
        </Router>
      </React.Fragment>
    );
  }
}
const mapStateToProps = (state) => {
  return {
    isSignedIn: state.auth.isSignedIn,
    loggedUser: state.auth.loggedUser,
  };
};
export default connect(mapStateToProps, {})(App);
