import React, { useEffect } from "react";
import { Routes, Route, useNavigate } from "react-router-dom";
import Dashboard from "../layouts/Dashboard";
import Login from "../pages/auth/Login";
import Signup from "../pages/auth/Signup";
import PrivateRoutes from "../components/PrivateRoutes";
import { setNavigator } from "../services/navigateService";

export default function AppRouter() {
  const navigate = useNavigate();

  useEffect(() => {
    setNavigator(navigate);
  }, [navigate]);

  return (
    <Routes>
      <Route path='/signup' element={<Signup />} />
      <Route path='/login' element={<Login />} />

      {/* Private routes */}
      <Route path='/' element={<PrivateRoutes />}>
        <Route path='/dashboard' element={<Dashboard />} />
      </Route>
    </Routes>
  );
}
