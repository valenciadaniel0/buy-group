import reducers from "./reducers";
import reduxThunk from "redux-thunk";
import { createStore, applyMiddleware, compose } from "redux";
import { persistReducer } from "redux-persist";
import localForage from "localforage";

let config = {
  key: 'root',
  storage: localForage,
  whitelist: ['auth']
};
let configureReducer = persistReducer(config, reducers);

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
const store = createStore(
  configureReducer,
  undefined,
  composeEnhancers(applyMiddleware(reduxThunk))
);

export default store;
