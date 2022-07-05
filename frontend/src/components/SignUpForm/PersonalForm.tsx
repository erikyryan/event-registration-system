import React from "react";
import { Stack, TextField } from "@mui/material";
import FormProps from "./formTypes";
import MaskedInput from "../MaskedInput";

const PersonalForm = ({ data, handleChange }: FormProps) => {
  return (
    <Stack spacing={2}>
      <TextField name="name" label="Nome" fullWidth value={data.name} onChange={handleChange} />
      <MaskedInput
        label="CPF"
        name="doc"
        mask="999.999.999-99"
        value={data.doc}
        handleChange={handleChange}
      />
      <TextField
        name="birthDate"
        label="Data Nascimento"
        type="date"
        fullWidth
        InputLabelProps={{ shrink: true }}
        value={data.birthDate}
        onChange={handleChange}
      />
    </Stack>
  );
};

export default PersonalForm;
