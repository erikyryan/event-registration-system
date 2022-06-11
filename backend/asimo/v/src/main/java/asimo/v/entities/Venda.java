package asimo.v.entities;

import asimo.v.entities.enums.TipoDocumento;
import asimo.v.entities.enums.TipoVenda;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nrprotocolo")
    private Long protocolo;

    @Column(name="nrvalorvenda")
    private Long valor;

    @Column(name = "dtvenda")
    private Date dataDaVenda;

    @Column(name = "idusuario")
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    private User user;

    @Column(name = "formadepagamento")
    private String formaDePagamento;

    @Column(name = "tipovenda")
    private TipoVenda tipoVenda;

    @Column(name="nomecliente")
    private String nomeCliente;

    @Column(name = "tipodedocumento")
    private TipoDocumento tipoDocumento;

    @Column(name = "nrdocumento")
    private String documento;

}
