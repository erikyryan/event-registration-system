import { Box, Typography } from "@mui/material";

interface SelectedSeat {
  number: number;
  type: string;
}

interface Props {
  selected: SelectedSeat[];
  ticketPrice: number;
}

const FinalPrice = ({ selected, ticketPrice }: Props) => {
  const finalPrice = selected.reduce((prev, curr) => {
    if (curr.type === "meia") return prev + ticketPrice / 2;
    else return prev + ticketPrice;
  }, 0);

  return (
    <Box sx={{ display: "flex", justifyContent: "space-between" }}>
      <Typography variant="h6">Total</Typography>
      <Typography variant="h6">R${finalPrice},00</Typography>
    </Box>
  );
};

export default FinalPrice;
