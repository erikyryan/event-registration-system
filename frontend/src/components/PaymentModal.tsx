import { Box, Button, Modal, Typography } from "@mui/material";
import React, { useState } from "react";
import FinalPrice from "./FinalPrice";

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 400,
  bgcolor: "background.paper",
  border: "2px solid #000",
  boxShadow: 24,
  p: 4
};

interface Props {
  selected: SelectedSeat[];
}

interface SelectedSeat {
  number: number;
  type: string;
}

const PaymentModal = ({ selected }: Props) => {
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <div>
      <Button onClick={handleOpen} variant="contained">
        Pagar
      </Button>
      <Modal open={open} onClose={handleClose}>
        <Box sx={style}>
          <Typography id="modal-modal-title" variant="h5" component="h2" align="center">
            Pagamento
          </Typography>
          <Box sx={{ mt: 2 }} id="modal-modal-description">
            <Typography variant="body1">Assentos selecionados:</Typography>
            <Box sx={{ display: "flex", gap: 2 }}>
              {selected.map((seat) => (
                <Box>#{seat.number}</Box>
              ))}
              <Box sx={{ ml: "auto", mt: 5 }}>
                <FinalPrice selected={selected} />
              </Box>
            </Box>
          </Box>
          <Button variant="contained" sx={{}} size="small">
            Confirmar Pagamento
          </Button>
        </Box>
      </Modal>
    </div>
  );
};

export default PaymentModal;
