import { useState } from "react";
import { Box } from "@mui/material";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import AddUserForm from "../components/AddUserForm";
import HeaderBackButton from "../components/HeaderBackButton";
import api from "../services/api";
import { useAuth } from "../contexts/AuthContext";
import { useNavigate } from "react-router-dom";

const AddUser = () => {
  const { token, logout } = useAuth();
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    name: "",
    doc: "",
    email: "",
    birthDate: "",
    telephone: "",
    password: "",
    role: 2,
    sex: "M"
  });

  const handleChange = (e: any) => {
    setFormData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value
    }));
  };

  const handleSubmit = async (e: any) => {
    e.preventDefault();
    if (token) {
      try {
        const res = await api.post(
          "/user/create/admin",
          { ...formData, role: parseInt(formData.role) },
          {
            headers: {
              token: token
            }
          }
        );
        console.log(res);
      } catch (error: any) {
        console.log(error);
        const message = error.response.data.message;
        if (message === "Sessão expirou.") {
          await logout();
          navigate("/login");
        }
      }
    }
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
