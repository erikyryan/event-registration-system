import React from "react";
import { Button, Card, CardActions, CardContent, Typography } from "@mui/material";
import PageContainer from "../components/PageContainer";
import { Link } from "react-router-dom";
import MovieCard from "../components/MovieCard";
import { useAuth } from "../contexts/AuthContext";

const Home = () => {
  const { currentUser } = useAuth();

  console.log(currentUser);

  return (
    <PageContainer>
      {events.map((event, index) => (
        <MovieCard event={event} key={index} />
      ))}
    </PageContainer>
  );
};

export default Home;

const events = [
  {
    title: "The Lion King",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    title: "The Lion King",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    title: "The Lion King",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    title: "The Lion King",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    title: "The Lion King",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  },
  {
    title: "The Lion King",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate doloremque aliquid quidem sed est similique ullam minima tenetur cumque aut recusandae enim veniam voluptates voluptatum, error ratione ex saepe odio."
  }
];
