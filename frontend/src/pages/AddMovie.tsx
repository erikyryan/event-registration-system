import { useState } from "react";
import { Box, Button, Stack, Typography } from "@mui/material";
import ArrowBackIcon from "@mui/icons-material/ArrowBack";
import DashboardLayout from "../components/Dashboard/DashboardLayout";

import { Link } from "react-router-dom";
import AddMovieForm from "../components/AddMovieForm";
import api from "../services/api";
import { useAuth } from "../contexts/AuthContext";

const AddMovie = () => {
  const { token } = useAuth();
  const [formData, setFormData] = useState({
    name: "",
    synopsis: "",
    duration: "",
    classification: 18,
    launchYear: "2022",
    movieType: 0
  });

  const handleChange = (e: any) => {
    setFormData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value
    }));
  };

  const handleSubmit = async (e: any) => {
    e.preventDefault();
    try {
      const res = await api.post("/event/create", formData, {
        headers: {
          token: token
        }
      });
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <DashboardLayout>
      <Box sx={{ display: "flex", justifyContent: "space-between", mb: 3 }}>
        <Stack>
          <Button
            startIcon={<ArrowBackIcon />}
            component={Link}
            to="/filmes"
            variant="text"
            size="small"
            color="secondary"
            sx={{ display: "flex", justifyContent: "start", px: 0 }}>
            Voltar para Filmes
          </Button>
          <Typography variant="h4" sx={{ fontWeight: "bold" }}>
            Adicionar Filme
          </Typography>
        </Stack>
      </Box>
      <Box>
        <AddMovieForm formData={formData} handleChange={handleChange} handleSubmit={handleSubmit} />
      </Box>
    </DashboardLayout>
  );
};

export default AddMovie;
