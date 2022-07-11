import { ISelectedSeat } from "../types/ISeat";

const getTotalPrice = (selected?: ISelectedSeat[]) => {
  const totalPrice = selected?.reduce((prev, curr) => {
    return prev + curr.price;
  }, 0);

  return totalPrice;
};

export default getTotalPrice;
