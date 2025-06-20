import React from "react";
import { Navigate, Outlet } from "react-router-dom";
import { useAuth } from "../features/auth/hooks/useAuth";
import { Box, CircularProgress } from "@mui/material";

export default function PrivateRoutes() {
  const { authUser } = useAuth();

  if (authUser.user === undefined) {
    return (
      <Box display='flex' justifyContent='center' alignItems='center' height='100vh'>
        <CircularProgress />
      </Box>
    );
  }

  return authUser.isAuthenticated ? <Outlet /> : <Navigate to='/login' replace />;
}
