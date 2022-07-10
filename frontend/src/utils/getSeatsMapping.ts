type Seat = {
  seat: number;
  occupiedSeat: boolean;
};

const getSeatsMapping = (seats: Seat[]) => {
  const numsPerGroup = Math.ceil(seats?.length / 3);
  const seatsMapping = new Array(3)
    .fill("")
    .map((_, i) => seats?.slice(i * numsPerGroup, (i + 1) * numsPerGroup));

  return seatsMapping;
};

export default getSeatsMapping;
