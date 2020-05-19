import React from "react";
import { connect } from "react-redux";
import { compose } from "redux";
import { Row, Col } from "react-bootstrap";
import { withTranslation } from "react-i18next";
import { translate } from "../../core/translations";
import history from "../../core/history";
import DashboardItemCard from "../../shared/dashboardItemCard";

class Admin extends React.Component {
  listUsers() {
    history.push("/users");
  }

  renderContent() {
    return (
      <div className="main-container">
        <Row>
          <Col>
            <DashboardItemCard
              title={translate("users", this.props.t)}
              action={() => this.listUsers()}
            />
          </Col>
          <Col>
            <DashboardItemCard />
          </Col>
          <Col>
            <DashboardItemCard />
          </Col>
        </Row>
      </div>
    );
  }

  render() {
    return this.renderContent();
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
  connect(mapStateToProps, {})
)(Admin);
