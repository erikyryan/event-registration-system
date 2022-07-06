package asimo.v.entities.objects;

import asimo.v.entities.enums.EventStatus;
import asimo.v.entities.enums.MovieType;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class EventObject {

    @NotNull
    private String name;

    @NotNull
    private Date eventDate;

    @NotNull
    private String duration;

    @NotNull
    private Integer classification;

    @NotNull
    private Integer launchYear;

    @NotNull
    private String synopsis;

    @NotNull
    private MovieType movieType;

    @NotNull
    private EventStatus eventStatus;

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

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }
}
