import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { DASHBOARD_REDUCER_NAME } from "./types";

const initialState: any = {};

const dashboardSlice = createSlice({
  name: DASHBOARD_REDUCER_NAME,
  initialState,
  reducers: {
    setSomething: (state, action: PayloadAction<Required<any>>) => {
      //
    }
  }
});

// export const {
//     // export something
//  } = dashboardSlice.actions;
export default dashboardSlice.reducer;
