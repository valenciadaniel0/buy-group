import React from "react";
import { compose } from "redux";
import { Form, FormGroup, Row, Col } from "react-bootstrap";
import { Field, reduxForm } from "redux-form";
import PrimaryButton from "../../shared/primaryButton";
import { withTranslation } from "react-i18next";
import { translate } from "../../core/translations";
import TextField from "../../shared/inputs/textField";
import PasswordField from "../../shared/inputs/passwordField";

class RegisterForm extends React.Component {

  onSubmit = (formValues) => {
    //this.props.onSubmit(formValues);
  };

  render() {
    return (
      <React.Fragment>
        <Form
          onSubmit={this.props.onSubmit(this.onSubmit)}
          className="ui form error"
        >
          <FormGroup className="form-group">
            <Field
              name="email"
              type="email"
              id="email"
              component={TextField}
              label={translate("enter_email", this.props.t)}
            />
          </FormGroup>
          <FormGroup className="form-group">
            <Field
              name="password"
              type="password"
              component={PasswordField}
              label={translate("enter_password", this.props.t)}
            />
          </FormGroup>
          <PrimaryButton
            text={translate("login", this.props.t)}
            isSubmit={true}
          />
        </Form>
        <Row>
          <Col>
            <a onClick={() => this.props.changeFormType("login")}>
              {translate("cancel", this.props.t)}
            </a>
          </Col>
        </Row>
      </React.Fragment>
    );
  }
}

const validate = (formValues) => {
  const errors = {};
  if (!formValues.email) {
    errors.email = "You must enter an email";
  }

  if (!formValues.password) {
    errors.password = "You must enter a password";
  }

  return errors;
};

export default compose(
    withTranslation("translations"),
    reduxForm({
      form: "registerForm",
      validate,
    })
  )(RegisterForm);
