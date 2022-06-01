import { Button, Card, CardActions, CardContent, Typography } from "@mui/material";
import { Link } from "react-router-dom";

interface Props {
  event: {
    title: string;
    description: string;
  };
}

const MovieCard = ({ event }: Props) => {
  return (
    <Card sx={{ marginBottom: 2 }}>
      <CardContent>
        <Typography variant="h5">{event.title}</Typography>
        <Typography variant="body2">{event.description}</Typography>
      </CardContent>
      <CardActions>
        <Button size="small" component={Link} to="/event">
          View Details
        </Button>
      </CardActions>
    </Card>
  );
};

export default MovieCard;
