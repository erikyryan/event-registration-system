package asimo.v.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "loginsession")
public class LoginSession {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", unique = true)
    private Long id;

    private Long iduser;
	
    @Column(nullable = false)
	private String token;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date loginDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date expirationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date logountDate;

	public LoginSession(User user) {
		this.iduser = user.getId();
		this.token = UUID.randomUUID().toString();
		this.loginDate = new Date();
		this.expirationDate = Date.from(LocalDateTime.now().plus(Duration.of(10, ChronoUnit.MINUTES)).atZone(ZoneId.systemDefault()).toInstant());
	}

    public LoginSession() {
    }

    public String getToken() {
		return token;
	}

	public void finish() {
		this.logountDate = new Date();
	}

	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}
}
