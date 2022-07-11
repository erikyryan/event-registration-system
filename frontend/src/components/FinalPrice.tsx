import { Box, Typography } from "@mui/material";
import { ISelectedSeat } from "../types/ISeat";
import getTotalPrice from "../utils/getTotalPrice";

interface Props {
  selected?: ISelectedSeat[];
}

const FinalPrice = ({ selected }: Props) => {
  const finalPrice = getTotalPrice(selected);

  return (
    <Box sx={{ display: "flex", justifyContent: "space-between", width: "100%" }}>
      <Typography variant="h6">Total</Typography>
      <Typography variant="h6">R${finalPrice},00</Typography>
    </Box>
  );
};

export default FinalPrice;
