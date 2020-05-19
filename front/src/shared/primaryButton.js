import React from "react";
import { Button } from "react-bootstrap";

const PrimaryButton = (props) => {
  return (
    <Button
      className="btn btn-primary"
      type={props.isSubmit ? "submit" : "button"}
      onClick={props.onClick}
    >
      {props.text}
    </Button>
  );
};

export default PrimaryButton;
