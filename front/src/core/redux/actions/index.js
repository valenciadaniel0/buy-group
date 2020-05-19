import group from "../../apis/group";
import history from "../../history";
import { SIGN_IN } from "./types";
import { SIGN_OUT } from "./types";

export const signOut = () => {
  return {
    type: SIGN_OUT,
  };
};

export const signIn = (formValues) => async (dispatch) => {
  const response = await group.post("/api/users/authenticate", {
    ...formValues,
  });
  console.log(formValues);
  dispatch({
    type: SIGN_IN,
    payload: response.data,
  });
  history.push("/admin");
};
