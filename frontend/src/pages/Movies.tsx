import { useEffect, useState } from "react";
import { Box, Button, Grid, Typography } from "@mui/material";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import MovieCard from "../components/MovieCard";
import { Link } from "react-router-dom";
import api from "../services/api";

const Movies = () => {
  const [movies, setMovies] = useState([]);

  const fetchMovies = async () => {
    const res = await api.get("/event/available");
    setMovies(res.data);
  };

  useEffect(() => {
    fetchMovies();
  }, []);

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
        {movies.map((movie, index) => (
          <Grid item xs={4} sm={4} md={6} key={index}>
            <MovieCard movie={movie} />
          </Grid>
        ))}
      </Grid>
    </DashboardLayout>
  );
};

export default Movies;

const events = [
  {
    name: "The Lion King",
    synopsis:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    name: "Funny Games",
    synopsis:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    name: "Fight Club",
    synopsis:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    name: "Split",
    synopsis:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    name: "Moana",
    synopsis:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    name: "Soul",
    synopsis:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  }
];
