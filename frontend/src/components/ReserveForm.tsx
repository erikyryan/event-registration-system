import {
  Typography,
  Box,
  FormControl,
  FormLabel,
  RadioGroup,
  Radio,
  FormControlLabel
} from "@mui/material";
import { useState } from "react";
import Ticket from "./Ticket";

interface SelectedSeat {
  number: number;
  type: string;
}

interface Props {
  selected: SelectedSeat[];
  changeTicketType: (seatNumber: number) => void;
}

const ReserveForm = ({ selected, changeTicketType }: Props) => {
  return (
    <form>
      <Box>
        {selected.map((seat) => (
          <Ticket number={seat.number} changeTicketType={changeTicketType} />
        ))}
      </Box>
    </form>
  );
};

export default ReserveForm;
