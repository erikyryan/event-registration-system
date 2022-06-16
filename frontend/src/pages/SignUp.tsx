import React, { useState } from "react";
import { Card, CardContent, Typography, Container, Stack, Button } from "@mui/material";
import { Link } from "react-router-dom";

import api from "../services/api";
import SignUpForm from "../components/SignUpForm";
import { FormData } from "../components/SignUpForm/formTypes";

const SignUp = () => {
  const handleSubmit = async (data: FormData) => {
    console.log(data);
    //const res = await api.post("/users", {});
  };

  return (
    <Container
      sx={{ display: "flex", justifyContent: "center", alignItems: "center", minHeight: "100vh" }}>
      <Card sx={{ width: 500, padding: 2 }}>
        <SignUpForm handleSubmit={handleSubmit} />
      </Card>
    </Container>
  );
};

export default SignUp;
