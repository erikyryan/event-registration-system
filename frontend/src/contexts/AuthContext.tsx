import React, { createContext, useContext, useEffect, useState } from "react";
import api from "../services/api";
import { IUser } from "../types/IUser";
import getUserByToken from "../utils/getUserByToken";

interface Value {
  currentUser: IUser | null;
  token: string | null;
  login: (email: string, password: string) => Promise<IUser>;
  logout: () => void;
}

const AuthContext = createContext<Value>({} as Value);

export const useAuth = () => {
  return useContext(AuthContext);
};

export const AuthProvider = ({ children }: { children: React.ReactNode }) => {
  const [currentUser, setCurrentUser] = useState<IUser | null>(null);
  const [loading, setLoading] = useState(true);
  const [token, setToken] = useState(localStorage.getItem("token"));

  const login = async (email: string, password: string) => {
    try {
      const res = await api.post("/user/login", {
        email,
        password
      });
      localStorage.setItem("token", res.data);

      const user = await getUserByToken(res.data);
      setCurrentUser(user);
      return user;
    } catch (error) {
      console.log(error);
      return error;
    }
  };

  const logout = () => {
    localStorage.removeItem("token");
    setCurrentUser(null);
    setToken(null);
  };

  const getUser = async () => {
    setLoading(true);
    if (token) {
      try {
        const user = await getUserByToken(token);
        setCurrentUser(user);
      } catch (error) {
        console.log(error);
      }
    }
    setLoading(false);
  };

  useEffect(() => {
    getUser();
  }, []);

  const value = {
    currentUser,
    token,
    login,
    logout
  };

  return <AuthContext.Provider value={value}>{!loading && children}</AuthContext.Provider>;
};
