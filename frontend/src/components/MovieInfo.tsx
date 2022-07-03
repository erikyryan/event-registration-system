import React from "react";
import { Box, Typography } from "@mui/material";
import AccessTimeFilledIcon from "@mui/icons-material/AccessTimeFilled";

const MovieInfo = () => {
  return (
    <Box>
      <Typography variant="h4" sx={{ fontWeight: "bold" }}>
        The Lion King (2020)
      </Typography>
      <Box sx={{ my: 3 }}>
        <Typography sx={{ display: "flex" }}>
          <AccessTimeFilledIcon /> 1h 40min
        </Typography>
      </Box>
      <Typography variant="body1">
        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Magnam eos cupiditate similique
        tempore. Laboriosam eos consequatur magnam voluptas, delectus numquam itaque ad, repellat
        vitae ipsa sunt explicabo ea recusandae aliquid! Lorem ipsum dolor sit amet consectetur
        adipisicing elit. Asperiores itaque veritatis accusantium. Voluptatibus nihil dolor tempore?
        Necessitatibus quae rem eum iusto at, debitis nihil? Cupiditate temporibus tempore officia
        fugit velit!
      </Typography>
    </Box>
  );
};

export default MovieInfo;
