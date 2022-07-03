import React from "react";
import { v4 as uuid } from "uuid";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import { Box, Typography, Button } from "@mui/material";
import UsersList from "../components/UsersList";

const Users = () => {
  return (
    <DashboardLayout>
      <Box
        sx={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
          width: "100%",
          mb: 3
        }}>
        <Typography variant="h4" sx={{ fontWeight: "bold" }}>
          Usuários
        </Typography>
        <Box>
          <Button variant="contained">Adicionar Usuário</Button>
        </Box>
      </Box>

      <UsersList users={users} />
    </DashboardLayout>
  );
};

export default Users;

const users = [
  {
    id: uuid(),
    name: "Ekaterina Tankova",
    email: "ekaterina.tankova@devias.io",
    doc: "999.999.999-99",
    birthDate: 1555016400000,
    phone: "304-428-3097",
    role: "USER"
  },
  {
    id: uuid(),
    doc: "999.999.999-99",
    birthDate: 1555016400000,
    email: "cao.yu@devias.io",
    name: "Cao Yu",
    phone: "712-351-5711",
    role: "FUNC"
  },
  {
    id: uuid(),
    doc: "999.999.999-99",
    birthDate: 1555016400000,
    email: "mateussdamiano@gmail.com",
    name: "Mateus Sousa",
    phone: "712-351-5711",
    role: "FUNC"
  },
  {
    id: uuid(),
    doc: "999.999.999-99",
    birthDate: 1555016400000,
    email: "cao.yu@devias.io",
    name: "Cao Yu",
    phone: "712-351-5711",
    role: "ADMIN"
  },
  {
    id: uuid(),
    doc: "999.999.999-99",
    birthDate: 1555016400000,
    email: "cao.yu@devias.io",
    name: "Cao Yu",
    phone: "712-351-5711",
    role: "USER"
  },
  {
    id: uuid(),
    doc: "999.999.999-99",
    birthDate: 1555016400000,
    email: "cao.yu@devias.io",
    name: "Cao Yu",
    phone: "712-351-5711",
    role: "USER"
  }
];
