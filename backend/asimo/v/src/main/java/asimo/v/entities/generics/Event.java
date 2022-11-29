package asimo.v.entities.generics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import asimo.v.entities.enums.EventStatus;
import asimo.v.factories.enums.EventsEnum;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Event {
	
    @Id
    @Column(name = "eventId")
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Integer eventId; 
	
	@Column(name="eventidentifier")
	public String eventIdentifier;

	public EventStatus eventStatus;
	
	public EventsEnum eventType;
	
	@NotNull
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
		return eventType;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer id) {
		this.eventId = id;
	}

	public Event(String eventIdentifier, EventStatus eventStatus, EventsEnum eventType) {
		this.eventIdentifier = eventIdentifier;
		this.eventStatus = eventStatus;
		this.eventType = eventType;
		this.name = "x";
	}

	public Event() {
	}
}
