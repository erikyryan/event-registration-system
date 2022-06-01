import { Container } from "@mui/material";
import React from "react";
import Navbar from "./Navbar";

const PageContainer = ({ children }: { children: React.ReactNode }) => {
  return (
    <>
      <Navbar />
      <Container sx={{ marginTop: 10 }}>{children}</Container>
    </>
  );
};

export default PageContainer;
