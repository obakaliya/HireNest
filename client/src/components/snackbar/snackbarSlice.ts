import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { ISnackbar, SNACK_SLICE_NAME, SnackbarSeverity } from "./types";

const initialState: ISnackbar = {
  open: false,
  message: "",
  severity: "info"
};

const snackbarSlice = createSlice({
  name: SNACK_SLICE_NAME,
  initialState,
  reducers: {
    setOpen: (state, action: PayloadAction<boolean>) => {
      state.open = action.payload;
    },
    setSnackbar: (state, action: PayloadAction<{ message: string; severity: SnackbarSeverity }>) => {
      state.open = true;
      state.message = action.payload.message;
      state.severity = action.payload.severity;
    }
  }
});

export const { setOpen, setSnackbar } = snackbarSlice.actions;
export default snackbarSlice.reducer;
