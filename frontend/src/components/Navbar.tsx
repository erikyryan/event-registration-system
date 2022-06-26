import { Link } from "react-router-dom";
import { AppBar, Button, Container, Toolbar, Typography, Box } from "@mui/material";

const Navbar = () => {
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
            <Button variant="contained" component={Link} to="/login">
              Entrar
            </Button>
            <Button variant="outlined" component={Link} to="/signup" sx={{ marginLeft: 2 }}>
              Cadastrar-se
            </Button>
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
};

export default Navbar;
