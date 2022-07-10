import { Typography } from "@mui/material";
import { useEffect, useState } from "react";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import ReservationPanel from "../components/ReservationPanel";
import { useAuth } from "../contexts/AuthContext";
import api from "../services/api";
import { ISession } from "../types/ISession";

const Session = () => {
  const { token, logout } = useAuth();
  const { id } = useParams();
  const navigate = useNavigate();
  const location = useLocation();
  const [seats, setSeats] = useState(null);
  const [session, setSession] = useState<ISession | null>(null);
  const sessionDate = session && new Date(session?.sessionStartDate);

  const fetchSeats = async () => {
    if (token && id) {
      try {
        const res = await api.get("/ticket/seats", {
          headers: {
            token: token,
            sessionidentifier: id
          }
        });
        setSeats(res.data);
      } catch (error: any) {
        const message = error.response.data.message;
        if (message === "Sessão expirou.") {
          await logout();
          navigate("/login", {
            state: {
              from: location
            },
            replace: true
          });
        }
      }
    }
  };

  const fetchSession = async () => {
    if (token && id) {
      try {
        const res = await api.get("/session/find", {
          headers: {
            token: token,
            identifier: id
          }
        });
        console.log(res.data);
        setSession(res.data);
      } catch (error: any) {
        const message = error.response.data.message;
        if (message === "Sessão expirou.") {
          await logout();
          navigate("/login");
        }
      }
    }
  };

  useEffect(() => {
    fetchSession();
    fetchSeats();
  }, []);

  if (!session && !seats) return <DashboardLayout>Loading...</DashboardLayout>;

  return (
    <DashboardLayout>
      <Typography variant="h4" sx={{ fontWeight: "bold", mb: 3 }}>
        Reservar para {session?.event.name}
      </Typography>
      <Typography variant="h5" sx={{ mb: 5 }}>
        Sessão dia {sessionDate?.getDate()} de {sessionDate && months[sessionDate?.getMonth() - 1]}{" "}
        às {sessionDate?.getHours()}:{sessionDate?.getMinutes()}
      </Typography>
      {session && seats && <ReservationPanel seats={seats} ticketPrice={session.ticketPrice} />}
    </DashboardLayout>
  );
};

export default Session;

const months = [
  "Janeiro",
  "Fevereiro",
  "Março",
  "Abril",
  "Maio",
  "Junho",
  "Julho",
  "Agosto",
  "Setembro",
  "Outubro",
  "Novembro",
  "Dezembro"
];
