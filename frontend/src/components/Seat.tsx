import React from "react";
import { Box, Paper } from "@mui/material";

interface Props {
  row: string;
  col: number;
  number: number;
  selected?: boolean;
  user?: number | null;
  select: (row: number) => void;
  cancel: (row: number) => void;
}

const Seat = ({ row, col, number, selected, user, select, cancel }: Props) => {
  const handleClick = () => {
    if (user === null) {
      if (selected) {
        cancel(number);
      } else {
        select(number);
      }
    }
  };

  const color = user ? "gray" : selected ? "blue" : "green";

  return (
    <Paper
      onClick={handleClick}
      sx={{
        backgroundColor: color,
        width: "40px",
        textAlign: "center",
        padding: "8px",
        margin: "4px",
        cursor: user ? "default" : "pointer",
        color: "white",
        borderRadius: "9000px"
      }}>
      {number}
    </Paper>
  );
};

export default Seat;
