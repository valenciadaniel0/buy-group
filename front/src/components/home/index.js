import React from "react";
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

class Home extends React.Component {
  translateLabels(key) {
    const translatedText = this.props.t(key);
    return translatedText;
  }

  render() {
    return (
      <Container>
        <Row className="justify-content-md-center">
          <Col xs lg="6">
            <TabContainer activeKey="home">
              <Tabs>
                <Tab eventKey="login" title={this.translateLabels("login")}>
                  <TabContent>Login</TabContent>
                </Tab>
                <Tab
                  eventKey="profile"
                  title={this.translateLabels("register")}
                >
                  <TabContent>Register</TabContent>
                </Tab>
              </Tabs>
            </TabContainer>
          </Col>
        </Row>
      </Container>
    );
  }
}

export default withTranslation("translations")(Home);
