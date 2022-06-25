package asimo.v.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "loginsession")
public class LoginSession {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", unique = true)
    private Long id;
	
    @Column(nullable = false)
	private Long userId;
	
    @Column(nullable = false)
	private String token;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date loginDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date expirationDate;
   
    @Nullable
    @Temporal(TemporalType.TIMESTAMP)
    private Date logountDate;

	public LoginSession(User user) {
		this.userId = user.getId();
		this.token = UUID.randomUUID().toString();
		this.loginDate = new Date();
		this.expirationDate = Date.from(LocalDateTime.now().plus(Duration.of(10, ChronoUnit.MINUTES)).atZone(ZoneId.systemDefault()).toInstant());
	}

	public String getToken() {
		return token;
	}
}
