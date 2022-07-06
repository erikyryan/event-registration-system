import React, { useState } from "react";
import { Box, Button, Grid, TextField, Typography, Snackbar } from "@mui/material";
import MuiAlert, { AlertProps } from "@mui/material/Alert";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import MaskedInput from "../components/MaskedInput";
import { useAuth } from "../contexts/AuthContext";
import api from "../services/api";
import EditPasswordForm from "../components/EditPasswordForm";

const Alert = React.forwardRef<HTMLDivElement, AlertProps>(function Alert(props, ref) {
  return <MuiAlert elevation={6} ref={ref} variant="filled" {...props} />;
});

const Profile = () => {
  const { currentUser, token } = useAuth();
  const [open, setOpen] = useState(false);
  const [data, setData] = useState({
    name: currentUser?.name || "",
    doc: currentUser?.doc || "",
    email: currentUser?.email || "",
    telephone: currentUser?.telephone || "",
    birthDate: new Date(currentUser?.birthDate).toISOString().split("T")[0] || ""
  });

  const handleClose = (event?: React.SyntheticEvent | Event, reason?: string) => {
    if (reason === "clickaway") {
      return;
    }

    setOpen(false);
  };

  const handleChange = (e: any) => {
    setData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value
    }));
  };

  const handleSubmit = async (e: any) => {
    e.preventDefault();

    if (token && currentUser?.userIdentifier) {
      try {
        const res = await api.post(
          "/user/edit",
          { ...data },
          {
            headers: {
              token: token,
              userIdentifier: currentUser?.userIdentifier
            }
          }
        );
        setOpen(true);
        console.log(res);
      } catch (error) {
        console.log(error);
      }
    }
  };

  return (
    <DashboardLayout>
      <Snackbar
        open={open}
        autoHideDuration={6000}
        onClose={handleClose}
        anchorOrigin={{ vertical: "top", horizontal: "center" }}>
        <Alert onClose={handleClose} severity="success" sx={{ width: "100%" }}>
          Perfil alterado com sucesso!
        </Alert>
      </Snackbar>
      <Box
        sx={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          flexDirection: "column"
        }}>
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
                label="Email"
                name="email"
                type="email"
                fullWidth
                value={data.email}
                onChange={handleChange}
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
          <Button
            variant="contained"
            color="primary"
            sx={{ mt: 2 }}
            fullWidth
            onClick={handleSubmit}>
            Salvar
          </Button>
        </Box>
        <EditPasswordForm />
      </Box>
    </DashboardLayout>
  );
};

export default Profile;
