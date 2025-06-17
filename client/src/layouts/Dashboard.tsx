import React, { useEffect } from "react";
import { useAuth } from "../hooks/useAuth";

export default function Dashboard() {
  const { authUser, fetchAuthUser } = useAuth();

  useEffect(() => {
    if (authUser.user === undefined) fetchAuthUser();
  }, [authUser, fetchAuthUser]);

  return <div>Dashboard</div>;
}
