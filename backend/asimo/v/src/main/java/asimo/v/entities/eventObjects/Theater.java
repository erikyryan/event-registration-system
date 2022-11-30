package asimo.v.entities.eventObjects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import asimo.v.entities.enums.EventPeriod;
import asimo.v.entities.enums.EventStatus;
import asimo.v.entities.enums.TheaterType;
import asimo.v.entities.generics.Event;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.factories.interfaces.Presentation;

@Entity
@Table(name = "teatro")
public class Theater extends Event implements Presentation{

	@Column
	private Date eventStartDate;

	@Column
	private Date eventEndDate;

	private Integer classification;

	@Size(max = 2000)
	private String actors;

	@Column(name = "type")
	private EventPeriod period;
	
	private TheaterType structure;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public Integer getClassification() {
		return classification;
	}

	public void setClassification(Integer classification) {
		this.classification = classification;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public EventPeriod getPeriod() {
		return period;
	}

	public void setPeriod(EventPeriod period) {
		this.period = period;
	}

	public TheaterType getStructure() {
		return structure;
	}

	public void setStructure(TheaterType structure) {
		this.structure = structure;
	}

	public EventStatus getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(EventStatus eventStatus) {
		this.eventStatus = eventStatus;
	}

	public Theater(Integer eventId, String eventIdentifier, EventStatus eventStatus, EventsEnum eventType, String name,
			Date eventStartDate, Date eventEndDate, Integer classification, @Size(max = 2000) String actors,
			EventPeriod period, TheaterType structure) {
		super(eventId, eventIdentifier, eventStatus, eventType, name);
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.classification = classification;
		this.actors = actors;
		this.period = period;
		this.structure = structure;
	}

	public Theater() {
	}
}
