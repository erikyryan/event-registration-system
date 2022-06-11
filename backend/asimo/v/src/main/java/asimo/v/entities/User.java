package asimo.v.entities;

import asimo.v.entities.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roleuser")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private String cpf;

    private String sexo;

    private String email;

    private String telefone;

    private String login;

    private String senha;

    @Column(name="dtnascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNascimento;

    @Column(name="tipousuario")
    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "user")
    private List<Venda> vendas;
}
