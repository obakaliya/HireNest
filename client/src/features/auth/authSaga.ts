import { takeEvery, put, call, Effect, fork } from "redux-saga/effects";
import { FETCH_AUTH_USER, ILoginPayload, ISignupPayload, LOGIN_SAGA, SIGNUP_SAGA } from "./types";
import { PayloadAction } from "@reduxjs/toolkit";
import axios from "../../services/axiosService";
import { setAuthUser } from "./authSlice";
import { navigate } from "../../services/navigateService";

function* handleFetchAuthUser(): Generator<Effect, void, any> {
  try {
    const response = yield call(axios.get, "/api/v1/users/auth");
    yield put(setAuthUser(response.data));
    navigate("/dashboard");
  } catch (error) {
    console.error(error);
  }
}

function* handleLogin(action: PayloadAction<ILoginPayload>): Generator<Effect, void, any> {
  try {
    const response = yield call(axios.post, "/api/v1/auth/login", action.payload);
    localStorage.setItem("token", response.data.token);
  } catch (error) {
    console.error(error);
  }
}

function* handleSignup(action: PayloadAction<ISignupPayload>): Generator<Effect, void, any> {
  try {
    const response = yield call(axios.post, "/api/v1/auth/register", action.payload);
    localStorage.setItem("token", response.data.token);
  } catch (error) {
    console.error(error);
  }
}

export function* authSaga() {
  yield fork(handleFetchAuthUser);
  yield takeEvery(LOGIN_SAGA, handleLogin);
  yield takeEvery(SIGNUP_SAGA, handleSignup);
  yield takeEvery(FETCH_AUTH_USER, handleFetchAuthUser);
}
