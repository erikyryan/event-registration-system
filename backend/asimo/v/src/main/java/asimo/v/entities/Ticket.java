package asimo.v.entities;

import javax.persistence.*;

import asimo.v.entities.enums.TicketType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingresso")
public class Ticket{

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String seat;

	@Column(name="type")
    private TicketType ticketType;

    private Long price;

    @ManyToOne
    @JoinColumn(name="idsessao",referencedColumnName = "id")
    private Session session;

    @OneToOne
    @JoinColumn(name="idvenda", referencedColumnName = "id")
    private Sale venda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
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

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Sale getVenda() {
		return venda;
	}

	public void setVenda(Sale venda) {
		this.venda = venda;
	}
}
