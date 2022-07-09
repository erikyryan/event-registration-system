import { useState } from "react";
import { Box } from "@mui/material";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import AddUserForm from "../components/AddUserForm";
import HeaderBackButton from "../components/HeaderBackButton";

const AddUser = () => {
  const [formData, setFormData] = useState({
    name: "",
    doc: "",
    email: "",
    telephone: "",
    password: "",
    role: "VENDEDOR"
  });

  const handleChange = (e: any) => {
    setFormData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value
    }));
  };

  const handleSubmit = async (e: any) => {
    e.preventDefault();
    console.log(formData);
  };

  return (
    <DashboardLayout>
      <HeaderBackButton
        title="Adicionar Usuário"
        backUrl="/users"
        backButtonText="Voltar para usuários"
      />
      <Box>
        <AddUserForm formData={formData} handleChange={handleChange} handleSubmit={handleSubmit} />
      </Box>
    </DashboardLayout>
  );
};

export default AddUser;
