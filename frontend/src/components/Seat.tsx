import React from "react";
import { Box, IconButton, Paper } from "@mui/material";
import WeekendIcon from "@mui/icons-material/Weekend";

interface Props {
  row: string;
  col: number;
  number: number;
  selected?: boolean;
  user?: number | null | boolean;
  select: (row: number) => void;
  cancel: (row: number) => void;
}

const Seat = ({ row, col, number, selected, user, select, cancel }: Props) => {
  const handleClick = () => {
    if (!user) {
      if (selected) {
        cancel(number);
      } else {
        select(number);
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
