import React from "react";
import { Navigate, Outlet } from "react-router-dom";
import { useAuth } from "../hooks/useAuth";

export default function PrivateRoutes() {
  const { authUser } = useAuth();

  if (authUser.user === undefined) {
    return <div>Loading...</div>;
  }

  return authUser.isAuthenticated ? <Outlet /> : <Navigate to='/login' replace />;
}
