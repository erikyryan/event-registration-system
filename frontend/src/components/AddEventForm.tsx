import { Button, FormControl, Grid, InputLabel, MenuItem, Select, TextField } from "@mui/material";
import { useState } from "react";
import getYears from "../utils/getYears";
import MaskedInput from "./MaskedInput";

interface Props {
  formData: any;
  handleChange: (e: any) => void;
  handleSubmit: (e: any) => void;
}

const AddEventForm = ({ formData, handleChange, handleSubmit }: Props) => {

  const [teachers, setTeachers] = useState([""]);

  const addTeacher = () => {
    setTeachers([...teachers, ""]);
  }

  const rmvTeacher = () => {
    setTeachers(teachers.slice(0, teachers.length - 1));
  }

  const styleButtons = {
    position: "absolute",
    right: 5,
    zIndex: 9999,
    fontWeigth: 800,
    fontSize: 20,
    padding: 0,
    margin: 0,
    backgroundColor: "transparent",
    border: 0,
    width: 20,
    cursor: "pointer"
  }

  const eventTypes = ["FILME", "CURTA", "TEATRO", "COMEDIA", "WORKSHOP", "CURSO"];
  const classifications = ["Livre", 10, 12, 14, 16, 18];
  const years = getYears(1999);
  const movieTypes = ["DUBLADO", "LEGENDADO"];
  const periods = ["MANHÃ", "TARDE", "NOITE"];
  const structures = ["COBERTO", "AR LIVRE"];
  const types = ["PRESENCIAL", "ONLINE"];

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
              <MenuItem value={eventType} key={eventType}>
                {eventType}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </Grid>
      {["FILME", "CURTA", "TEATRO", "WORKSHOP", "CURSO"].includes(formData.eventType) && (
        <Grid item xs={4} md={6}>
          <TextField
            label="Título"
            name="name"
            fullWidth
            value={formData.name}
            onChange={handleChange}
          />
        </Grid>
      )}
      {["FILME", "CURTA"].includes(formData.eventType) && (
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
                <MenuItem value={movieType} key={movieType}>
                  {movieType}
                </MenuItem>
              ))}
            </Select>
          </FormControl>
        </Grid>
      )}
      {["TEATRO"].includes(formData.eventType) && (
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
      {["COMEDIA"].includes(formData.eventType) && (
        <Grid item xs={4} md={6}>
          <TextField
            label="Comediante"
            name="comedian"
            fullWidth
            value={formData.comedian}
            onChange={handleChange}
          />
        </Grid>
      )}
      {["COMEDIA"].includes(formData.eventType) && (
        <Grid item xs={4} md={6}>
          <TextField
            label="Nome do Evento"
            name="eventName"
            fullWidth
            value={formData.eventName}
            onChange={handleChange}
          />
        </Grid>
      )}
      {["FILME", "CURTA", "TEATRO", "WORKSHOP", "CURSO"].includes(formData.eventType) && (
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
      )}
      {["FILME", "CURTA", "TEATRO", "WORKSHOP", "CURSO"].includes(formData.eventType) && (
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
      )}
      {["COMEDIA"].includes(formData.eventType) && (
        <Grid item xs={4} md={6}>
          <TextField
            label="Data"
            name="date"
            fullWidth
            type="date"
            value={formData.date}
            onChange={handleChange}
            InputLabelProps={{ shrink: true }}
          />
        </Grid>
      )}
      {["FILME", "COMEDIA", "WORKSHOP", "CURSO"].includes(formData.eventType) && (
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
      {["CURTA"].includes(formData.eventType) && (
        <Grid item xs={4} md={6}>
          <MaskedInput
            mask="99min"
            label="Duração"
            name="duration"
            value={formData.duration}
            handleChange={handleChange}
          />
        </Grid>
      )}
      {["FILME", "CURTA", "TEATRO", "COMEDIA"].includes(formData.eventType) && (
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
      )}
      {["FILME", "CURTA"].includes(formData.eventType) && (
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
      )}
      {["FILME", "CURTA"].includes(formData.eventType) && (
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
      )}
      {["TEATRO"].includes(formData.eventType) && (
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
                <MenuItem value={period} key={period}>
                  {period}
                </MenuItem>
              ))}
            </Select>
          </FormControl>
        </Grid>
      )}
      {["TEATRO"].includes(formData.eventType) && (
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
                <MenuItem value={structure} key={structure}>
                  {structure}
                </MenuItem>
              ))}
            </Select>
          </FormControl>
        </Grid>
      )}
      {["WORKSHOP", "CURSO"].includes(formData.eventType) && (
        <Grid item xs={4} md={6}>
          <FormControl fullWidth>
            <InputLabel id="type">Formato</InputLabel>
            <Select
              name="type"
              labelId="type"
              id="type"
              label="Formato"
              value={formData.type}
              onChange={handleChange}>
              {types.map((type, index) => (
                <MenuItem value={type} key={type}>
                  {type}
                </MenuItem>
              ))}
            </Select>
          </FormControl>
        </Grid>
      )}
      {["WORKSHOP", "CURSO"].includes(formData.eventType) &&
        <Grid item xs={4} md={6}>
        <TextField
          label="Professores"
          name="teachers"
          fullWidth
          value={formData.teachers}
          onChange={handleChange}
        />
      </Grid>
      }
      {["CURSO"].includes(formData.eventType) && (
        <Grid item xs={4} md={6}>
          <TextField
            label="Equipamentos"
            name="equipments"
            fullWidth
            value={formData.equipments}
            onChange={handleChange}
          />
        </Grid>
      )}
      {["CURSO"].includes(formData.eventType) && (
        <Grid item xs={4} md={6}>
          <TextField
            label="Conteúdos"
            name="subject"
            fullWidth
            value={formData.subject}
            onChange={handleChange}
          />
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
