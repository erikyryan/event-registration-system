import { Button, Card, CardContent, Typography } from "@mui/material";
import { Link } from "react-router-dom";
import ArrowForwardIcon from "@mui/icons-material/ArrowForward";

interface Props {
  event: {
    title: string;
    description: string;
  };
}

const MovieCard = ({ event }: Props) => {
  return (
    <Card sx={{ mb: 2 }}>
      <CardContent>
        <Typography variant="h5" align="center">
          {event.title}
        </Typography>
        <Typography variant="body2" sx={{ marginTop: 2 }}>
          {event.description}
        </Typography>
        <Button
          size="small"
          component={Link}
          endIcon={<ArrowForwardIcon />}
          to="/filmes/filme"
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
