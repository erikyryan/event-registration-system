package asimo.v.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblocal")
public class Localization{

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	@Column(name = "localizationidentifier")
	private String localizationIdentifier;

    @Column(name = "localevento")
    private String place;

    @Column(name = "numerodeassentos")
    private Integer numberOfSeats;

	public String getLocalizationIdentifier() {
		return localizationIdentifier;
	}

	public void setLocalizationIdentifier(String localizationIdentifier) {
		this.localizationIdentifier = localizationIdentifier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Localization() {
	}

	@Override
	public String toString() {
		return "Localization{" +
				"id=" + id +
				", localizationIdentifier='" + localizationIdentifier + '\'' +
				", place='" + place + '\'' +
				", numberOfSeats=" + numberOfSeats +
				'}';
	}

	public Localization(String localizationIdentifier, String place, Integer numberOfSeats) {
		this.localizationIdentifier = localizationIdentifier;
		this.place = place;
		this.numberOfSeats = numberOfSeats;
	}
}
