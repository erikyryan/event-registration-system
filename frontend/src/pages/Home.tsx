import React from "react";
import { Button, Card, CardActions, CardContent, Typography } from "@mui/material";
import PageContainer from "../components/PageContainer";
import { Link } from "react-router-dom";
import MovieCard from "../components/MovieCard";

const Home = () => {
  return (
    <PageContainer>
      <Typography variant="h3">Events</Typography>
      {events.map((event) => (
        <MovieCard event={event} />
      ))}
    </PageContainer>
  );
};

export default Home;

const events = [
  {
    title: "The Lion King",
    description: "Movie description synopsis test omfg yeah an yeah"
  },
  {
    title: "The Lion King",
    description: "Movie description synopsis test omfg yeah an yeah"
  },
  {
    title: "The Lion King",
    description: "Movie description synopsis test omfg yeah an yeah"
  },
  {
    title: "The Lion King",
    description: "Movie description synopsis test omfg yeah an yeah"
  },
  {
    title: "The Lion King",
    description: "Movie description synopsis test omfg yeah an yeah"
  },
  {
    title: "The Lion King",
    description: "Movie description synopsis test omfg yeah an yeah"
  }
];
