import {
  Button,
  FormControl,
  Grid,
  InputLabel,
  MenuItem,
  Select,
  Stack,
  TextField
} from "@mui/material";
import { useEffect, useState } from "react";
import api from "../services/api";
import { IMovie } from "../types/IMovie";

interface Props {
  formData: any;
  handleChange: (e: any) => void;
  handleSubmit: (e: any) => void;
}

const status = ["EM ANDAMENTO", "FINALIZADO", "AGENDADO"];

const AddSessionForm = ({ formData, handleChange, handleSubmit }: Props) => {
  const [movies, setMovies] = useState<IMovie[]>([]);

  const fetchMovies = async () => {
    const res = await api.get("/event/public/available");
    setMovies(res.data);
  };

  useEffect(() => {
    fetchMovies();
  }, []);

  return (
    <Grid
      container
      columns={{ xs: 8, md: 12 }}
      component="form"
      spacing={2}
      onSubmit={handleSubmit}>
      <Grid item xs={4} md={6}>
        <TextField
          label="Data da Sessão"
          name="sessionDate"
          type="date"
          fullWidth
          value={formData.sessionDate}
          onChange={handleChange}
          InputLabelProps={{ shrink: true }}
        />
      </Grid>{" "}
      <Grid item xs={4} md={6}>
        <TextField
          label="Local"
          name="place"
          fullWidth
          value={formData.place}
          onChange={handleChange}
        />
      </Grid>
      <Grid item xs={4} md={6}>
        <FormControl fullWidth>
          <InputLabel id="event">Evento</InputLabel>
          <Select
            name="event"
            labelId="event"
            id="event"
            label="Evento"
            value={formData.event}
            onChange={handleChange}>
            {movies?.map((movie) => (
              <MenuItem value={movie.id}>{movie.name}</MenuItem>
            ))}
          </Select>
        </FormControl>
      </Grid>
      <Grid item xs={4} md={6}>
        <FormControl fullWidth>
          <InputLabel id="status">Status</InputLabel>
          <Select
            name="sessiosStatus"
            labelId="status"
            id="status"
            label="Status"
            value={formData.sessiosStatus}
            onChange={handleChange}>
            {status?.map((stat, index) => (
              <MenuItem value={index}>{stat}</MenuItem>
            ))}
          </Select>
        </FormControl>
      </Grid>
      <Grid item xs={12}>
        <TextField
          label="Preço do ingresso"
          name="ticketPrice"
          type="number"
          fullWidth
          value={formData.ticketPrice}
          onChange={handleChange}
        />
      </Grid>
      <Grid item xs={12}>
        <Button variant="contained" type="submit" fullWidth size="large">
          Adicionar
        </Button>
      </Grid>
    </Grid>
  );
};

export default AddSessionForm;
