package asimo.v.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tblocal")
public class Localizacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "localevento")
    private String local;

    @Column(name = "numerodeassentos")
    private Long numeroDeAssentos;
}
