package asimo.v.entities;

import asimo.v.entities.enums.TipoDocumento;
import asimo.v.entities.enums.TipoVenda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nrprotocolo")
    private Long protocolo;

    @Column(name="nrvalorvenda")
    private Long valor;

    @Column(name = "dtvenda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDaVenda;

    @ManyToOne
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
