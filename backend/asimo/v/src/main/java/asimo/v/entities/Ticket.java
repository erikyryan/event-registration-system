package asimo.v.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import asimo.v.entities.dto.TicketDTO;
import asimo.v.entities.enums.TicketType;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ingresso")
public class Ticket{


    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	@Column(name="ticketidentifier")
	private String ticketIdentifier;

    private Integer seat;

	@Column(name="type")
    private TicketType ticketType;

    private Long price;

	@Column(name = "sessionidentifier",nullable = false)
    private String sessionIdentifier;

	@Column(name="eventidentifier",nullable = false)
	private String eventIdentifier;

    @Column(name = "saleidentifier")
    private String saleidentifier;

	@Column(name="useridentifier")
	private String useridentifier;

	@Column(name = "occupiedseat",nullable = false)
	private Boolean occupiedSeat;

	@Column(name = "saledate")
	private Date saleDate;

	@Column(name = "enddate")
	private Date endDate;

	public TicketDTO generateTicketDTO(){
		return new TicketDTO(this.occupiedSeat,this.seat);
	}


	public String getTicketIdentifier() {
		return ticketIdentifier;
	}

	public void setTicketIdentifier(String ticketIdentifier) {
		this.ticketIdentifier = ticketIdentifier;
	}

	public Integer getSeat() {
		return seat;
	}

	public void setSeat(Integer seat) {
		this.seat = seat;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getSessionIdentifier() {
		return sessionIdentifier;
	}

	public void setSessionIdentifier(String sessionIdentifier) {
		this.sessionIdentifier = sessionIdentifier;
	}

	public String getEventIdentifier() {
		return eventIdentifier;
	}

	public void setEventIdentifier(String eventIdentifier) {
		this.eventIdentifier = eventIdentifier;
	}

	public String getSaleidentifier() {
		return saleidentifier;
	}

	public void setSaleidentifier(String saleidentifier) {
		this.saleidentifier = saleidentifier;
	}

	public String getUseridentifier() {
		return useridentifier;
	}

	public void setUseridentifier(String useridentifier) {
		this.useridentifier = useridentifier;
	}

	public Boolean getOccupied() {
		return occupiedSeat;
	}

	public void setOccupied(Boolean occupiedSeat) {
		this.occupiedSeat = occupiedSeat;
	}

	public Boolean getOccupiedSeat() {
		return occupiedSeat;
	}

	public void setOccupiedSeat(Boolean occupiedSeat) {
		this.occupiedSeat = occupiedSeat;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Ticket() {
	}

	public Ticket(Integer seat, TicketType ticketType, Long price, String sessionIdentifier, String eventIdentifier, String saleidentifier, String useridentifier, Boolean occupiedSeat, Date saleDate, Date endDate) {
		this.setTicketIdentifier(UUID.randomUUID().toString());
		this.seat = seat;
		this.ticketType = ticketType;
		this.price = price;
		this.sessionIdentifier = sessionIdentifier;
		this.eventIdentifier = eventIdentifier;
		this.saleidentifier = saleidentifier;
		this.useridentifier = useridentifier;
		this.occupiedSeat = occupiedSeat;
		this.saleDate  = saleDate;
		this.endDate = endDate;
	}

	public Ticket(Integer seat, String eventIdentifier, String sessionIdentifier){
		this.setSeat(seat);
		this.setTicketIdentifier(UUID.randomUUID().toString());
		this.setEventIdentifier(eventIdentifier);
		this.setSessionIdentifier(sessionIdentifier);
		this.setOccupied(false);
	}

}
