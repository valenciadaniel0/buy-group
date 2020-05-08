import React from "react";
import { Button } from "react-bootstrap";

const PrimaryButton = (props) => {
  return (
    <Button className="btn btn-primary" onClick={() => this.props.onClick}>
      {props.text}
    </Button>
  );
};

export default PrimaryButton;
