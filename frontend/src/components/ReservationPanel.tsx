import { useState } from "react";
import { Box, Divider, Stack, Typography } from "@mui/material";
import FinalPrice from "./FinalPrice";
import PaymentModal from "./PaymentModal";
import ReserveForm from "./ReserveForm";
import SeatsCaption from "./SeatsCaption";
import SeatsPicker from "./SeatsPicker";

interface Seat {
  number: number;
  user?: number | null | undefined;
  selected?: boolean;
}

interface SelectedSeat {
  number: number;
  type: string;
}

const ReservationPanel = () => {
  const [selected, setSelected] = useState<SelectedSeat[]>([]);
  const [seatingChart, setSeatingChart] = useState<Seat[][]>([
    [
      { number: 1, user: null },
      { number: 2, user: 1 },
      { number: 3, user: 1 },
      { number: 4, user: 1 },
      { number: 5, user: null },
      { number: 6, user: null },
      { number: 7, user: null },
      { number: 8, user: null },
      { number: 9, user: null },
      { number: 10, user: null }
    ],
    [
      { number: 11, user: null },
      { number: 12, user: null },
      { number: 13, user: null },
      { number: 14, user: null },
      { number: 15, user: null },
      { number: 16, user: null },
      { number: 17, user: null },
      { number: 18, user: null },
      { number: 19, user: null },
      { number: 20, user: null }
    ],
    [
      { number: 21, user: null },
      { number: 22, user: null },
      { number: 23, user: null },
      { number: 24, user: null },
      { number: 25, user: null },
      { number: 26, user: null },
      { number: 27, user: null },
      { number: 28, user: null },
      { number: 29, user: null },
      { number: 30, user: null }
    ]
  ]);

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
        <FinalPrice selected={selected} />
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
            seats={seatingChart}
          />
        </Box>
      </Box>
    </Box>
  );
};

export default ReservationPanel;
