import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import api from "../services/api";
import { Box } from "@mui/material";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import AddEventForm from "../components/AddEventForm";
import HeaderBackButton from "../components/HeaderBackButton";

const AddEvent = () => {
  const { token, logout } = useAuth();
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    eventType: "FILME",
    name: "",
    synopsis: "",
    type: "",
    eventStartDate: "",
    eventEndDate: "",
    classification: 18,
    launchYear: "2022",
    movieType: 0,
    actors: "",
    period: 0,
    structure: 0,
    comedian: "",
    eventName: "",
    date: "",
    equipments: "",
    teachers: "",
    subject: "",
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
        const res = await api.post("/event/create", formData, {
          headers: {
            token: token
          }
        });
        navigate("/event");
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
        title="Adicionar Evento"
        backUrl="/event"
        backButtonText="Voltar para Eventos"
      />
      <Box>
        <AddEventForm formData={formData} handleChange={handleChange} handleSubmit={handleSubmit} />
      </Box>
    </DashboardLayout>
  );
};

export default AddEvent;
