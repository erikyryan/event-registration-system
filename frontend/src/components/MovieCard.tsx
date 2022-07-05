import { Button, Card, CardContent, Typography } from "@mui/material";
import { Link } from "react-router-dom";
import ArrowForwardIcon from "@mui/icons-material/ArrowForward";
import { IMovie } from "../types/IMovie";

interface Props {
  movie: IMovie;
}

const MovieCard = ({ movie }: Props) => {
  return (
    <Card sx={{ mb: 2 }}>
      <CardContent>
        <Typography variant="h5" align="center">
          {movie.name} ({movie.launchYear})
        </Typography>
        <Typography variant="body2" sx={{ marginTop: 2 }}>
          {movie.synopsis}
        </Typography>
        <Button
          size="small"
          component={Link}
          endIcon={<ArrowForwardIcon />}
          to={`/filmes/${movie.id}`}
          variant="outlined"
          color="primary"
          sx={{ mt: 2 }}>
          Ver sessões
        </Button>
      </CardContent>
    </Card>
  );
};

export default MovieCard;
