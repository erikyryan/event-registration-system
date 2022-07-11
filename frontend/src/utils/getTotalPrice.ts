interface SelectedSeat {
  ticketIdentifier: string;
  nameUser: string;
  sex: string;
  doc: string;
  price: number;
  type: string;
}

const getTotalPrice = (selected: SelectedSeat[]) => {
  const totalPrice = selected?.reduce((prev, curr) => {
    return prev + curr.price;
  }, 0);

  return totalPrice;
};

export default getTotalPrice;
