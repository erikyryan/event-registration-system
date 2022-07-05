import { useState } from "react";
import {
  Box,
  Button,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  Stack,
  TextField,
  Typography
} from "@mui/material";
import AddSessionForm from "../components/AddSessionForm";

import ArrowBackIcon from "@mui/icons-material/ArrowBack";
import DashboardLayout from "../components/Dashboard/DashboardLayout";

import { Link } from "react-router-dom";

const AddSession = () => {
  const [formData, setFormData] = useState({
    sessionDate: "",
    place: "",
    event: "",
    ticketPrice: ""
  });

  const handleChange = (e: any) => {
    setFormData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value
    }));
  };

  const handleSubmit = (e: any) => {
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
            to="/sessions"
            variant="text"
            size="small"
            color="secondary"
            sx={{ display: "flex", justifyContent: "start", px: 0 }}>
            Voltar para Sessões
          </Button>
          <Typography variant="h4" sx={{ fontWeight: "bold" }}>
            Adicionar Sessão
          </Typography>
        </Stack>
      </Box>
      <Box>
        <AddSessionForm
          formData={formData}
          handleChange={handleChange}
          handleSubmit={handleSubmit}
        />
      </Box>
    </DashboardLayout>
  );
};

export default AddSession;
