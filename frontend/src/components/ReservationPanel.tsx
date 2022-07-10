import { useState } from "react";
import { Box, Divider, Stack, Typography } from "@mui/material";
import FinalPrice from "./FinalPrice";
import PaymentModal from "./PaymentModal";
import ReserveForm from "./ReserveForm";
import SeatsCaption from "./SeatsCaption";
import SeatsPicker from "./SeatsPicker";
import getSeatsMapping from "../utils/getSeatsMapping";

interface Props {
  seats: {
    occupiedSeat: boolean;
    seat: number;
  }[];
  ticketPrice: number;
}

interface SelectedSeat {
  number: number;
  type: string;
}

const ReservationPanel = ({ seats, ticketPrice }: Props) => {
  const [selected, setSelected] = useState<SelectedSeat[]>([]);
  const seatsMapping = getSeatsMapping(seats);

  const selectSeat = (seatNumber: number): void => {
    const newSelected = {
      number: seatNumber,
      type: "inteira"
    };
    setSelected((prev) => [...prev, newSelected]);
  };

  const changeTicketType = (seatNumber: number): void => {
    const newArr = selected.map((seat) => {
      if (seat.number === seatNumber) {
        if (seat.type === "inteira") seat.type = "meia";
        else seat.type = "inteira";
      }
      return seat;
    });
    setSelected(newArr);
  };

  const cancelSelection = (seatNumber: number): void => {
    const newSelected = selected.filter((seat) => seat.number !== seatNumber);
    setSelected(newSelected);
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
        <FinalPrice selected={selected} ticketPrice={ticketPrice} />
        <PaymentModal selected={selected} />
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
