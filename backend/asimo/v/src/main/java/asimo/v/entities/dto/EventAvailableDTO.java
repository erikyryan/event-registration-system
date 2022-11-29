package asimo.v.entities.dto;

import asimo.v.entities.eventObjects.Comedy;
import asimo.v.entities.eventObjects.Course;
import asimo.v.entities.eventObjects.Film;
import asimo.v.entities.eventObjects.ShortFilm;
import asimo.v.entities.eventObjects.Theater;
import asimo.v.entities.eventObjects.Workshop;

public class EventAvailableDTO {

	private String name;
	
	private String launchYear;
	
	private String duration;
	
	private String classification;
	
	private String synopsis;
	
	private String eventIdentifier;

	public EventAvailableDTO(Comedy c) {
		this.name = c.getName();
		this.launchYear = c.getData().toString();
		this.duration = c.getDuration();
		this.classification = c.getClassification().toString();
		this.synopsis = "";
		this.eventIdentifier = c.getEventIdentifier();
	}

	public EventAvailableDTO(Course c) {
		this.name = c.getName();
		this.launchYear = "";
		this.duration = c.getDuration();
		this.classification = "Livre";
		this.synopsis = c.getType();
		this.eventIdentifier = c.getEventIdentifier();
	}

	public EventAvailableDTO(Film c) {
		this.name = c.getName();
		this.launchYear = c.getLaunchYear().toString();
		this.duration = c.getDuration();
		this.classification = c.getClassification().toString();
		this.synopsis = c.getSynopsis();
		this.eventIdentifier = c.getEventIdentifier();	
	}

	public EventAvailableDTO(ShortFilm c) {
		this.name = c.getName();
		this.launchYear = c.getLaunchYear().toString();
		this.duration = c.getDuration();
		this.classification = c.getClassification().toString();
		this.synopsis = c.getSynopsis();
		this.eventIdentifier = c.getEventIdentifier();
	}

	public EventAvailableDTO(Theater c) {
		this.name = c.getName();
		this.launchYear = c.getTheaterStartDate().toString();
		this.duration = "";
		this.classification = c.getClassification().toString();
		this.synopsis = c.getActors();
		this.eventIdentifier = c.getEventIdentifier();	
	}

	public EventAvailableDTO(Workshop c) {
		this.name = c.getName();
		this.launchYear = "";
		this.duration = c.getDuration();
		this.classification = "";
		this.synopsis = "";
		this.eventIdentifier = c.getEventIdentifier();	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLaunchYear() {
		return launchYear;
	}

	public void setLaunchYear(String launchYear) {
		this.launchYear = launchYear;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getEventIdentifier() {
		return eventIdentifier;
	}

	public void setEventIdentifier(String eventIdentifier) {
		this.eventIdentifier = eventIdentifier;
	}

}
