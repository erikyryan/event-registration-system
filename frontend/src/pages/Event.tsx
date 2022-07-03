import { useState } from "react";
import { Stack, Typography } from "@mui/material";
import PageContainer from "../components/PageContainer";
import ReserveForm from "../components/ReserveForm";
import SeatsPicker from "../components/SeatsPicker";
import { Box } from "@mui/system";
import FinalPrice from "../components/FinalPrice";
import PaymentModal from "../components/PaymentModal";

interface Seat {
  number: number;
  user?: number | null | undefined;
  selected?: boolean;
}

interface SelectedSeat {
  number: number;
  type: string;
}

const Event = () => {
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
    <PageContainer>
      <Typography variant="h3" align="center" sx={{ mb: 2 }}>
        The Lion King
      </Typography>
      <Typography variant="body1">
        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Magnam eos cupiditate similique
        tempore. Laboriosam eos consequatur magnam voluptas, delectus numquam itaque ad, repellat
        vitae ipsa sunt explicabo ea recusandae aliquid! Lorem ipsum dolor sit amet consectetur
        adipisicing elit. Asperiores itaque veritatis accusantium. Voluptatibus nihil dolor tempore?
        Necessitatibus quae rem eum iusto at, debitis nihil? Cupiditate temporibus tempore officia
        fugit velit!
      </Typography>
      <Typography sx={{ mt: 4, display: "flex" }}>
        <span style={{ fontWeight: "bold", marginRight: 1 }}>Duração:</span> 1h40min
      </Typography>
      <Box sx={{ display: "flex", justifyContent: "space-between", mt: 5, flexWrap: "wrap" }}>
        <Stack spacing={2}>
          <FinalPrice selected={selected} />
          <ReserveForm selected={selected} changeTicketType={changeTicketType} />
        </Stack>
        <SeatsPicker
          selectSeat={selectSeat}
          cancelSelection={cancelSelection}
          selected={selected}
          seats={seatingChart}
        />
      </Box>
      <PaymentModal selected={selected} />
    </PageContainer>
  );
};

export default Event;
