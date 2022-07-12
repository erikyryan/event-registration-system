import { ISelectedSeat } from "../types/ISeat";

const getTotalPrice = (selected?: ISelectedSeat[], currentUserRole?: string) => {
  const totalPrice = selected?.reduce((prev, curr) => {
    return prev + curr.price;
  }, 0);

  if (!totalPrice) return;

  return currentUserRole !== "USER" ? (totalPrice * 1.05).toFixed(2) : totalPrice;
};

export default getTotalPrice;
