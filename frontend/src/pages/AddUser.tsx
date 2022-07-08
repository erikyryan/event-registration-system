import React, { useState } from "react";
import { Box, Button, Stack, Typography } from "@mui/material";
import { Link } from "react-router-dom";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import ArrowBackIcon from "@mui/icons-material/ArrowBack";
import AddUserForm from "../components/AddUserForm";

const AddUser = () => {
  const [formData, setFormData] = useState({
    name: "",
    doc: "",
    email: "",
    telephone: "",
    password: "",
    role: "VENDEDOR"
  });

  const handleChange = (e: any) => {
    setFormData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value
    }));
  };

  const handleSubmit = async (e: any) => {
    e.preventDefault();
    console.log(formData);
  };

  return (
    <DashboardLayout>
      <Box sx={{ display: "flex", justifyContent: "space-between", mb: 3 }}>
        <Stack>
          <Button
            startIcon={<ArrowBackIcon />}
            component={Link}
            to="/users"
            variant="text"
            size="small"
            color="secondary"
            sx={{ display: "flex", justifyContent: "start", px: 0 }}>
            Voltar para usuários
          </Button>
          <Typography variant="h4" sx={{ fontWeight: "bold" }}>
            Adicionar usuário
          </Typography>
        </Stack>
      </Box>
      <Box>
        <AddUserForm formData={formData} handleChange={handleChange} handleSubmit={handleSubmit} />
      </Box>
    </DashboardLayout>
  );
};

export default AddUser;
