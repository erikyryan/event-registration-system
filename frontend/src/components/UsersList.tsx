import {
  Box,
  Typography,
  Button,
  Table,
  TableHead,
  TableRow,
  TableCell,
  TableBody
} from "@mui/material";
import { IUser } from "../types/IUser";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";

interface Props {
  users?: IUser[];
}

const UsersList = ({ users }: Props) => {
  return (
    <Box sx={{ minWidth: 1050 }}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Nome</TableCell>
            <TableCell>Email</TableCell>
            <TableCell>Documento</TableCell>
            <TableCell>Telefone</TableCell>
            <TableCell>Nascimento</TableCell>
            <TableCell>Função</TableCell>
            <TableCell>Ações</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {users.slice(0, 10).map((user) => (
            <TableRow hover key={user.id}>
              <TableCell>
                <Box
                  sx={{
                    alignItems: "center",
                    display: "flex"
                  }}>
                  <Typography color="textPrimary" variant="body1">
                    {user.name}
                  </Typography>
                </Box>
              </TableCell>
              <TableCell>{user.email}</TableCell>
              <TableCell>{user.doc}</TableCell>
              <TableCell>{user.phone}</TableCell>
              <TableCell>{user.birthDate}</TableCell>
              <TableCell>{user.role}</TableCell>
              <TableCell>
                <Button startIcon={<EditIcon />} size="small" variant="outlined" sx={{ mr: 1 }}>
                  Editar
                </Button>
                <Button startIcon={<DeleteIcon />} size="small" variant="outlined" color="error">
                  Deletar
                </Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </Box>
  );
};

export default UsersList;
