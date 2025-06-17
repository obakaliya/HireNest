import { useSelector } from "react-redux";
import { RootState } from "../app/store";
import { useDispatch } from "react-redux";
import { FETCH_AUTH_USER, ILoginPayload, ISignupPayload, LOGIN_SAGA, SIGNUP_SAGA } from "../features/auth/types";

export const useAuth = () => {
  const dispatch = useDispatch();

  const authUser = useSelector((state: RootState) => state.auth);

  const fetchAuthUser = () => dispatch({ type: FETCH_AUTH_USER });
  const login = (payload: ILoginPayload) => dispatch({ type: LOGIN_SAGA, payload });
  const signup = (payload: ISignupPayload) => dispatch({ type: SIGNUP_SAGA, payload });

  return { login, signup, fetchAuthUser, authUser };
};
