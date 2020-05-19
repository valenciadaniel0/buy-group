import React from "react";
import { Card } from "react-bootstrap";
import PrimaryButton from "./primaryButton";

class DashboardItemCard extends React.Component {
  render() {
    return (
      <Card>
        <Card.Body>
          <Card.Title>Card Title</Card.Title>          
          <Card.Text>
            Some quick example text to build on the card title and make up the
            bulk of the card's content.
          </Card.Text>
          <PrimaryButton text="Listar" onClick={this.props.action} />    
        </Card.Body>
      </Card>
    );
  }
}

export default DashboardItemCard;
