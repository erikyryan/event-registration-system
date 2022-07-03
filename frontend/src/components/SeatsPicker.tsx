import styled from "@emotion/styled";
import { Box, Typography } from "@mui/material";
import Seat from "./Seat";

interface Seat {
  number: number;
  user?: number | null | undefined;
  selected?: boolean;
}

interface SelectedSeat {
  number: number;
  type: string;
}

interface Props {
  selectSeat: (number: number) => void;
  cancelSelection: (number: number) => void;
  selected: SelectedSeat[];
  seats: Seat[][];
}

const CinemaScreen = styled("div")(({ theme }) => ({
  width: "100%",
  height: 70,
  backgroundColor: theme.palette.primary.light,
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
  color: theme.palette.primary.contrastText,
  fontWeight: "bold",
  fontSize: 25,
  boxShadow: theme.shadows[20],
  borderRadius: 2
}));

const SeatsPicker = ({ selectSeat, cancelSelection, selected, seats }: Props) => {
  return (
    <Box>
      {seats.map((row, index) => (
        <Box
          key={index}
          sx={{
            display: "flex",
            alignItems: "center"
          }}>
          <Typography variant="h6" sx={{ mr: 3 }}>
            {alphabet[index]}
          </Typography>
          <Box
            sx={{
              display: "flex",
              justifyContent: "center",
              alignItems: "center"
            }}>
            {row.map((seat, seatNum) => (
              <Seat
                key={seatNum + seat.number + index}
                row={alphabet[index]}
                col={seatNum}
                number={seat.number}
                selected={selected.some((s) => s.number === seat.number)}
                user={seat.user}
                select={selectSeat}
                cancel={cancelSelection}
              />
            ))}
          </Box>
        </Box>
      ))}
      <CinemaScreen>Tela</CinemaScreen>
    </Box>
  );
};

export default SeatsPicker;

const letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
const alphabet = letters.split("");
