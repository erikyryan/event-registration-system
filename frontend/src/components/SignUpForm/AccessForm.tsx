import React from "react";
import { Stack, TextField } from "@mui/material";
import FormProps from "./formTypes";

const AccessForm = ({ data, handleChange }: FormProps) => {
  return (
    <Stack spacing={2}>
      <TextField
        name="login"
        label="Login"
        fullWidth
        size="small"
        value={data.login}
        onChange={handleChange}
      />
      <TextField
        name="senha"
        label="Senha"
        fullWidth
        size="small"
        type="password"
        value={data.senha}
        onChange={handleChange}
      />
      <TextField
        name="confirm"
        label="Confirm"
        fullWidth
        size="small"
        type="password"
        value={data.confirm}
        onChange={handleChange}
      />
    </Stack>
  );
};

export default AccessForm;
