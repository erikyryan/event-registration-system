package asimo.v.entities.generics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import asimo.v.entities.enums.EventStatus;
import asimo.v.factories.enums.EventsEnum;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Event {
	
    @Id
    @Column(name = "eventId")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer eventId; 
	
    @JsonIgnoreProperties
	@Column(name="eventidentifier")
	public String eventIdentifier;
	
	@JsonIgnoreProperties
	@Enumerated(EnumType.STRING)
	public EventStatus eventStatus = EventStatus.AGENDADO;
	
	public EventsEnum eventType;
	
    public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EventStatus getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(EventStatus eventStatus) {
		this.eventStatus = eventStatus;
	}
	
	public String getEventIdentifier() {
		return eventIdentifier;
	}

	public void setEventIdentifier(String eventIdentifier) {
		this.eventIdentifier = eventIdentifier;
	}

	public EventsEnum getEventType() {
		return EventsEnum.TEATRO;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer id) {
		this.eventId = id;
	}


	public Event(Integer eventId, String eventIdentifier, EventStatus eventStatus, EventsEnum eventType, String name) {
		this.eventId = eventId;
		this.eventIdentifier = eventIdentifier;
		this.eventStatus = eventStatus;
		this.eventType = eventType;
		this.name = name;
	}

	public Event() {
	}
}
