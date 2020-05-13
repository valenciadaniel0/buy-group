import React from "react";
import { compose } from "redux";
import { connect } from "react-redux";
import { signIn } from "../../core/redux/actions";
import { Container, Row, Col } from "react-bootstrap";
import { withTranslation } from "react-i18next";
import LoginForm from "./loginForm";

class Home extends React.Component {
  onSubmit = (formValues) => {
    this.props.signIn(formValues);
  };

  render() {
    return (
      <Container>
        <Row className="justify-content-md-center">
          <Col xs lg="4">
            <LoginForm onSubmit={this.onSubmit} />
          </Col>
        </Row>
      </Container>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    token: state.payload,
  };
};

export default compose(
  withTranslation("translations"),
  connect(mapStateToProps, { signIn })
)(Home);
