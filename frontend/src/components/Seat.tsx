import { IconButton } from "@mui/material";
import WeekendIcon from "@mui/icons-material/Weekend";

interface Props {
  ticketIdentifier: string;
  selected?: boolean;
  occupied?: boolean;
  seat: number;
  select: (ticketIdentifier: string, seat: number) => void;
  cancel: (ticketIdentifier: string) => void;
}

const Seat = ({ ticketIdentifier, selected, occupied, select, seat, cancel }: Props) => {
  const handleClick = () => {
    if (!occupied) {
      if (selected) {
        cancel(ticketIdentifier);
      } else {
        select(ticketIdentifier, seat);
      }
    }
  };

  const color = occupied ? "gray" : selected ? "#B27B16" : "#10B981";

  return (
    <IconButton
      onClick={handleClick}
      sx={{
        color: color,
        cursor: occupied ? "default" : "pointer",
        fontSize: "45px"
      }}>
      <WeekendIcon fontSize="inherit" />
    </IconButton>
  );
};

export default Seat;
