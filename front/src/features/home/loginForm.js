import React from "react";
import { compose } from "redux";
import { Field, reduxForm } from "redux-form";
import { Form, FormGroup } from "react-bootstrap";
import PrimaryButton from "../../shared/primaryButton";
import { withTranslation } from "react-i18next";
import { translate } from "../../core/translations";

class LoginForm extends React.Component {
  renderError({ error, touched }) {
    if (touched && error) {
      return (
        <div className="ui error message">
          <div className="header">{error}</div>
        </div>
      );
    }
  }
  renderInput = ({ input, label, meta }) => {
    const className = `field ${meta.touched && meta.error ? "error" : ""}`;
    return (
      <div className="form-group">
        <label htmlFor={input.name}>{label}</label>
        <input
          {...input}
          autoComplete="off"
          id={input.name}
          className="form-control"
          type={"password" === input.name ? "password" : "text"}
        />
        {this.renderError(meta)}
      </div>
    );
  };

  onSubmit = (formValues) => {
    this.props.onSubmit(formValues);
  };

  render() {
    return (
      <Form
        onSubmit={this.props.handleSubmit(this.onSubmit)}
        className="ui form error"
      >
        <FormGroup className="form-group">
          <Field
            name="email"
            type="email"
            id="email"
            component={this.renderInput}
            label={translate("enter_email", this.props.t)}
          />
        </FormGroup>
        <FormGroup className="form-group">
          <Field
            name="password"
            type="password"
            component={this.renderInput}
            label={translate("enter_password", this.props.t)}
          />
        </FormGroup>
        <PrimaryButton text={translate("login", this.props.t)} submit={true} />
      </Form>
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
    form: "loginForm",
    validate,
  })
)(LoginForm);
