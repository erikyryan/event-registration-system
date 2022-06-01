import React from "react";
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
import { Link } from "react-router-dom";

const Login = () => {
  return (
    <Container
      sx={{ display: "flex", justifyContent: "center", alignItems: "center", minHeight: "100vh" }}>
      <Card sx={{ width: 350 }}>
        <CardContent>
          <Typography variant="h4" align="center">
            Login
          </Typography>
          <Stack sx={{ marginTop: 2 }} spacing={2}>
            <TextField label="Email" variant="standard" required />
            <TextField label="Password" type="password" variant="standard" required />
            <Button variant="contained">Login</Button>
            <Typography variant="body2" align="center">
              Do not have an account?{" "}
              <Typography component={Link} to="/signup" variant="body2">
                Sign Up
              </Typography>
            </Typography>
          </Stack>
        </CardContent>
      </Card>
    </Container>
  );
};

export default Login;
