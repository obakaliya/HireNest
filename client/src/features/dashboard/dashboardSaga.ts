import axios from "../../services/axiosService";
import { takeEvery, put, call, Effect, fork } from "redux-saga/effects";
import { FETCH_SOMETHING } from "./types";

function* handleFetchSomething() {
  try {
    const { data } = yield call(axios.get, "/api/v1/{_____}");
    // put data
  } catch (error) {
    console.error(error);
  }
}

export function* dashboardSaga() {
  yield takeEvery(FETCH_SOMETHING, handleFetchSomething);
}
