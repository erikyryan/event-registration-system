package asimo.v.entities.objects;

public class EventObject {

    private String eventType;

    private String name;

    private String synopsis;

    private String type;

    private String eventStartDate;

    private String eventEndDate;

    private String classification;

    private String launchYear;

    private String movieType;

    private String actors;

    private String period;

    private String structure;

    private String comedian;

    private String eventName;

    private String date;

    private String equipments;

    private String teachers;

    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(String eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public String getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(String eventEndDate) {
		this.eventEndDate = eventEndDate;
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

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getComedian() {
		return comedian;
	}

	public void setComedian(String comedian) {
		this.comedian = comedian;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEquipments() {
		return equipments;
	}

	public void setEquipments(String equipments) {
		this.equipments = equipments;
	}

	public String getTeachers() {
		return teachers;
	}

	public void setTeachers(String teachers) {
		this.teachers = teachers;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public EventObject(String eventType, String name, String synopsis, String type, String eventStartDate,
			String eventEndDate, String classification, String launchYear, String movieType, String actors,
			String period, String structure, String comedian, String eventName, String date, String equipments,
			String teachers, String subject) {
		this.eventType = eventType;
		this.name = name;
		this.synopsis = synopsis;
		this.type = type;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.classification = classification;
		this.launchYear = launchYear;
		this.movieType = movieType;
		this.actors = actors;
		this.period = period;
		this.structure = structure;
		this.comedian = comedian;
		this.eventName = eventName;
		this.date = date;
		this.equipments = equipments;
		this.teachers = teachers;
		this.subject = subject;
	}

	public EventObject() {
	}
}
