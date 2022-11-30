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
@Table(name = "curtaMetragem")
public class ShortFilm extends Event implements Video {

	@Column(name="curtaMetragemIdentifier")
	private String shortFilmIdentifier;

    @Column
    private Date eventStartDate;

    @Column
    private Date eventEndDate;
    
	private String duration;

	private Integer classification;

	@Column(name = "launchyear")
	private Integer launchYear;

	@Size(max=2000)
    private String synopsis;

	@Column(name = "type")
	private MovieType movieType;

	public String getShortFilmIdentifier() {
		return shortFilmIdentifier;
	}

	public void setShortFilmIdentifier(String shortFilmIdentifier) {
		this.shortFilmIdentifier = shortFilmIdentifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public MovieType getMovieType() {
		return movieType;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

	@Override
	public EventsEnum getEventType() {
		return EventsEnum.CURTA;
	}

	public ShortFilm() {
	}

	public ShortFilm(Integer eventId, String eventIdentifier, EventStatus eventStatus, EventsEnum eventType,
			String name, String shortFilmIdentifier, Date eventStartDate, Date eventEndDate, String duration,
			Integer classification, Integer launchYear, @Size(max = 2000) String synopsis, MovieType movieType) {
		super(eventId, eventIdentifier, eventStatus, eventType, name);
		this.shortFilmIdentifier = shortFilmIdentifier;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.duration = duration;
		this.classification = classification;
		this.launchYear = launchYear;
		this.synopsis = synopsis;
		this.movieType = movieType;
	}
}
