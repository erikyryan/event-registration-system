import CheckCircleIcon from "@mui/icons-material/CheckCircle";
import { Box, Divider, Typography } from "@mui/material";

interface Props {
  paymentData: any;
}

const PaymentConfirmation = ({ paymentData }: Props) => {
  return (
    <Box
      sx={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        flexDirection: "column",
        my: 2,
        px: 4
      }}>
      <CheckCircleIcon sx={{ fontSize: 80 }} color="success" />
      <Typography variant="h4" component="h2" align="center" fontWeight="bold">
        Obrigado!
      </Typography>
      <Typography variant="h6" component="h3" align="center" sx={{ mt: 2 }}>
        Sua compra foi bem sucedida.
      </Typography>
      <Divider sx={{ my: 2, borderColor: "#8090aa", width: "100%" }} />
      <Box width="100%">
        <Typography variant="h6" align="left" fontWeight="bold" sx={{ mb: 2 }}>
          Dados do evento:
        </Typography>
        <Box display="flex" justifyContent="space-between" width="100%">
          <Box display="flex" alignSelf="flex-start" flexDirection="column">
            <Typography
              variant="h6"
              component="h3"
              color="neutral.500"
              fontWeight="normal"
              fontSize="medium">
              DATA
            </Typography>
            <Typography variant="h6" component="h3">
              {new Date(paymentData.sessionDate).toLocaleDateString()}
            </Typography>
          </Box>
          <Box display="flex" alignSelf="flex-start" flexDirection="column">
            <Typography
              variant="h6"
              component="h3"
              align="right"
              color="neutral.500"
              fontWeight="normal"
              fontSize="medium">
              HORÁRIO
            </Typography>
            <Typography variant="h6" component="h3" align="right">
              {new Date(paymentData.sessionDate).getHours()}:
              {new Date(paymentData.sessionDate).getMinutes()}
            </Typography>
          </Box>
        </Box>
        <Box display="flex" alignSelf="flex-start" flexDirection="column" sx={{ mt: 3 }}>
          <Typography
            variant="h6"
            component="h3"
            color="neutral.500"
            fontWeight="normal"
            fontSize="medium">
            TOTAL
          </Typography>
          <Typography variant="h6" component="h3">
            R$ {paymentData.price}
          </Typography>
        </Box>
      </Box>
    </Box>
  );
};

export default PaymentConfirmation;
