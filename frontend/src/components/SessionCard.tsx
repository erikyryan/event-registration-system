import React from "react";
import { Box, Button, Card, CardContent, Grid, IconButton, Typography } from "@mui/material";
import ArrowForwardIosIcon from "@mui/icons-material/ArrowForwardIos";
import styled from "@emotion/styled";
import { Link } from "react-router-dom";

const CardWrapper = styled(Card)(({ theme }) => ({
  boxShadow: theme.shadows[20],
  color: theme.palette.secondary.contrastText,
  backgroundColor: theme.palette.secondary.main
}));

interface Props {
  day: string;
  hour: string;
}

const SessionCard = ({ day, hour }: Props) => {
  return (
    <Grid item xs={2} sm={4} md={4}>
      <Link to="/session" style={{ textDecoration: "none", maxWidth: 250 }}>
        <CardWrapper>
          <CardContent sx={{ display: "flex", justifyContent: "space-between" }}>
            <Box>
              <Typography variant="h5" sx={{ fontWeight: "bold" }}>
                {day}
              </Typography>
              <Typography variant="body1">às {hour}</Typography>
            </Box>
            <IconButton size="large" sx={{ color: "white" }}>
              <ArrowForwardIosIcon />
            </IconButton>
          </CardContent>
        </CardWrapper>
      </Link>
    </Grid>
  );
};

export default SessionCard;
