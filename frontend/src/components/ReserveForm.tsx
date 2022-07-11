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
  ticketIdentifier: string;
  nameUser: string;
  sex: string;
  doc: string;
  price: number;
  seat: number;
  type: string;
}

interface Props {
  selected: SelectedSeat[];
  changeTicketType: (ticketIdentifier: string) => void;
}

const ReserveForm = ({ selected, changeTicketType }: Props) => {
  return (
    <form>
      <Box>
        {selected.map((seat) => (
          <Ticket
            ticketIdentifier={seat.ticketIdentifier}
            seat={seat.seat}
            changeTicketType={changeTicketType}
            key={seat.ticketIdentifier}
          />
        ))}
      </Box>
    </form>
  );
};

export default ReserveForm;
