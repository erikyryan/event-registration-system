package asimo.v.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sessao")
public class Sessao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "dtsessao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDaSessao;

    @OneToOne
    @JoinColumn(name="idlocal", referencedColumnName = "id")
    private Localizacao Local;

    @OneToOne
    @JoinColumn(name="idevento", referencedColumnName = "id")
    private Evento evento;

    @Column(name = "valorinteira")
    private Long valorInteira;

    @OneToMany(mappedBy="sessao")
    private List<Ingresso> ingressos;
}
