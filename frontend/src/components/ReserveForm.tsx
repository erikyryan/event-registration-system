import { Paper, Typography, Box } from "@mui/material";

interface Props {
  selected: number[];
}

const ReserveForm = ({ selected }: Props) => {
  return (
    <form>
      <Box sx={{ display: "flex" }}>
        <Typography variant="h6">Selected seat(s):</Typography>
        {selected.map((seat) => (
          <Paper
            sx={{
              marginInline: "5px",
              backgroundColor: "lightblue",
              padding: "2px"
            }}>
            Seat #{seat}
          </Paper>
        ))}
      </Box>
    </form>
  );
};

export default ReserveForm;
