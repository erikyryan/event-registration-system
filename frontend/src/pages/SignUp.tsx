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

const SignUp = () => {
  return (
    <Container
      sx={{ display: "flex", justifyContent: "center", alignItems: "center", minHeight: "100vh" }}>
      <Card sx={{ width: 350 }}>
        <CardContent>
          <Typography variant="h4" align="center">
            Sign Up
          </Typography>
          <Stack sx={{ marginTop: 2 }} spacing={2}>
            <TextField label="Email" variant="standard" required />
            <TextField label="Password" type="password" variant="standard" required />
            <TextField label="Confirm Password" type="password" variant="standard" required />
            <Button variant="contained">Sign Up</Button>
            <Typography variant="body2" align="center">
              Already have an account?{" "}
              <Typography component={Link} to="/login" variant="body2">
                Login
              </Typography>
            </Typography>
          </Stack>
        </CardContent>
      </Card>
    </Container>
  );
};

export default SignUp;
