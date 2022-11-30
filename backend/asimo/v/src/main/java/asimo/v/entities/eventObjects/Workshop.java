package asimo.v.entities.eventObjects;

import java.util.Date;

import javax.persistence.Entity;

import asimo.v.entities.enums.EventStatus;
import asimo.v.entities.generics.Event;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.factories.interfaces.Educate;

@Entity
public class Workshop extends Event implements Educate {

	private Date eventStartDate;
	
	private Date eventEndDate;
	
	private String duration;
	
	private String type;
	
	private String teachers;
	
	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public Date getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public String getTeachers() {
		return teachers;
	}

	public void setTeachers(String teachers) {
		this.teachers = teachers;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Workshop() {
		super();
	}

	public Workshop(Integer eventId, String eventIdentifier, EventStatus eventStatus, EventsEnum eventType, String name,
			Date eventStartDate, Date eventEndDate, String duration, String type, String teachers) {
		super(eventId, eventIdentifier, eventStatus, eventType, name);
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.duration = duration;
		this.type = type;
		this.teachers = teachers;
	}

	@Override
	public EventsEnum getEventType() {
		return EventsEnum.WORKSHOP;
	}
}
