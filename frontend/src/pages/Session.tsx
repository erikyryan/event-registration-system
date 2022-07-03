import { Typography } from "@mui/material";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import ReservationPanel from "../components/ReservationPanel";

const Session = () => {
  return (
    <DashboardLayout>
      <Typography variant="h4" sx={{ fontWeight: "bold", mb: 3 }}>
        Reservar para The Lion King
      </Typography>
      <Typography variant="h5" sx={{ mb: 5 }}>
        Sessão dia 13 de Julho às 14:30
      </Typography>
      <ReservationPanel />
    </DashboardLayout>
  );
};

export default Session;
