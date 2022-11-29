package asimo.v.entities.eventObjects;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import asimo.v.entities.generics.Event;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.factories.interfaces.Presentation;

@Entity
@Table(name = "comedia")
public class Comedy extends Event implements Presentation {
	
	private String comedian;
	
	@NotNull
	private String name;
	
	private Date data;
	
	private String duration;
	
	private Integer classification;
	
	public String getComedian() {
		return comedian;
	}

	public void setComedian(String comedian) {
		this.comedian = comedian;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public Comedy(Long id, String comedian, @NotNull String name, Date data, String duration, Integer classification) {
		this.comedian = comedian;
		this.name = name;
		this.data = data;
		this.duration = duration;
		this.classification = classification;
	}

	public Comedy() {
	}
	
	@Override
	public EventsEnum getEventType() {
		return EventsEnum.COMEDIA;
	}
}
