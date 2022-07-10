import { Box, Table, TableHead, TableRow, TableCell, TableBody } from "@mui/material";
import { ISession } from "../types/ISession";
import { Link } from "react-router-dom";

interface Props {
  sessions?: ISession[] | null | undefined;
}

const SessionsList = ({ sessions }: Props) => {
  return (
    <Box sx={{ minWidth: 1000 }}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Filme</TableCell>
            <TableCell>Ingresso</TableCell>
            <TableCell>Status</TableCell>
            <TableCell>N° Assentos</TableCell>
            <TableCell>Data</TableCell>
            <TableCell>Horário</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {sessions?.slice(0, 10).map((session) => {
            const date = new Date(session.sessionStartDate);
            const hours = date.getHours();
            const minutes = date.getMinutes();

            return (
              <TableRow
                hover
                key={session.sessionIdentifier}
                component={Link}
                to={`/session/${session.sessionIdentifier}`}>
                <TableCell>{session.event.name}</TableCell>
                <TableCell>R${session.ticketPrice}</TableCell>
                <TableCell>{session.sessiosStatus}</TableCell>
                <TableCell>{session.numberOfSeats}</TableCell>
                <TableCell>{date.toLocaleDateString()}</TableCell>
                <TableCell>
                  {hours <= 9 ? "0" + hours : hours}:{minutes <= 9 ? "0" + minutes : minutes}
                </TableCell>
              </TableRow>
            );
          })}
        </TableBody>
      </Table>
    </Box>
  );
};

export default SessionsList;
