import { Button, FormControl, InputLabel, MenuItem, Select, Stack, TextField } from "@mui/material";
import { useEffect, useState } from "react";
import api from "../services/api";
import { IMovie } from "../types/IMovie";

interface Props {
  formData: any;
  handleChange: (e: any) => void;
  handleSubmit: (e: any) => void;
}

const AddSessionForm = ({ formData, handleChange, handleSubmit }: Props) => {
  const [movies, setMovies] = useState<IMovie[]>([]);

  const fetchMovies = async () => {
    const res = await api.get("/event/available");
    setMovies(res.data);
  };

  useEffect(() => {
    fetchMovies();
  }, []);

  return (
    <Stack component="form" spacing={2} sx={{ maxWidth: 500 }} onSubmit={handleSubmit}>
      <TextField
        label="Data da Sessão"
        name="sessionDate"
        type="date"
        fullWidth
        value={formData.sessionDate}
        onChange={handleChange}
        InputLabelProps={{ shrink: true }}
      />
      <TextField
        label="Local"
        name="place"
        fullWidth
        value={formData.place}
        onChange={handleChange}
      />
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
      <TextField
        label="Preço do ingresso"
        name="ticketPrice"
        fullWidth
        value={formData.ticketPrice}
        onChange={handleChange}
      />
      <Button variant="contained" type="submit">
        Adicionar
      </Button>
    </Stack>
  );
};

export default AddSessionForm;
