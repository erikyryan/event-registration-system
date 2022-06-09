package asimo.v.entities;

import asimo.v.entities.enums.TipoUsuario;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="roleuser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String cpf;

    private String sexo;

    private String email;

    private String telefone;

    private String login;

    private String senha;

    @Column(name="dtnascimento")
    private Date dataNascimento;

    @Column(name="tipousuario")
    private TipoUsuario tipoUsuario;
}
