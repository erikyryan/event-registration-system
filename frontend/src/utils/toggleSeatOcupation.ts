import api from "../services/api";

const toggleSeatOcupation = async (ticketIdentifier: string, token: string) => {
  const res = await api.post(
    "/ticket/seat/ocuppeid",
    {},
    {
      headers: {
        token,
        ticketidentifier: ticketIdentifier
      }
    }
  );
  console.log(res.data);
  return res.data;
};

export default toggleSeatOcupation;
