import { useEffect, useState } from "react";
import { Typography, Box, FormControl, RadioGroup, Radio, FormControlLabel } from "@mui/material";

interface Props {
  number: number;
  changeTicketType: (seatNumber: number) => void;
}

const Ticket = ({ number, changeTicketType }: Props) => {
  const [value, setValue] = useState("inteira");

  useEffect(() => {
    changeTicketType(number);
  }, [value]);

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setValue((event.target as HTMLInputElement).value);
  };

  return (
    <Box sx={{ display: "flex", gap: 2, alignItems: "center" }}>
      <Typography variant="h6">Assento #{number}</Typography>
      <FormControl>
        <RadioGroup row value={value} onChange={handleChange}>
          <FormControlLabel value="inteira" control={<Radio size="small" />} label="Inteira" />
          <FormControlLabel value="meia" control={<Radio size="small" />} label="Meia" />
        </RadioGroup>
      </FormControl>
    </Box>
  );
};

export default Ticket;
