package asimo.v.entities.operation;

import asimo.v.entities.enums.EventStatus;

import java.util.Date;

public class SessionOperation {

    private Date sessionDate;

    private String eventIdentifier;

    private Long ticketPrice;

    private EventStatus sessiosStatus;

    private Integer numberOfSeats;

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getEventIdentifier() {
        return eventIdentifier;
    }

    public void setEventIdentifier(String eventIdentifier) {
        this.eventIdentifier = eventIdentifier;
    }

    public Long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public EventStatus getSessiosStatus() {
        return sessiosStatus;
    }

    public void setSessiosStatus(EventStatus sessiosStatus) {
        this.sessiosStatus = sessiosStatus;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public SessionOperation() {
    }

    public SessionOperation(Date sessionDate, String eventIdentifier, Long ticketPrice, EventStatus sessiosStatus, Integer numberOfSeats) {
        this.sessionDate = sessionDate;
        this.eventIdentifier = eventIdentifier;
        this.ticketPrice = ticketPrice;
        this.sessiosStatus = sessiosStatus;
        this.numberOfSeats = numberOfSeats;
    }
}
