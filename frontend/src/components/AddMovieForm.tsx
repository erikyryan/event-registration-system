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
import getYears from "../utils/getYears";
import MaskedInput from "./MaskedInput";

interface Props {
  formData: any;
  handleChange: (e: any) => void;
  handleSubmit: (e: any) => void;
}

const classifications = ["Livre", 10, 12, 14, 16, 18];
const years = getYears(1999);
const movieTypes = ["DUBLADO", "LEGENDADO"];

const AddMovieForm = ({ formData, handleChange, handleSubmit }: Props) => {
  return (
    <Grid
      container
      columns={{ xs: 8, md: 12 }}
      component="form"
      spacing={2}
      onSubmit={handleSubmit}>
      <Grid item xs={4} md={6}>
        <TextField
          label="Título"
          name="name"
          fullWidth
          value={formData.name}
          onChange={handleChange}
        />
      </Grid>
      <Grid item xs={4} md={6}>
        <TextField
          label="Sinopse"
          name="synopsis"
          fullWidth
          multiline
          maxRows={4}
          value={formData.synopsis}
          onChange={handleChange}
        />
      </Grid>
      <Grid item xs={4} md={6}>
        <TextField
          label="Data do Filme"
          name="eventDate"
          fullWidth
          type="date"
          value={formData.eventDate}
          onChange={handleChange}
          InputLabelProps={{ shrink: true }}
        />
      </Grid>
      <Grid item xs={4} md={6}>
        <MaskedInput
          mask="09h 99min"
          label="Duração"
          name="duration"
          value={formData.duration}
          handleChange={handleChange}
        />
      </Grid>
      <Grid item xs={4} md={6}>
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
      </Grid>
      <Grid item xs={4} md={6}>
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
      </Grid>
      <Grid item xs={12}>
        <FormControl fullWidth>
          <InputLabel id="movieType">Tipo de filme</InputLabel>
          <Select
            name="movieType"
            labelId="movieType"
            id="movieType"
            label="Tipo de filme"
            value={formData.movieType}
            onChange={handleChange}>
            {movieTypes.map((movieType, index) => (
              <MenuItem value={index}>{movieType}</MenuItem>
            ))}
          </Select>
        </FormControl>
      </Grid>
      <Grid item xs={12} sx={{ mt: 2 }}>
        <Button variant="contained" type="submit" size="large" fullWidth>
          Adicionar
        </Button>
      </Grid>
    </Grid>
  );
};

export default AddMovieForm;
