import React, { useEffect } from "react";
import { Routes, Route, useNavigate } from "react-router-dom";
import Layout from "../layouts/AppFrame";
import Login from "../features/auth/pages/Login";
import Signup from "../features/auth/pages/Signup";
import PrivateRoutes from "../components/PrivateRoutes";
import Dashboard from "../features/dashboard/pages/Dashboard";
import { setNavigator } from "../services/navigateService";

export default function AppRouter() {
  const navigate = useNavigate();

  useEffect(() => {
    setNavigator(navigate);
  }, [navigate]);

  return (
    <Routes>
      {/* Public routes */}
      <Route path='/signup' element={<Signup />} />
      <Route path='/login' element={<Login />} />

      {/* Private layout-protected routes */}
      <Route path='/' element={<PrivateRoutes />}>
        <Route element={<Layout />}>
          <Route path='/dashboard' element={<Dashboard />} />
        </Route>
      </Route>
    </Routes>
  );
}
