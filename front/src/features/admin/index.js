import React from "react";
import { connect } from "react-redux";

class Admin extends React.Component {
  renderContent() {
    if (this.props.isSignedIn) {
      return <div>{this.props.loggedUser.name}</div>;
    }
    return <div>We are not signed in</div>;
  }

  render() {
    return this.renderContent();
  }
}

const mapStateToProps = (state) => {
  return {
    isSignedIn: state.auth.isSignedIn,
    loggedUser: state.auth.loggedUser,
  };
};

export default connect(mapStateToProps, {})(Admin);
