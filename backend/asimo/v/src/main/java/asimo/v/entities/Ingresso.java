package asimo.v.entities;

import asimo.v.entities.enums.TipoIngresso;

import javax.persistence.*;

@Entity
@Table(name = "ingresso")
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String assento;

    private TipoIngresso tipo;

    private Long valor;

    @OneToMany
    @JoinColumn(name="idsessao",referencedColumnName = "id")
    private Sessao sessao;

    @OneToOne
    @JoinColumn(name="idvenda", referencedColumnName = "id")
    private Venda venda;
}
