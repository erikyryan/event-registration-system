import { useState } from "react";
import { Box, Button, Grid, TextField, Typography } from "@mui/material";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import MaskedInput from "../components/MaskedInput";
import { useAuth } from "../contexts/AuthContext";

const Profile = () => {
  const { currentUser } = useAuth();
  const [data, setData] = useState({
    name: currentUser?.name || "",
    email: currentUser?.email || "",
    login: currentUser?.login || "",
    doc: currentUser?.doc || "",
    telephone: currentUser?.phone || "",
    birthDate: currentUser?.birthDate || ""
  });

  const handleChange = (e: any) => {
    setData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value
    }));
  };

  const handleSubmit = (e: any) => {
    e.preventDefault();
    console.log(data);
  };

  return (
    <DashboardLayout>
      <Typography variant="h4" sx={{ fontWeight: "bold", mb: 3 }}>
        Perfil
      </Typography>
      <Box sx={{ maxWidth: 600 }}>
        <Grid container columns={{ xs: 4 }} spacing={2}>
          <Grid item xs={2}>
            <TextField
              label="Nome"
              name="name"
              fullWidth
              value={data.name}
              onChange={handleChange}
            />
          </Grid>
          <Grid item xs={2}>
            <TextField
              label="Email"
              name="email"
              fullWidth
              value={data.email}
              onChange={handleChange}
            />
          </Grid>
          <Grid item xs={2}>
            <TextField
              label="Login"
              name="login"
              fullWidth
              value={data.login}
              onChange={handleChange}
            />
          </Grid>
          <Grid item xs={2}>
            <MaskedInput
              label="CPF"
              name="doc"
              mask="999.999.999-99"
              value={data.doc}
              handleChange={handleChange}
            />
          </Grid>
          <Grid item xs={2}>
            <TextField
              label="Telefone"
              name="telephone"
              fullWidth
              value={data.telephone}
              onChange={handleChange}
            />
          </Grid>
          <Grid item xs={2}>
            <TextField
              label="Data de nascimento"
              name="birthDate"
              fullWidth
              type="date"
              InputLabelProps={{ shrink: true }}
              value={data.birthDate}
              onChange={handleChange}
            />
          </Grid>
        </Grid>
        <Button variant="contained" color="primary" sx={{ mt: 2 }} fullWidth onClick={handleSubmit}>
          Salvar
        </Button>
      </Box>
    </DashboardLayout>
  );
};

export default Profile;
