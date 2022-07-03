import { Link, useNavigate } from "react-router-dom";
import { AppBar, Button, Container, Toolbar, Typography, Box } from "@mui/material";
import { useAuth } from "../contexts/AuthContext";

const Navbar = () => {
  const { currentUser, logout } = useAuth();
  const navigate = useNavigate();

  const handleLogout = async () => {
    logout();
    navigate("/login");
  };

  return (
    <AppBar sx={{ backgroundColor: "#f1f1f1" }}>
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <Typography
            variant="h5"
            noWrap
            sx={{ marginRight: "auto", color: "#000", textDecoration: "none" }}
            component={Link}
            to="/">
            Sigev
          </Typography>
          <Box>
            {!currentUser ? (
              <>
                <Button variant="contained" component={Link} to="/login">
                  Entrar
                </Button>
                <Button variant="outlined" component={Link} to="/signup" sx={{ marginLeft: 2 }}>
                  Cadastrar-se
                </Button>
              </>
            ) : (
              <Button variant="contained" color="error" onClick={handleLogout}>
                Sair
              </Button>
            )}
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
};

export default Navbar;
