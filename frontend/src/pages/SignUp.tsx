import React, { useState } from "react";
import { Card, CardContent, Typography, Container, Stack, Button } from "@mui/material";
import { Link } from "react-router-dom";

import axios from "axios";
import api from "../services/api";
import SignUpForm from "../components/SignUpForm";
import { FormData } from "../components/SignUpForm/formTypes";

const SignUp = () => {
  const handleSubmit = async (data: FormData) => {
    const res = await api.post("/user/create", {
      name: data.name,
      password: data.password,
      doc: data.doc,
      email: data.email,
      telephone: data.telephone,
      login: data.login,
      birthDate: data.birthDate,
      sex: "M"
    });
    console.log(res);
  };

  return (
    <Container
      sx={{ display: "flex", justifyContent: "center", alignItems: "center", minHeight: "100vh" }}>
      <Card sx={{ width: 600, padding: 2 }}>
        <Typography variant="h4" align="center" sx={{ mb: 2 }}>
          Cadastrar-se
        </Typography>
        <SignUpForm handleSubmit={handleSubmit} />
        <Typography variant="body2" align="center" sx={{ mt: 2 }}>
          Já possui uma conta?{" "}
          <Typography component={Link} to="/login" variant="body2">
            Entrar
          </Typography>
        </Typography>
      </Card>
    </Container>
  );
};

export default SignUp;
