import React from "react";
import {
  Button,
  FormControl,
  FormControlLabel,
  FormLabel,
  Grid,
  InputLabel,
  Radio,
  RadioGroup,
  Select,
  Stack,
  Switch,
  TextField
} from "@mui/material";
import MaskedInput from "./MaskedInput";

interface Props {
  formData: any;
  handleChange: (e: any) => void;
  handleSubmit: (e: any) => void;
}

const AddUserForm = ({ formData, handleChange, handleSubmit }: Props) => {
  return (
    <Grid
      container
      columns={{ xs: 8, md: 12 }}
      component="form"
      spacing={2}
      onSubmit={handleSubmit}>
      <Grid item xs={4} md={6}>
        <TextField
          label="Nome"
          name="name"
          fullWidth
          value={formData.name}
          onChange={handleChange}
        />
      </Grid>
      <Grid item xs={4} md={6}>
        <TextField
          label="Email"
          name="email"
          fullWidth
          value={formData.email}
          onChange={handleChange}
        />
      </Grid>
      <Grid item xs={4} md={6}>
        <TextField
          label="Telefone"
          name="telephone"
          fullWidth
          value={formData.telephone}
          onChange={handleChange}
        />
      </Grid>
      <Grid item xs={4} md={6}>
        <MaskedInput
          mask="999.999.999-99"
          label="CPF"
          name="doc"
          value={formData.doc}
          handleChange={handleChange}
        />
      </Grid>
      <Grid item xs={4} md={6}>
        <TextField
          label="Senha"
          name="password"
          fullWidth
          type="password"
          value={formData.password}
          onChange={handleChange}
        />
      </Grid>
      <Grid item xs={4} md={6}>
        <FormControl>
          <FormLabel id="role">Função</FormLabel>
          <RadioGroup
            row
            aria-labelledby="role"
            name="role"
            value={formData.role}
            onChange={handleChange}>
            <FormControlLabel value="ADMIN" control={<Radio />} label="Administrador" />
            <FormControlLabel value="VENDEDOR" control={<Radio />} label="Vendedor" />
            <FormControlLabel value="USUÁRIO" control={<Radio />} label="Usuário" />
          </RadioGroup>
        </FormControl>
      </Grid>
      <Grid item xs={12} sx={{ mt: 3 }}>
        <Button variant="contained" fullWidth type="submit" size="large">
          Adicionar
        </Button>
      </Grid>
    </Grid>
  );
};

export default AddUserForm;
