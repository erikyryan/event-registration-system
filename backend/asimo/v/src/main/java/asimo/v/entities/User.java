package asimo.v.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import asimo.v.entities.enums.UserRole;
import asimo.v.services.UserService;

@Entity
@Table(name="users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Column(unique = true)
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)|(^\\d{1,2}).?(\\d{3}).?(\\d{3})-?(\\d{1}|X|x$)\r\n", message = "formato inválido.")
    private String doc;

    @NotNull
    private String sex;

    @NotNull
	private String email;

	@NotNull
    private String telephone;
    
    @NotNull
    private String login;
    
    @NotNull
    private String password; 

    private String salt; 

    @Column(name="dtnascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    @Column(name="tipousuario")
    private UserRole role;

    @OneToMany(mappedBy = "user")
    private List<Sale> tickets;

	@OneToMany(mappedBy = "user")
	private List<LoginSession> loginSessions;

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public List<Sale> getTickets() {
		return tickets;
	}

	public void setTickets(List<Sale> tickets) {
		this.tickets = tickets;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public User(final UserObject user) {
		this.name = user.getName();
		this.doc = user.getDoc();
		this.sex = user.getSex();
		this.email = user.getEmail();
		this.telephone = user.getTelephone();
		this.login = user.getLogin();
		this.birthDate = user.getBirthDate();
		this.role = UserRole.USER;
	}

	public void generatePassword(final String password) {        
		this.salt = UserService.generateSalt();
		this.password = UserService.encryptPassword(password, salt);
	}

	@Override
	public String toString() {
		return "name='" + name + '\'' +
				", doc='" + doc + '\'' +
				", sex='" + sex + '\'' +
				", email='" + email + '\'' +
				", telephone='" + telephone + '\'' +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", birthDate=" + birthDate +
				", role=" + role +
				", tickets=" + tickets;
	}
}
