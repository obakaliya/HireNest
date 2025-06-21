import React from "react";
import { Snackbar, Alert } from "@mui/material";
import { useSnackbar } from "./hooks/useSnackbar";

export default function SnackbarWrapper() {
  const { isOpen, message, severity, setOpen } = useSnackbar();

  const handleClose = (_event?: React.SyntheticEvent | Event, reason?: string) => {
    if (reason === "clickaway") return;
    setOpen(false);
  };

  return (
    <Snackbar anchorOrigin={{ vertical: "top", horizontal: "right" }} open={isOpen} autoHideDuration={3000} onClose={handleClose}>
      <Alert severity={severity} onClose={() => setOpen(false)} sx={{ width: "100%" }}>
        {message}
      </Alert>
    </Snackbar>
  );
}
