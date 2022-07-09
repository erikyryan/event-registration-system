package asimo.v.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import asimo.v.entities.enums.EventStatus;
import asimo.v.entities.objects.SessionObject;
import asimo.v.entities.operation.SessionOperation;

@Entity
@Table(name = "sessao")
public class Session{

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	@Column(name="sessionidentifier")
	private String sessionIdentifier;

	@Column
    private Date sessionStartDate;

	@Column
    private Date sessionEndDate;
	
    @OneToOne
    @JoinColumn(name="idevento", referencedColumnName = "id")
    private Event event;

    @Column(name = "valor")
    private Long ticketPrice;

    @Column(name = "status")
    private EventStatus sessiosStatus;

	@Column(name = "numerodeassentos")
	private Integer numberOfSeats;

	public Session(SessionOperation SessionOperation) {

	}

	public Session(Long id, String sessionIdentifier, Date sessionStartDate, Date sessionEndDate, Event event,
			Long ticketPrice, EventStatus sessiosStatus, Integer numberOfSeats) {
		this.id = id;
		this.sessionIdentifier = UUID.randomUUID().toString();
		this.sessionStartDate = sessionStartDate;
		this.sessionEndDate = sessionEndDate;
		this.event = event;
		this.ticketPrice = ticketPrice;
		this.sessiosStatus = sessiosStatus;
		this.numberOfSeats = numberOfSeats;
	}

	public Session(SessionOperation sessionOperation, Event event) {
		this.setSessionIdentifier(UUID.randomUUID().toString());
		this.setSessionStartDate(sessionOperation.getSessionStartDate());
		this.setSessionEndDate(sessionOperation.getSessionEndDate());
		this.setEvent(event);
		this.setTicketPrice(sessionOperation.getTicketPrice());
		this.setSessiosStatus(sessionOperation.getSessiosStatus());
	}

	public Session(SessionObject SessionObject) {
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Session() {}

	public void initialize() {
		this.setSessiosStatus(EventStatus.EM_ANDAMENTO);
	}

	public void finalize() {
		this.setSessiosStatus(EventStatus.FINALIZADO);
	}

	public String getSessionIdentifier() {
		return sessionIdentifier;
	}

	public void setSessionIdentifier(String sessionIdentifier) {
		this.sessionIdentifier = sessionIdentifier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
