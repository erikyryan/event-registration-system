package asimo.v.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Column(name = "dtevento")
    private Date dataEvento;

    private String descricao;
}
