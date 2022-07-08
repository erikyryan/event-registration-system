package asimo.v.entities.dto;

public class TicketDTO {

    private Boolean occupiedSeat;

    private Integer seat;

    public TicketDTO() {
    }

    public TicketDTO(Boolean occupiedSeat, Integer seat) {
        this.occupiedSeat = occupiedSeat;
        this.seat = seat;
    }

    public Boolean getOccupiedSeat() {
        return occupiedSeat;
    }

    public void setOccupiedSeat(Boolean occupiedSeat) {
        this.occupiedSeat = occupiedSeat;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }
}
