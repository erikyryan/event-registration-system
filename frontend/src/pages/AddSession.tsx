import { useState } from "react";
import { Box } from "@mui/material";
import AddSessionForm from "../components/AddSessionForm";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import HeaderBackButton from "../components/HeaderBackButton";
import useToast from "../hooks/useToast";
import Toast from "../components/Toast";

const AddSession = () => {
  const { toast, open, setOpen, toastProps } = useToast();
  const [formData, setFormData] = useState({
    sessionDate: "",
    place: "",
    event: "",
    ticketPrice: "",
    sessiosStatus: 0
  });

  const handleChange = (e: any) => {
    setFormData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value
    }));
  };

  const handleSubmit = (e: any) => {
    e.preventDefault();
    console.log(formData);
    toast("Sessão adicionada com sucesso!", "success");
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
        />
      </Box>
    </DashboardLayout>
  );
};

export default AddSession;
