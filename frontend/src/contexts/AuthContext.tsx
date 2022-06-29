import React, { createContext, useContext, useEffect, useState } from "react";
import useLocalStorage from "../hooks/useLocalStorage";

interface Value {
  currentUser: any;
  token: any;
  logout: () => void;
}

const AuthContext = createContext<Value>({} as Value);

export const useAuth = () => {
  return useContext(AuthContext);
};

export const AuthProvider = ({ children }: { children: React.ReactNode }) => {
  const [currentUser, setCurrentUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [token, setToken] = useState("");
  const { getToken, remove } = useLocalStorage();

  const logout = () => {
    remove();
  };

  useEffect(() => {
    setLoading(true);
    const t = getToken();
    setToken(t);
    setLoading(false);
  }, []);

  const value = {
    currentUser,
    token,
    logout
  };

  return <AuthContext.Provider value={value}>{!loading && children}</AuthContext.Provider>;
};
