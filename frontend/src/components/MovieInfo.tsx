import React from "react";
import { Box, Typography } from "@mui/material";
import AccessTimeFilledIcon from "@mui/icons-material/AccessTimeFilled";
import { IMovie } from "../types/IMovie";

interface Props {
  movie?: IMovie | null | undefined;
}

const MovieInfo = ({ movie }: Props) => {
  return (
    <Box>
      <Typography variant="h4" sx={{ fontWeight: "bold" }}>
        {movie?.name}
      </Typography>
      <Box sx={{ my: 3 }}>
        <Typography sx={{ display: "flex" }}>
          <AccessTimeFilledIcon /> {movie?.duration}
        </Typography>
      </Box>
      <Typography variant="body1">{movie?.synopsis}</Typography>
    </Box>
  );
};

export default MovieInfo;
