import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../../../app/store";
import { setOpen, setSnackbar } from "../snackbarSlice";
import { SnackbarSeverity } from "../types";

export const useSnackbar = () => {
  const dispatch = useDispatch();

  const isOpen = useSelector((state: RootState) => state.snackbar.open);
  const message = useSelector((state: RootState) => state.snackbar.message);
  const severity = useSelector((state: RootState) => state.snackbar.severity);

  return {
    isOpen,
    message,
    severity,
    setSnackbarMessage: (msg: string, type: SnackbarSeverity = "info") => dispatch(setSnackbar({ message: msg, severity: type })),
    setOpen: (open: boolean) => dispatch(setOpen(open))
  };
};
