import { IconButton } from "@mui/material";
import WeekendIcon from "@mui/icons-material/Weekend";
import toggleSeatOcupation from "../utils/toggleSeatOcupation";
import { useAuth } from "../contexts/AuthContext";

interface Props {
  ticketIdentifier: string;
  selected?: boolean;
  occupied?: boolean;
  seat: number;
  select: (ticketIdentifier: string, seat: number) => void;
  cancel: (ticketIdentifier: string) => void;
}

const Seat = ({ ticketIdentifier, selected, occupied, select, seat, cancel }: Props) => {
  const { token } = useAuth();
  const handleClick = () => {
    if ((!occupied || selected) && token) {
      if (selected) {
        cancel(ticketIdentifier);
      } else {
        select(ticketIdentifier, seat);
      }
      toggleSeatOcupation(ticketIdentifier, token);
    }
  };

  const color = occupied && !selected ? "gray" : selected ? "#B27B16" : "#10B981";

  return (
    <IconButton
      onClick={handleClick}
      sx={{
        color: color,
        cursor: occupied && !selected ? "default" : "pointer",
        fontSize: "45px"
      }}>
      <WeekendIcon fontSize="inherit" />
    </IconButton>
  );
};

export default Seat;
