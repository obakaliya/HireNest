import { takeEvery, put, call, fork } from "redux-saga/effects";
import { FETCH_AUTH_USER, ILoginPayload, ISignupPayload, LOGIN_SAGA, SIGNUP_SAGA } from "./types";
import { PayloadAction } from "@reduxjs/toolkit";
import axios from "../../services/axiosService";
import { setAuthUser } from "./authSlice";
import { navigate } from "../../services/navigateService";

function* handleFetchAuthUser() {
  try {
    const { data } = yield call(axios.get, "/api/v1/users/auth");
    yield put(setAuthUser(data));
    navigate("/dashboard");
  } catch (error) {
    localStorage.removeItem("token");
    navigate("/login");
    console.error("Auth fetch error:", error);
  }
}

function* handleLogin({ payload }: PayloadAction<ILoginPayload>) {
  try {
    const { data } = yield call(axios.post, "/api/v1/auth/login", payload);
    localStorage.setItem("token", data.token);
    yield put({ type: FETCH_AUTH_USER });
  } catch (error) {
    console.error("Login error:", error);
  }
}

function* handleSignup({ payload }: PayloadAction<ISignupPayload>) {
  try {
    const { data } = yield call(axios.post, "/api/v1/auth/register", payload);
    localStorage.setItem("token", data.token);
    yield put({ type: FETCH_AUTH_USER });
  } catch (error) {
    console.error("Signup error:", error);
  }
}

export function* authSaga() {
  yield fork(handleFetchAuthUser);
  yield takeEvery(LOGIN_SAGA, handleLogin);
  yield takeEvery(SIGNUP_SAGA, handleSignup);
  yield takeEvery(FETCH_AUTH_USER, handleFetchAuthUser);
}
