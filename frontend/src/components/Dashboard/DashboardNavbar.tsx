import { useAuth } from "../../contexts/AuthContext";
import { Link } from "react-router-dom";
import { AppBar, Box, Button, IconButton, Stack, Toolbar } from "@mui/material";
import MenuIcon from "@mui/icons-material/Menu";
import LogoutIcon from "@mui/icons-material/Logout";
import styled from "@emotion/styled";

interface Props {
  onSidebarOpen: () => void;
}

const DashboardNavbarRoot = styled(AppBar)(({ theme }) => ({
  backgroundColor: theme.palette.background.paper,
  boxShadow: theme.shadows[20]
}));

const DashboardNavbar = ({ onSidebarOpen, ...other }: Props) => {
  const { currentUser } = useAuth();

  return (
    <>
      <DashboardNavbarRoot
        sx={{
          left: {
            lg: 280
          },
          width: {
            lg: "calc(100% - 280px)"
          }
        }}
        {...other}>
        <Toolbar
          disableGutters
          sx={{
            minHeight: 64,
            left: 0,
            px: 2
          }}>
          <IconButton
            onClick={onSidebarOpen}
            sx={{
              display: {
                xs: "inline-flex",
                lg: "none"
              }
            }}>
            <MenuIcon fontSize="small" />
          </IconButton>
          <Box sx={{ flexGrow: 1 }} />

          {currentUser ? (
            <Button variant="contained" color="error" fullWidth endIcon={<LogoutIcon />}>
              Sair
            </Button>
          ) : (
            <Stack direction="row" spacing={2}>
              <Button variant="contained" component={Link} to="/login" color="secondary">
                Entrar
              </Button>
              <Button variant="outlined" component={Link} to="/signup" color="secondary">
                Cadastrar-se
              </Button>
            </Stack>
          )}
        </Toolbar>
      </DashboardNavbarRoot>
    </>
  );
};

export default DashboardNavbar;
