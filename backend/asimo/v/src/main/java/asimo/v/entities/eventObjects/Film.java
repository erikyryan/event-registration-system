package asimo.v.entities.eventObjects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import asimo.v.entities.enums.EventStatus;
import asimo.v.entities.enums.MovieType;
import asimo.v.entities.generics.Event;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.factories.interfaces.Video;

@Entity
@Table(name = "filme")
public class Film extends Event implements Video {

    @Column
    private Date filmStartDate;

    @Column
    private Date filmEndDate;
    
	private String duration;

	private Integer classification;

	@Column(name = "launchyear")
	private Integer launchYear;

	@Size(max=2000)
    private String synopsis;

	@Column(name = "type")
	private MovieType movieType;

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

	public Integer getClassification() {
		return classification;
	}

	public void setClassification(Integer classification) {
		this.classification = classification;
	}

	public Integer getLaunchYear() {
		return launchYear;
	}

	public void setLaunchYear(Integer launchYear) {
		this.launchYear = launchYear;
	}

	public MovieType getMovieType() {
		return movieType;
	}


	public Date getFilmStartDate() {
		return filmStartDate;
	}

	public void setFilmStartDate(Date filmStartDate) {
		this.filmStartDate = filmStartDate;
	}

	public Date getFilmEndDate() {
		return filmEndDate;
	}

	public void setFilmEndDate(Date filmEndDate) {
		this.filmEndDate = filmEndDate;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

	public String getEventIdentifier() {
		return eventIdentifier;
	}

	public void setEventIdentifier(String eventIdentifier) {
		this.eventIdentifier = eventIdentifier;
	}

	public Date getEventStartDate() {
		return filmStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.filmStartDate = eventStartDate;
	}

	public Date getEventEndDate() {
		return filmEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		this.filmEndDate = eventEndDate;
	}

	public Film(MovieType movieType) {
		this.movieType = movieType;
	}
	@Override
	public EventsEnum getEventType() {
		return EventsEnum.FILME;
	}
	public Film() {
	}

	public Film(String eventIdentifier, EventStatus eventStatus, EventsEnum eventType, Date filmStartDate,
			Date filmEndDate, String duration, Integer classification, Integer launchYear,
			@Size(max = 2000) String synopsis, MovieType movieType) {
		super(eventIdentifier, eventStatus, eventType);
		this.filmEndDate = filmEndDate;
		this.duration = duration;
		this.classification = classification;
		this.launchYear = launchYear;
		this.synopsis = synopsis;
		this.movieType = movieType;
	}

	@Override
	public String toString() {
		return "Event eventIdentifier=" + eventIdentifier + ", name=" + name + ", eventStartDate="
				+ filmStartDate + ", eventEndDate=" + filmEndDate + ", duration=" + duration + ", classification="
				+ classification + ", launchYear=" + launchYear + ", synopsis=" + synopsis + ", movieType=" + movieType
				+ ", eventStatus=" + eventStatus + "]";
	}
}
