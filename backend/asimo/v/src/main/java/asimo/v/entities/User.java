package asimo.v.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import asimo.v.entities.enums.UserRole;
import asimo.v.entities.operation.UserOperation;
import asimo.v.services.UserService;

@Entity
@Table(name="usuario")
public class User{

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	@Column(name="useridentifier")
    private String userIdentifier;
    
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
    private String password; 

    private String salt; 

    @Column(name="dtnascimento")
    private Date birthDate;

    @Column(name="tipousuario")
    private UserRole role;

    @OneToMany(mappedBy = "user")
    private List<Sale> tickets;

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

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}

	public User(final UserObject user) {
		this.name = user.getName();
		this.setUserIdentifier(UUID.randomUUID().toString());
		this.doc = user.getDoc();
		this.sex = user.getSex();
		this.email = user.getEmail();
		this.telephone = user.getTelephone();
		this.birthDate = user.getBirthDate();
		this.role = UserRole.USER;
	}

	public void editUser(UserOperation editUser) {
		this.name = editUser.getName().isEmpty() ? editUser.getName() : this.name;
		this.doc = editUser.getDoc().isEmpty() ? editUser.getDoc() : this.doc; 
		this.sex = editUser.getSex().isEmpty() ? editUser.getSex() : this.sex; 
		this.telephone = editUser.getTelephone().isEmpty() ? editUser.getTelephone() : this.telephone; 
		this.birthDate = editUser.getBirthDate().equals(null) ? editUser.getBirthDate() : this.birthDate; 
	}

	public void generatePassword(final String password) {        
		this.salt = UserService.generateSalt();
		this.password = UserService.encryptPassword(password, salt);
	}

	public boolean isAdmin(){
		if(this.role == UserRole.ADMIN){
			return true;
		}else{
			throw new RuntimeException("Acesso negado");
		}
	}

	public boolean isUser(){
		if(this.role == UserRole.USER){
			return true;
		}else{
			throw new RuntimeException("Acesso negado");
		}
	}

	public boolean isVendedor(){
		if(this.role == UserRole.VENDEDOR){
			return true;
		}else{
			throw new RuntimeException("Acesso negado");
		}
	}

	@Override
	public String toString() {
		return "name='" + name + '\'' +
				", doc='" + doc + '\'' +
				", sex='" + sex + '\'' +
				", email='" + email + '\'' +
				", telephone='" + telephone + '\'' +
				", password='" + password + '\'' +
				", birthDate=" + birthDate +
				", role=" + role +
				", tickets=" + tickets;
	}

}
