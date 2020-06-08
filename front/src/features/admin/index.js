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

  listCompanies() {
    history.push("/companies");
  }

  listRoles() {
    history.push("/roles");
  }

  listCities() {
    history.push("/cities");
  }

  listDepartments() {
    history.push("/departments");
  }

  renderContent() {
    return (
      <div className="main-container">
        <Row>
          <Col>
            <DashboardItemCard
              title={translate("users", this.props.t)}
              text={translate("long_texts.users_card", this.props.t)}
              action={() => this.listUsers()}
            />
          </Col>
          <Col>
            <DashboardItemCard
              title={translate("companies", this.props.t)}
              text={translate("long_texts.companies_card", this.props.t)}
              action={() => this.listCompanies()}
            />
          </Col>
          <Col>
            <DashboardItemCard
              title={translate("roles", this.props.t)}
              text={translate("long_texts.roles_card", this.props.t)}
              action={() => this.listRoles()}
            />
          </Col>
        </Row>
        <br/>
        <Row>
          <Col>
            <DashboardItemCard
              title={translate("cities", this.props.t)}
              text={translate("long_texts.cities_card", this.props.t)}
              action={() => this.listCities()}
            />
          </Col>
          <Col>
            <DashboardItemCard
              title={translate("departments", this.props.t)}
              text={translate("long_texts.departments_card", this.props.t)}
              action={() => this.listDepartments()}
            />
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
