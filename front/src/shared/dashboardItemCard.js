import React from "react";
import { Card } from "react-bootstrap";
import PrimaryButton from "./primaryButton";

class DashboardItemCard extends React.Component {
  render() {
    return (
      <Card>
        <Card.Body>
          <Card.Title>{this.props.title}</Card.Title>
          <Card.Text>
            {this.props.text}
          </Card.Text>
          <PrimaryButton text="Listar" onClick={this.props.action} />
        </Card.Body>
      </Card>
    );
  }
}

export default DashboardItemCard;
