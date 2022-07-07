package asimo.v.entities.operation;

import asimo.v.entities.enums.EventStatus;

import java.util.Date;

public class SessionOperation {

    private Date sessionDate;

    private String localizationIdentifier;

    private String eventIdentifier;

    private Long ticketPrice;

    private EventStatus sessiosStatus;

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getLocalizationIdentifier() {
        return localizationIdentifier;
    }

    public void setLocalizationIdentifier(String localizationIdentifier) {
        this.localizationIdentifier = localizationIdentifier;
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

    public SessionOperation() {
    }

    public SessionOperation(Date sessionDate, String localizationIdentifier, String eventIdentifier, Long ticketPrice, EventStatus sessiosStatus) {
        this.sessionDate = sessionDate;
        this.localizationIdentifier = localizationIdentifier;
        this.eventIdentifier = eventIdentifier;
        this.ticketPrice = ticketPrice;
        this.sessiosStatus = sessiosStatus;
    }
}
