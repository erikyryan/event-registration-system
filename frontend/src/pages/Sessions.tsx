import React from "react";
import { Box, Button, Typography } from "@mui/material";
import { Link } from "react-router-dom";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import { useAuth } from "../contexts/AuthContext";

const Sessions = () => {
  const { currentUser } = useAuth();

  return (
    <DashboardLayout>
      <Box sx={{ display: "flex", justifyContent: "space-between", mb: 3 }}>
        <Typography variant="h4" sx={{ fontWeight: "bold" }}>
          Sessões
        </Typography>
        {currentUser?.role === "ADMIN" && (
          <Box>
            <Button variant="contained" component={Link} to="/sessions/adicionar">
              Adicionar Sessão
            </Button>
          </Box>
        )}
      </Box>
    </DashboardLayout>
  );
};

export default Sessions;
