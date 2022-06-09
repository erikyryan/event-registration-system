package asimo.v.entities;

import javax.persistence.*;

@Entity
@Table(name = "tblocal")
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "localevento")
    private String local;

    @Column(name = "numerodeassentos")
    private Long numeroDeAssentos;
}
