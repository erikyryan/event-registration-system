import { Button, FormControl, Grid, InputLabel, MenuItem, Select, TextField } from "@mui/material";
import getYears from "../utils/getYears";
import MaskedInput from "./MaskedInput";

interface Props {
  formData: any;
  handleChange: (e: any) => void;
  handleSubmit: (e: any) => void;
}

const eventTypes = ['FILME', 'CURTA', 'TEATRO', 'COMEDIA',"WORKSHOP", 'CURSO'];
const classifications = ["Livre", 10, 12, 14, 16, 18];
const years = getYears(1999);
const movieTypes = ["DUBLADO", "LEGENDADO"];
const periods = ["MANHÃ","TARDE", "NOITE"];
const structures = ["COBERTO", "AR LIVRE"];

const AddEventForm = ({ formData, handleChange, handleSubmit }: Props) => {
  return (
    <Grid
      container
      columns={{ xs: 8, md: 12 }}
      component="form"
      spacing={2}
      onSubmit={handleSubmit}>
      <Grid item xs={8} md={12}>
        <FormControl fullWidth>
          <InputLabel id="movieType">Tipo de evento</InputLabel>
          <Select
            name="eventType"
            labelId="eventType"
            id="eventType"
            label="Tipo de evento"
            value={formData.eventType}
            onChange={handleChange}>
            {eventTypes.map((eventType, index) => (
              <MenuItem value={index} key={eventType}>
                {eventType}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </Grid>
      <Grid item xs={4} md={6}>
        <TextField
          label="Título"
          name="name"
          fullWidth
          value={formData.name}
          onChange={handleChange}
        />
      </Grid>
      {formData.eventType === 0 && (
        <Grid item xs={4} md={6}>
          <FormControl fullWidth>
            <InputLabel id="movieType">Tipo de exibição</InputLabel>
            <Select
              name="movieType"
              labelId="movieType"
              id="movieType"
              label="Tipo de exibição"
              value={formData.movieType}
              onChange={handleChange}>
              {movieTypes.map((movieType, index) => (
                <MenuItem value={index} key={movieType}>
                  {movieType}
                </MenuItem>
              ))}
            </Select>
          </FormControl>
        </Grid>
      )}
      {formData.eventType === 1 && (
        <Grid item xs={4} md={6}>
          <TextField
            label="Atores"
            name="actors"
            fullWidth
            value={formData.actors}
            onChange={handleChange}
          />
        </Grid>
      )}
      <Grid item xs={4} md={6}>
        <TextField
          label="Data de início"
          name="eventStartDate"
          fullWidth
          type="date"
          value={formData.eventStartDate}
          onChange={handleChange}
          InputLabelProps={{ shrink: true }}
        />
      </Grid>
      <Grid item xs={4} md={6}>
        <TextField
          label="Data de fim"
          name="eventEndDate"
          fullWidth
          type="date"
          value={formData.eventEndDate}
          onChange={handleChange}
          InputLabelProps={{ shrink: true }}
        />
      </Grid>
      {formData.eventType === 0 && (
        <Grid item xs={4} md={6}>
          <MaskedInput
            mask="09h 99min"
            label="Duração"
            name="duration"
            value={formData.duration}
            handleChange={handleChange}
          />
        </Grid>
      )}
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
              <MenuItem value={classification} key={classification}>
                {classification}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </Grid>
      {formData.eventType === 0 && 
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
                <MenuItem value={year} key={year}>
                  {year}
                </MenuItem>
              ))}
            </Select>
          </FormControl>
        </Grid>
      }
      {formData.eventType === 0 &&
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
      }
      {formData.eventType === 1 && (
        <Grid item xs={4} md={6}>
          <FormControl fullWidth>
            <InputLabel id="period">Período</InputLabel>
            <Select
              name="period"
              labelId="period"
              id="period"
              label="Período"
              value={formData.period}
              onChange={handleChange}>
              {periods.map((period, index) => (
                <MenuItem value={index} key={period}>
                  {period}
                </MenuItem>
              ))}
            </Select>
          </FormControl>
        </Grid>
      )}
      {formData.eventType === 1 && (
        <Grid item xs={4} md={6}>
          <FormControl fullWidth>
            <InputLabel id="structure">Estrutura</InputLabel>
            <Select
              name="structure"
              labelId="structure"
              id="structure"
              label="Estrutura"
              value={formData.structure}
              onChange={handleChange}>
              {structures.map((structure, index) => (
                <MenuItem value={index} key={structure}>
                  {structure}
                </MenuItem>
              ))}
            </Select>
          </FormControl>
        </Grid>
      )}
      <Grid item xs={12} sx={{ mt: 2 }}>
        <Button variant="contained" type="submit" size="large" fullWidth>
          Adicionar
        </Button>
      </Grid>
    </Grid>
  );
};

export default AddEventForm;
