import React, { useState } from "react";
import {
  Card,
  CardContent,
  Typography,
  Container,
  TextField,
  Box,
  Stack,
  Button
} from "@mui/material";
import { Link, useNavigate } from "react-router-dom";
import api from "../services/api";
import useLocalStorage from "../hooks/useLocalStorage";

const Login = () => {
  const [login, setLogin] = useState("");
  const [password, setPassword] = useState("");
  const { save, token, getToken } = useLocalStorage();
  const navigate = useNavigate();

  const handleSubmit = async (e: any) => {
    e.preventDefault();

    try {
      const res = await api.post("/user/login", {
        login,
        password
      });
      save(res.data);
      navigate("/");
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <Container
      sx={{ display: "flex", justifyContent: "center", alignItems: "center", minHeight: "100vh" }}>
      <Card sx={{ width: 350 }}>
        <CardContent>
          <Typography variant="h4" align="center">
            Entrar
          </Typography>
          <Stack sx={{ marginTop: 2 }} spacing={2} component="form" onSubmit={handleSubmit}>
            <TextField
              label="Login"
              variant="standard"
              required
              value={login}
              onChange={(e) => setLogin(e.target.value)}
            />
            <TextField
              label="Senha"
              type="password"
              variant="standard"
              required
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            <Button variant="contained" color="primary" type="submit">
              Entrar
            </Button>
            <Typography variant="body2" align="center">
              Ainda não tem uma conta?{" "}
              <Typography component={Link} to="/signup" variant="body2">
                Cadastre-se
              </Typography>
            </Typography>
          </Stack>
        </CardContent>
      </Card>
    </Container>
  );
};

export default Login;
