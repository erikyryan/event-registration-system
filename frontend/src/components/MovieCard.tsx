import { Button, Card, CardActions, CardContent, Typography } from "@mui/material";
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
      </CardContent>
      <CardActions>
        <Button
          size="small"
          component={Link}
          endIcon={<ArrowForwardIcon />}
          to="/event"
          variant="outlined"
          color="primary">
          Ver sessões
        </Button>
      </CardActions>
    </Card>
  );
};

export default MovieCard;
