package asimo.v.entities.eventObjects;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import asimo.v.entities.enums.EventStatus;
import asimo.v.entities.generics.Event;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.factories.interfaces.Educate;

@Entity
public class Workshop extends Event implements Educate {

	private String name;
	
	private Date startDate;
	
	private Date endDate;
	
	private String duration;
	
	private String type;
	
	@ElementCollection
	@CollectionTable(name = "teacher")
	private List<String> teachers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public List<String> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<String> teachers) {
		this.teachers = teachers;
	}

	public Workshop() {
		super();
	}

	public Workshop(String eventIdentifier, EventStatus eventStatus, EventsEnum eventType, Long id, String name,
			Date startDate, Date endDate, String duration, String type, List<String> teachers) {
		super(eventIdentifier, eventStatus, eventType);
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.type = type;
		this.teachers = teachers;
	}

	@Override
	public EventsEnum getEventType() {
		return EventsEnum.WORKSHOP;
	}
}
