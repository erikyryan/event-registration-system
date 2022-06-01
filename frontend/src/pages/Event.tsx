import { useState } from "react";
import { Typography } from "@mui/material";
import PageContainer from "../components/PageContainer";
import ReserveForm from "../components/ReserveForm";
import SeatsPicker from "../components/SeatsPicker";

interface Seat {
  number: number;
  user?: number | null | undefined;
  selected?: boolean;
}

const Event = () => {
  const [selected, setSelected] = useState<number[]>([]);
  const [seatingChart, setSeatingChart] = useState<Seat[][]>([
    [
      { number: 1, user: null },
      { number: 2, user: 1 },
      { number: 3, user: null },
      { number: 4, user: null },
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
    setSelected((prev) => [...prev, seatNumber]);
  };

  const cancelSelection = (seatNumber: number): void => {
    const newSelected = selected.filter((num) => num !== seatNumber);
    setSelected(newSelected);
  };

  return (
    <PageContainer>
      <Typography variant="h3">The Lion King</Typography>
      <SeatsPicker
        selectSeat={selectSeat}
        cancelSelection={cancelSelection}
        selected={selected}
        seats={seatingChart}
      />
      <ReserveForm selected={selected} />
    </PageContainer>
  );
};

export default Event;
