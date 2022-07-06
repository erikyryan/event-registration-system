package asimo.v.entities.objects;

import asimo.v.entities.Event;
import asimo.v.entities.Localization;
import asimo.v.entities.enums.EventStatus;

import javax.persistence.Column;
import java.util.Date;

public class SessionObject {

    private Date sessionDate;

    private Localization place;

    private Event event;

    private Long ticketPrice;

    private EventStatus sessiosStatus;

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public Localization getPlace() {
        return place;
    }

    public void setPlace(Localization place) {
        this.place = place;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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

    public SessionObject() {
    }
}
