package asimo.v.entities.eventObjects;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import asimo.v.entities.enums.EventStatus;
import asimo.v.entities.generics.Event;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.factories.interfaces.Presentation;

@Entity
@Table(name = "comedia")
public class Comedy extends Event implements Presentation {
	
	private String comedian;
	
	private String eventName;
	
	private Date date;
	
	private String duration;
	
	private Integer classification;
	
	@Override
	public String getName() {
		return super.getName();
	}
	@Override
	
	public void setName(String name) {
		super.setName(name);
	}
	public String getComedian() {
		return comedian;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setComedian(String comedian) {
		this.comedian = comedian;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getClassification() {
		return classification;
	}

	public void setClassification(Integer classification) {
		this.classification = classification;
	}

	
	public Comedy(Integer eventId, String eventIdentifier, EventStatus eventStatus, EventsEnum eventType, String name,
			String comedian, String eventName, Date date, String duration, Integer classification) {
		super(eventId, eventIdentifier, eventStatus, eventType, name);
		this.comedian = comedian;
		this.eventName = eventName;
		this.date = date;
		this.duration = duration;
		this.classification = classification;
	}
	public Comedy() {
	}
	
	@Override
	public EventsEnum getEventType() {
		return EventsEnum.COMEDIA;
	}
}
