import { useState } from "react";
import { Box } from "@mui/material";
import AddSessionForm from "../components/AddSessionForm";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import HeaderBackButton from "../components/HeaderBackButton";
import useToast from "../hooks/useToast";
import Toast from "../components/Toast";
import { useAuth } from "../contexts/AuthContext";
import api from "../services/api";

const AddSession = () => {
  const { token } = useAuth();
  const { toast, open, setOpen, toastProps } = useToast();
  const [formData, setFormData] = useState({
    sessionStartDate: "",
    sessionEndDate: "",
    eventIdentifier: "",
    ticketPrice: "",
    numberOfSeats: ""
  });

  const setEndDate = (value: string) => {
    setFormData((prev) => ({
      ...prev,
      sessionEndDate: value
    }));
  };

  const handleChange = (e: any) => {
    setFormData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value
    }));
  };

  const handleSubmit = async (e: any) => {
    e.preventDefault();
    console.log(formData);

    if (token) {
      try {
        const res = await api.post(
          "/session/create",
          {
            ...formData,
            ticketPrice: parseInt(formData.ticketPrice),
            numberOfSeats: parseInt(formData.numberOfSeats)
          },
          {
            headers: {
              token: token
            }
          }
        );
        console.log(res);
        toast("Sessão adicionada com sucesso!", "success");
      } catch (error) {
        console.log(error);
      }
    }
  };

  return (
    <DashboardLayout>
      <Toast toastProps={toastProps} open={open} setOpen={setOpen} />
      <HeaderBackButton
        title="Adicionar Sessão"
        backUrl="/sessions"
        backButtonText="Voltar para sessões"
      />
      <Box>
        <AddSessionForm
          formData={formData}
          handleChange={handleChange}
          handleSubmit={handleSubmit}
          setEndDate={setEndDate}
        />
      </Box>
    </DashboardLayout>
  );
};

export default AddSession;
