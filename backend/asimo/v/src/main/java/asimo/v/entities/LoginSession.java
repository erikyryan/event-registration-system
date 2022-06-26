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

    @ManyToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "id",nullable = false)
    private User user;
	
    @Column(nullable = false)
	private String token;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "logindate",nullable = false)
    private Date loginDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expirationdate",nullable = false)
    private Date expirationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "logoutdate")
    private Date logoutDate;

	public LoginSession(User user) {
		this.user = user;
		this.token = UUID.randomUUID().toString();
		this.loginDate = new Date();
		this.expirationDate = Date.from(LocalDateTime.now().plus(Duration.of(10, ChronoUnit.MINUTES)).atZone(ZoneId.systemDefault()).toInstant());
	}

    public LoginSession() {
    }

    public String getToken() {
		return token;
	}
}
