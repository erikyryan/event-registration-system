package asimo.v.entities.dto;

import java.util.Date;

import asimo.v.entities.enums.MovieType;

public class EventDTO {

    private Long id;

    private String name;

    private Date eventDate;

    private String duration;

    private String classification;

    private String launchYear;

    private String synopsis;

    private MovieType movieType;

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
}
