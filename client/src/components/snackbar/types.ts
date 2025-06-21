export const SNACK_SLICE_NAME = "snackbar";

export const SET_SNACKBAR_OPEN = "SET_SNACKBAR_OPEN";
export const SET_SNACKBAR_MESSAGE = "SET_SNACKBAR_MESSAGE";

export const SNACKBAR_SEVERITY_SUCCESS = "success";
export const SNACKBAR_SEVERITY_ERROR = "error";
export const SNACKBAR_SEVERITY_WARNING = "warning";
export const SNACKBAR_SEVERITY_INFO = "info";

export type SnackbarSeverity =
  | typeof SNACKBAR_SEVERITY_SUCCESS
  | typeof SNACKBAR_SEVERITY_ERROR
  | typeof SNACKBAR_SEVERITY_WARNING
  | typeof SNACKBAR_SEVERITY_INFO;

export interface ISnackbar {
  open: boolean;
  message: string;
  severity: SnackbarSeverity;
}
