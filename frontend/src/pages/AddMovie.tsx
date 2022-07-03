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
import ArrowBackIcon from "@mui/icons-material/ArrowBack";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import getYears from "../utils/getYears";
import { Link } from "react-router-dom";

const classifications = ["Livre", "10 anos", "12 anos", "14 anos", "16 anos", "18 anos"];
const years = getYears(1999);
const genres = [
  "Ação",
  "Comédia",
  "Drama",
  "Romance",
  "Documentário",
  "Suspense",
  "Terror",
  "Ficção científica"
];

const AddMovie = () => {
  const [formData, setFormData] = useState({
    title: "",
    synopsis: "",
    duration: "",
    classification: "Livre",
    launchYear: "2022",
    genre: "Ação"
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
        <Stack component="form" spacing={2} sx={{ maxWidth: 500 }} onSubmit={handleSubmit}>
          <TextField
            label="Título"
            name="title"
            fullWidth
            value={formData.title}
            onChange={handleChange}
          />
          <TextField
            label="Sinopse"
            name="synopsis"
            fullWidth
            multiline
            maxRows={4}
            value={formData.synopsis}
            onChange={handleChange}
          />
          <TextField
            label="Duração"
            name="duration"
            fullWidth
            type="time"
            InputLabelProps={{ shrink: true }}
            value={formData.duration}
            onChange={handleChange}
          />
          <FormControl fullWidth>
            <InputLabel id="classification">Classificação</InputLabel>
            <Select
              name="classification"
              labelId="classification"
              id="class"
              label="Classificação"
              value={formData.classification}
              onChange={handleChange}>
              {classifications.map((classification) => (
                <MenuItem value={classification}>{classification}</MenuItem>
              ))}
            </Select>
          </FormControl>
          <FormControl fullWidth>
            <InputLabel id="launchYear">Ano de Lançamento</InputLabel>
            <Select
              name="launchYear"
              labelId="launchYear"
              id="year"
              label="Ano de Lançamento"
              value={formData.launchYear}
              onChange={handleChange}>
              {years.map((year) => (
                <MenuItem value={year}>{year}</MenuItem>
              ))}
            </Select>
          </FormControl>
          <FormControl fullWidth>
            <InputLabel id="genre">Gênero</InputLabel>
            <Select
              name="genre"
              labelId="genre"
              id="genre"
              label="Gênero"
              value={formData.genre}
              onChange={handleChange}>
              {genres.map((genre) => (
                <MenuItem value={genre}>{genre}</MenuItem>
              ))}
            </Select>
          </FormControl>
          <Button variant="contained" type="submit">
            Adicionar
          </Button>
        </Stack>
      </Box>
    </DashboardLayout>
  );
};

export default AddMovie;
