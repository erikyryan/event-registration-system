import React from "react";
import { Button } from "@mui/material";
import DashboardLayout from "../components/Dashboard/DashboardLayout";
import PageHeader from "../components/PageHeader";

const Dashboard = () => {
  return (
    <DashboardLayout>
      <PageHeader title="Dashboard" />
    </DashboardLayout>
  );
};

export default Dashboard;
