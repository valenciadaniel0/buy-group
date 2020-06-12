import React from "react";

class PasswordField extends React.Component {
  renderError({ error, touched }) {
    if (touched && error) {
      return (
        <div className="ui error message">
          <div className="header">{error}</div>
        </div>
      );
    }
  }
  
  render() {
    const { input, label, meta } = this.props;
    const className = `field ${meta.touched && meta.error ? "error" : ""}`;
    return (
      <div className="form-group">
        <label htmlFor={input.name}>{label}</label>
        <input
          {...input}
          autoComplete="off"
          id={input.name}
          className="form-control"
          type="password"
        />
        {this.renderError(meta)}
      </div>
    );
  }
}

export default PasswordField;
