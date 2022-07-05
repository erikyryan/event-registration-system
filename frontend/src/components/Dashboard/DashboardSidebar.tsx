import { useEffect } from "react";
import { Box, Button, Divider, Drawer, Stack, Typography, useMediaQuery } from "@mui/material";
import NavItem from "../NavItem";
import BarChartIcon from "@mui/icons-material/BarChart";
import GroupIcon from "@mui/icons-material/Group";
import LocalActivityIcon from "@mui/icons-material/LocalActivity";
import InsertInvitationIcon from "@mui/icons-material/InsertInvitation";
import EventSeatIcon from "@mui/icons-material/EventSeat";
import LogoutIcon from "@mui/icons-material/Logout";
import PersonIcon from "@mui/icons-material/Person";
import { useAuth } from "../../contexts/AuthContext";
import { Link, useNavigate } from "react-router-dom";

interface Props {
  open: boolean;
  onClose: () => void;
}

const items = [
  {
    href: "/",
    icon: <BarChartIcon />,
    title: "Dashboard",
    role: "ADMIN"
  },
  {
    href: "/users",
    icon: <GroupIcon />,
    title: "Usuários",
    role: "ADMIN"
  },
  {
    href: "/filmes",
    icon: <LocalActivityIcon />,
    title: "Filmes"
  },
  {
    href: "/sessions",
    icon: <InsertInvitationIcon />,
    title: "Sessões",
    role: "ADMIN"
  },
  {
    href: "/rooms",
    icon: <EventSeatIcon />,
    title: "Salas",
    role: "ADMIN"
  },
  {
    href: "/perfil",
    icon: <PersonIcon />,
    title: "Perfil"
  }
];

const DashboardSidebar = ({ open, onClose }: Props) => {
  const { currentUser, logout } = useAuth();
  const navigate = useNavigate();

  const lgUp = useMediaQuery((theme: any) => theme.breakpoints.up("lg"), {
    defaultMatches: true,
    noSsr: false
  });

  const handleLogout = async () => {
    logout();
    navigate("/login");
  };

  useEffect(() => {
    if (open) {
      onClose?.();
    }
  }, []);

  const content = (
    <>
      <Box
        sx={{
          display: "flex",
          flexDirection: "column",
          height: "100%"
        }}>
        <Box sx={{ p: 3 }}>
          <Typography variant="h4">SIGEv</Typography>
        </Box>
        <Divider
          sx={{
            borderColor: "#2D3748",
            my: 3
          }}
        />
        <Box sx={{ flexGrow: 1 }}>
          {items.map((item) => (
            <NavItem key={item.title} icon={item.icon} href={item.href} title={item.title} />
          ))}
        </Box>
        <Divider
          sx={{
            borderColor: "#2D3748",
            my: 3
          }}
        />
        <Box sx={{ p: 2 }}>
          {currentUser ? (
            <Button
              variant="contained"
              color="error"
              fullWidth
              endIcon={<LogoutIcon />}
              onClick={handleLogout}>
              Sair
            </Button>
          ) : (
            <Stack spacing={2}>
              <Button variant="contained" component={Link} to="/login" color="secondary">
                Entrar
              </Button>
              <Button variant="outlined" component={Link} to="/signup" color="secondary">
                Cadastrar-se
              </Button>
            </Stack>
          )}
        </Box>
      </Box>
    </>
  );

  if (lgUp) {
    return (
      <Drawer
        anchor="left"
        open
        PaperProps={{
          sx: {
            backgroundColor: "neutral.900",
            color: "#FFFFFF",
            width: 280
          }
        }}
        variant="permanent">
        {content}
      </Drawer>
    );
  }

  return (
    <Drawer
      anchor="left"
      onClose={onClose}
      open={open}
      PaperProps={{
        sx: {
          backgroundColor: "neutral.900",
          color: "#FFFFFF",
          width: 280
        }
      }}
      sx={{ zIndex: (theme) => theme.zIndex.appBar + 100 }}
      variant="temporary">
      {content}
    </Drawer>
  );
};

export default DashboardSidebar;
