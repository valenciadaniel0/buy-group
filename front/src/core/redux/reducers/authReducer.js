import { SIGN_IN } from "../actions/types";
import { SIGN_OUT } from "../actions/types";

const INITIAL_STATE = {
  isSignedIn: null,
};

export default (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case SIGN_IN:
      return { ...state, isSignedIn: true, loggedUser: action.payload };
    case SIGN_OUT:
      return { ...state, isSignedIn: false, loggedUser: null };

    default:
      return state;
  }
};
