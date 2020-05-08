import React from "react";
import { compose } from 'redux';
import { connect } from "react-redux";
import { signIn } from "../../core/redux/actions";
import {
  Container,
  Row,
  Col,
  TabContainer,
  Tab,
  Tabs,
  TabContent,
} from "react-bootstrap";
import { withTranslation } from "react-i18next";
import {translate} from '../../core/translations';
import LoginForm from "./loginForm";

class Home extends React.Component {  
  onSubmit = (formValues) => {
    this.props.signIn(formValues);
  };

  render() {
    return (
      <Container>
        <Row className="justify-content-md-center">
          <Col xs lg="6">
            <TabContainer activeKey="home">
              <Tabs>
                <Tab eventKey="login" title={translate("login",this.props.t)}>
                  <TabContent>
                    <LoginForm onSubmit={this.onSubmit} />
                  </TabContent>
                </Tab>
              </Tabs>
            </TabContainer>
          </Col>
        </Row>
      </Container>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    token: state.payload,
  };
};

export default compose(
  withTranslation("translations"),
  connect(mapStateToProps, { signIn })
)(Home);
