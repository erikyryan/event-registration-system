package asimo.v.entities.operation;

import asimo.v.entities.enums.EventStatus;

import java.util.Date;

public class SessionOperation {

    private Date sessionStartDate;

    private Date sessionEndDate;
    
    private String eventIdentifier;

    private Long ticketPrice;

    private EventStatus sessiosStatus;

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

	public Date getSessionStartDate() {
		return sessionStartDate;
	}

	public void setSessionStartDate(Date sessionStartDate) {
		this.sessionStartDate = sessionStartDate;
	}

	public Date getSessionEndDate() {
		return sessionEndDate;
	}

	public void setSessionEndDate(Date sessionEndDate) {
		this.sessionEndDate = sessionEndDate;
	}

	public SessionOperation(Date sessionStartDate, Date sessionEndDate, String eventIdentifier, Long ticketPrice,
			EventStatus sessiosStatus) {
		this.sessionStartDate = sessionStartDate;
		this.sessionEndDate = sessionEndDate;
		this.eventIdentifier = eventIdentifier;
		this.ticketPrice = ticketPrice;
		this.sessiosStatus = sessiosStatus;
	}
}
