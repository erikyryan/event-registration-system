import React from "react";
import { Stack, TextField } from "@mui/material";
import FormProps from "./formTypes";

const PersonalForm = ({ data, handleChange }: FormProps) => {
  return (
    <Stack spacing={2}>
      <TextField
        name="nome"
        label="Nome"
        fullWidth
        size="small"
        value={data.nome}
        onChange={handleChange}
      />
      <TextField
        name="cpf"
        label="CPF"
        fullWidth
        size="small"
        value={data.cpf}
        onChange={handleChange}
      />
      <TextField
        name="datanascimento"
        label="Data Nascimento"
        type="date"
        fullWidth
        size="small"
        InputLabelProps={{ shrink: true }}
        value={data.datanascimento}
        onChange={handleChange}
      />
    </Stack>
  );
};

export default PersonalForm;
