import group from "../../apis/group";
import history from "../../history";
import { SIGN_IN } from "./types";
import { SIGN_OUT } from "./types";

export const signOut = () => async (dispatch) => {
  const response = await group.get("/api/users/logout", {});
  localStorage.removeItem("state");
  dispatch({
    type: SIGN_OUT,
    payload: response,
  });
  history.push("/");
};

export const signIn = (formValues) => async (dispatch) => {
  const response = await group.post("/api/users/authenticate", {
    ...formValues,
  });
  dispatch({
    type: SIGN_IN,
    payload: response.data,
  });
  history.push("/admin");
};
