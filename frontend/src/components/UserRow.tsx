import React, { useState } from "react";
import { Button, TableCell, TableRow } from "@mui/material";
import { IUser } from "../types/IUser";
import DropdownMenu from "./DropdownMenu";

interface Props {
  user: IUser;
}

const UserRow = ({ user }: Props) => {
  return (
    <TableRow hover key={user.userIdentifier}>
      <TableCell>{user.name}</TableCell>
      <TableCell>{user.email}</TableCell>
      <TableCell>{user.doc}</TableCell>
      <TableCell>{user.telephone}</TableCell>
      <TableCell>{user.birthDate}</TableCell>
      <TableCell>{user.role}</TableCell>
      <TableCell>
        <DropdownMenu />
      </TableCell>
    </TableRow>
  );
};

export default UserRow;
