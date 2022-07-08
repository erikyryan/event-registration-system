import React from "react";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import { Box, Typography, Button } from "@mui/material";
import UsersList from "../components/UsersList";
import { Link } from "react-router-dom";

const Users = () => {
  return (
    <DashboardLayout>
      <Box
        sx={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
          width: "100%",
          mb: 3
        }}>
        <Typography variant="h4" sx={{ fontWeight: "bold" }}>
          Usuários
        </Typography>
        <Box>
          <Button variant="contained" component={Link} to="/users/adicionar">
            Adicionar Usuário
          </Button>
        </Box>
      </Box>

      <UsersList users={[]} />
    </DashboardLayout>
  );
};

export default Users;
