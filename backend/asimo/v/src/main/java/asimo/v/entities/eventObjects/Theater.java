package asimo.v.entities.eventObjects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import asimo.v.entities.enums.EventPeriod;
import asimo.v.entities.enums.EventStatus;
import asimo.v.entities.enums.TheaterType;
import asimo.v.entities.generics.Event;
import asimo.v.factories.interfaces.Presentation;

@Entity
@Table(name = "teatro")
public class Theater extends Event implements Presentation{

	@Column
	private Date theaterStartDate;

	@Column
	private Date theaterEndDate;

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

	public Date getTheaterStartDate() {
		return theaterStartDate;
	}

	public void setTheaterStartDate(Date theaterStartDate) {
		this.theaterStartDate = theaterStartDate;
	}

	public Date getTheaterEndDate() {
		return theaterEndDate;
	}

	public void setTheaterEndDate(Date theaterEndDate) {
		this.theaterEndDate = theaterEndDate;
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

	public Theater(Long id, String theaterIdentifier, @NotNull String name, Date theaterStartDate, Date theaterEndDate,
			Integer classification, @Size(max = 2000) String actors, EventPeriod period, TheaterType structure,
			EventStatus eventStatus) {
		this.eventIdentifier = theaterIdentifier;
		this.name = name;
		this.theaterStartDate = theaterStartDate;
		this.theaterEndDate = theaterEndDate;
		this.classification = classification;
		this.actors = actors;
		this.period = period;
		this.structure = structure;
		this.eventStatus = eventStatus;
	}

	public Theater() {
	}
}
