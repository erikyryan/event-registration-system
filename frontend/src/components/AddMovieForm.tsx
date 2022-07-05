import { Button, FormControl, InputLabel, MenuItem, Select, Stack, TextField } from "@mui/material";
import getYears from "../utils/getYears";

interface Props {
  formData: any;
  handleChange: (e: any) => void;
  handleSubmit: (e: any) => void;
}

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

const AddMovieForm = ({ formData, handleChange, handleSubmit }: Props) => {
  return (
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
  );
};

export default AddMovieForm;
