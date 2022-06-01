import { Container, Grid, Box } from "@mui/material";
import Seat from "./Seat";

interface Seat {
  number: number;
  user?: number | null | undefined;
  selected?: boolean;
}

interface Props {
  selectSeat: (number: number) => void;
  cancelSelection: (number: number) => void;
  selected: number[];
  seats: Seat[][];
}

const SeatsPicker = ({ selectSeat, cancelSelection, selected, seats }: Props) => {
  return (
    <Box sx={{ margin: "30px 0" }}>
      {seats.map((row, index) => (
        <div
          style={{
            display: "flex"
          }}>
          <h1 style={{ lineHeight: "30px", marginRight: "20px" }}>{alphabet[index]}</h1>
          <div
            style={{
              display: "flex",
              justifyContent: "center",
              alignItems: "center"
            }}
            key={index}>
            {row.map((seat, seatNum) => (
              <Seat
                key={seatNum + seat.number + index}
                row={alphabet[index]}
                col={seatNum}
                number={seat.number}
                selected={selected.includes(seat.number)}
                user={seat.user}
                select={selectSeat}
                cancel={cancelSelection}
              />
            ))}
          </div>
        </div>
      ))}
    </Box>
  );
};

export default SeatsPicker;

const letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
const alphabet = letters.split("");
