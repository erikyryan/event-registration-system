package asimo.v.entities.generics;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import asimo.v.entities.enums.EventStatus;
import asimo.v.factories.enums.EventsEnum;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Event {
	
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

	public Event() {
	}
}
