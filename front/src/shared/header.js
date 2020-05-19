import React from "react";
import { compose } from "redux";
import { connect } from "react-redux";
import { signOut } from "../core/redux/actions";
import { Navbar, Nav, NavDropdown } from "react-bootstrap";
import { withTranslation } from "react-i18next";
import { translate } from "../core/translations";

class Header extends React.Component {
  logout() {
    this.props.signOut();
  }
  render() {
    return (
      <Navbar bg="light" expand="lg">
        <Navbar.Brand href="#home">Trup</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="mr-auto">
            <Nav.Link href="#home">Home</Nav.Link>
            <Nav.Link href="#link">Link</Nav.Link>
            <NavDropdown title="Dropdown" id="basic-nav-dropdown">
              <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.2">
                Another action
              </NavDropdown.Item>
              <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.4">
                Separated link
              </NavDropdown.Item>
            </NavDropdown>
          </Nav>
          <Nav>
            <Nav.Link href="#deets">{this.props.loggedUser.userName}</Nav.Link>
            <Nav.Link eventKey={2} onClick={() => this.logout()}>
              {translate("logout", this.props.t)}
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    isSignedIn: state.auth.isSignedIn,
    loggedUser: state.auth.loggedUser,
  };
};

export default compose(
  withTranslation("translations"),
  connect(mapStateToProps,{signOut})
)(Header);
