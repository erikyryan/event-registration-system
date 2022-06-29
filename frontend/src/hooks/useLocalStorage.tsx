import React, { useEffect, useState } from "react";

const useLocalStorage = () => {
  const [token, setToken] = useState<string | null>("");

  const save = (data: string) => {
    localStorage.setItem("token", data);
  };

  const getToken = (): string | null => {
    const t = localStorage.getItem("token");
    return t;
  };

  const remove = () => {
    localStorage.clear();
  };

  useEffect(() => {
    const t = localStorage.getItem("token");
    setToken(t);
  }, []);

  return { token, save, getToken, remove };
};

export default useLocalStorage;
