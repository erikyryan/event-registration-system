import { Box, Divider, Grid, Stack, Typography } from "@mui/material";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import MovieInfo from "../components/MovieInfo";
import SessionCard from "../components/SessionCard";
import api from "../services/api";

const Movie = () => {
  const { id } = useParams();
  const [movie, setMovie] = useState(null);

  const fetchMovie = async () => {
    const res = await api.get(`/event/public/${id}`);
    setMovie(res.data);
  };

  useEffect(() => {
    fetchMovie();
  }, []);

  return (
    <DashboardLayout>
      <MovieInfo movie={movie} />
      <Typography variant="h5" sx={{ mt: 4, mb: 2, fontWeight: "bold" }}>
        Sessões disponíveis
      </Typography>
      <Grid container spacing={{ xs: 2, md: 3 }} columns={{ xs: 4, sm: 8, md: 12 }}>
        <SessionCard day={"13 de Julho"} hour={"14:30"} />
        <SessionCard day={"13 de Julho"} hour={"15:45"} />
        <SessionCard day={"13 de Julho"} hour={"17:30"} />
        <SessionCard day={"14 de Julho"} hour={"14:30"} />
        <SessionCard day={"14 de Julho"} hour={"15:45"} />
      </Grid>
    </DashboardLayout>
  );
};

export default Movie;
