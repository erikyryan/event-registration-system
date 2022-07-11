import React from "react";
import { Box, IconButton, Paper } from "@mui/material";
import WeekendIcon from "@mui/icons-material/Weekend";

interface Props {
  ticketIdentifier: string;
  selected?: boolean;
  user?: number | null | boolean;
  seat: number;
  select: (ticketIdentifier: string, seat: number) => void;
  cancel: (ticketIdentifier: string) => void;
}

const Seat = ({ ticketIdentifier, selected, user, select, seat, cancel }: Props) => {
  const handleClick = () => {
    if (!user) {
      if (selected) {
        cancel(ticketIdentifier);
      } else {
        select(ticketIdentifier, seat);
      }
    }
  };

  const color = user ? "gray" : selected ? "#B27B16" : "#10B981";

  return (
    <IconButton
      onClick={handleClick}
      sx={{
        color: color,
        cursor: user ? "default" : "pointer",
        fontSize: "45px"
      }}>
      <WeekendIcon fontSize="inherit" />
    </IconButton>
  );
};

export default Seat;
