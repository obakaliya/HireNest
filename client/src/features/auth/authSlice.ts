import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { AUTH_REDUCER_NAME, IAuth, IAuthUser } from "./types";

const initialState: IAuth = {
  isAuthenticated: false,
  user: undefined
};

const authSlice = createSlice({
  name: AUTH_REDUCER_NAME,
  initialState,
  reducers: {
    setAuthUser: (state, action: PayloadAction<Required<IAuthUser>>) => {
      state.isAuthenticated = true;
      state.user = {
        firstName: action.payload.firstName,
        lastName: action.payload.lastName,
        email: action.payload.email,
        roles: action.payload.roles
      };
    }
  }
});

export const { setAuthUser } = authSlice.actions;
export default authSlice.reducer;
