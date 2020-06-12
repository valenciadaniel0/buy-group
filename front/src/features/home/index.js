import React from "react";
import { compose } from "redux";
import { connect } from "react-redux";
import { signIn } from "../../core/redux/actions";
import { Container, Row, Col } from "react-bootstrap";
import { withTranslation } from "react-i18next";
import LoginForm from "./loginForm";
import RegisterForm from "./registerForm";
import RecoverPasswordForm from "./recoverPasswordForm";

class Home extends React.Component {
  state = { formType: "login" };

  renderFormType() {
    if (this.state.formType === "login") {
      return (
        <LoginForm
          onSubmit={this.onSubmit}
          changeFormType={this.showFormType}
        />
      );
    } else if (this.state.formType === "register") {
      return (
        <RegisterForm
          onSubmit={this.onSubmit}
          changeFormType={this.showFormType}
        />
      );
    }

    return <RecoverPasswordForm />;
  }

  onSubmit = (formValues) => {
    this.props.signIn(formValues);
  };

  showFormType = (formType) => {
    this.setState({ formType: formType });
    console.log(this.state.formType);
  };

  render() {
    return (
      <Container>
        <Row className="justify-content-md-center">
          <Col xs lg="4">
            {this.renderFormType()}
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
