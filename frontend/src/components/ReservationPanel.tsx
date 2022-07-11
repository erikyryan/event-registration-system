import { useState } from "react";
import { Box, Divider, Stack, Typography } from "@mui/material";
import FinalPrice from "./FinalPrice";
import PaymentModal from "./PaymentModal";
import ReserveForm from "./ReserveForm";
import SeatsCaption from "./SeatsCaption";
import SeatsPicker from "./SeatsPicker";
import getSeatsMapping from "../utils/getSeatsMapping";
import { useAuth } from "../contexts/AuthContext";
import getTotalPrice from "../utils/getTotalPrice";
import api from "../services/api";

interface Props {
  seats: {
    ticketIdentifier: string;
    occupiedSeat: boolean;
    seat: number;
  }[];
  ticketPrice: number;
  eventIdentifier: string;
  sessionIdentifier: string;
}

interface SelectedSeat {
  ticketIdentifier: string;
  nameUser: string;
  sex: string;
  doc: string;
  price: number;
  seat: number;
  type: string;
}

const ReservationPanel = ({ seats, ticketPrice, eventIdentifier, sessionIdentifier }: Props) => {
  const { currentUser, token } = useAuth();
  const [selected, setSelected] = useState<SelectedSeat[]>([]);
  console.log(selected);
  const seatsMapping = getSeatsMapping(seats);

  const selectSeat = (ticketIdentifier: string, seat: number): void => {
    const newSelected = {
      ticketIdentifier,
      nameUser: currentUser?.name,
      sex: currentUser?.sex,
      doc: currentUser?.doc,
      price: 12,
      seat: seat,
      type: "inteira"
    };
    setSelected((prev) => [...prev, newSelected]);
  };

  const changeTicketType = (ticketIdentifier: string): void => {
    const newArr = selected.map((seat) => {
      if (seat.ticketIdentifier === ticketIdentifier) {
        if (seat.type === "inteira") {
          seat.type = "meia";
          seat.price = ticketPrice / 2;
        } else {
          seat.type = "inteira";
          seat.price = ticketPrice;
        }
      }
      return seat;
    });
    setSelected(newArr);
  };

  const cancelSelection = (ticketIdentifier: string): void => {
    const newSelected = selected.filter((seat) => seat.ticketIdentifier !== ticketIdentifier);
    setSelected(newSelected);
  };

  const handlePayment = async () => {
    const data = {
      userIdentifier: currentUser?.userIdentifier,
      doc: currentUser?.doc,
      sex: currentUser?.sex,
      seat: 1,
      price: getTotalPrice(selected),
      paymentForm: "Cartão",
      saleType: currentUser?.role === "VENDEDOR" ? 0 : 1,
      userName: currentUser?.name,
      docType: 1,
      ticketOperationList: selected.map((ticket) => ({
        ticketIdentifier: ticket.ticketIdentifier,
        nameUser: ticket?.nameUser,
        sex: ticket?.sex,
        doc: ticket?.doc,
        price: ticket.price
      }))
    };
    console.log(data);
    if (token && eventIdentifier && sessionIdentifier) {
      try {
        const res = await api.post("/sale", data, {
          headers: {
            token,
            eventidentifier: eventIdentifier,
            sessionidentifier: sessionIdentifier
          }
        });
        console.log(res);
      } catch (error) {
        console.log(error);
      }
    }
  };

  return (
    <Box
      sx={{ display: "flex", justifyContent: "space-between", mt: 5, flexWrap: "wrap", gap: 10 }}>
      <Stack spacing={2}>
        <Typography variant="h6" sx={{ fontWeight: "bold" }}>
          Seus assentos selecionados
        </Typography>
        <ReserveForm selected={selected} changeTicketType={changeTicketType} />
        <Divider
          sx={{
            borderColor: "#2D3748",
            my: 3
          }}
        />
        <FinalPrice selected={selected} />
        <PaymentModal selected={selected} handlePayment={handlePayment} />
      </Stack>
      <Box sx={{ flexGrow: 1 }}>
        <SeatsCaption />
        <Box sx={{ display: "flex" }}>
          <Box sx={{ flexGrow: 1 }} />
          <SeatsPicker
            selectSeat={selectSeat}
            cancelSelection={cancelSelection}
            selected={selected}
            seats={seatsMapping}
          />
        </Box>
      </Box>
    </Box>
  );
};

export default ReservationPanel;
