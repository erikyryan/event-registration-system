package asimo.v.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@Column(name = "dtsessao")
    private Date sessionDate;

    @OneToOne
    @JoinColumn(name="idlocal", referencedColumnName = "id")
    private Localization place;

    @OneToOne
    @JoinColumn(name="idevento", referencedColumnName = "id")
    private Event event;

    @Column(name = "valorinteira")
    private Long ticketPrice;

    @Column(name = "status")
    private EventStatus sessiosStatus;

	public Session(SessionOperation SessionOperation) {

	}

	public Session(SessionOperation sessionOperation, Localization localization, Event event) {
		this.setSessionIdentifier(UUID.randomUUID().toString());
		this.setSessionDate(sessionOperation.getSessionDate());
		this.setPlace(localization);
		this.setEvent(event);
		this.setTicketPrice(sessionOperation.getTicketPrice());
		this.setSessiosStatus(sessionOperation.getSessiosStatus());
	}

	public Session(SessionObject SessionObject) {

	}

	public Session() {

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

	@Override
	public String toString() {
		return "Session{" +
				"  sessionIdentifier='" + sessionIdentifier + '\'' +
				", sessionDate=" + sessionDate +
				", place=" + place +
				", event=" + event +
				", ticketPrice=" + ticketPrice +
				", sessiosStatus=" + sessiosStatus +
				'}';
	}
}
