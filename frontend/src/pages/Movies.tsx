import { Box, Button, Grid, Typography } from "@mui/material";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import MovieCard from "../components/MovieCard";
import { Link } from "react-router-dom";

const Movies = () => {
  return (
    <DashboardLayout>
      <Box sx={{ display: "flex", justifyContent: "space-between", mb: 3 }}>
        <Typography variant="h4" sx={{ fontWeight: "bold" }}>
          Filmes em cartaz
        </Typography>
        <Box>
          <Button variant="contained" component={Link} to="/filmes/adicionar">
            Adicionar Filme
          </Button>
        </Box>
      </Box>
      <Grid container spacing={{ xs: 2, md: 3 }} columns={{ xs: 4, sm: 8, md: 12 }}>
        {events.map((event, index) => (
          <Grid item xs={2} sm={4} md={4} key={index}>
            <MovieCard event={event} />
          </Grid>
        ))}
      </Grid>
    </DashboardLayout>
  );
};

export default Movies;

const events = [
  {
    title: "The Lion King",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    title: "Funny Games",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    title: "Fight Club",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    title: "Split",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    title: "Moana",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    title: "Soul",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  }
];
