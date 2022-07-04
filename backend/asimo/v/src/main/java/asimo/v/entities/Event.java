package asimo.v.entities;

import asimo.v.entities.enums.EventStatus;
import asimo.v.entities.enums.MovieType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evento")
public class Event{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

	@Column(name="eventidentifier")
	private String eventIdentifier;

    private String name;

    @Column(name = "eventdate")
    private Date eventDate;

	private String duration;

	private String classification;

	@Column(name = "launchyear")
	private String launchYear;

    private String synopsis;

	@Column(name = "type")
	private MovieType movieType;

	private EventStatus eventStatus;

	public EventStatus getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(EventStatus eventStatus) {
		this.eventStatus = eventStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
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

	public String getLaunchYear() {
		return launchYear;
	}

	public void setLaunchYear(String launchYear) {
		this.launchYear = launchYear;
	}

	public MovieType getMovieType() {
		return movieType;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

	public Event(EventObject eventObject) {
		this.name = eventObject.getName();
		this.eventDate = eventObject.getEventDate();
		this.synopsis = eventObject.getSynopsis();
		this.duration = eventObject.getDuration();
		this.classification = eventObject.getClassification();
		this.launchYear = eventObject.getLaunchYear();
		this.movieType = eventObject.getMovieType();
	}



	public Event() {
	}

	@Override
	public String toString() {
		return "Event{" +
				"id=" + id +
				", name='" + name + '\'' +
				", eventDate=" + eventDate +
				", duration='" + duration + '\'' +
				", classification='" + classification + '\'' +
				", launchYear='" + launchYear + '\'' +
				", synopsis='" + synopsis + '\'' +
				", movieType=" + movieType +
				'}';
	}
}
