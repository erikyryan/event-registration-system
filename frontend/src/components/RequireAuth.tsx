import React from "react";
import { Navigate, Outlet, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";

const RequireAuth = ({ allowedRoles }: { allowedRoles?: string[] }) => {
  const { currentUser } = useAuth();
  const location = useLocation();

  return currentUser && allowedRoles?.includes(currentUser?.role) ? (
    <Outlet />
  ) : (
    <Navigate to="/" state={{ from: location }} replace />
  );
};

export default RequireAuth;
