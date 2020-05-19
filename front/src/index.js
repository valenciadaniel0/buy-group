import "bootstrap/dist/css/bootstrap.min.css";
import "./main.scss";
import React from "react";
import ReactDOM from "react-dom";
import store from "./core/redux/store";
import { Provider } from "react-redux";
import { I18nextProvider } from "react-i18next";
import i18n from "./core/translations/i18n";
import App from "./app";

ReactDOM.render(
  <Provider store={store}>
    <I18nextProvider i18n={i18n}>
      <App />
    </I18nextProvider>
  </Provider>,
  document.querySelector("#root")
);
