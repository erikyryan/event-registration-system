package asimo.v.entities.dto;

import java.util.Date;

import asimo.v.entities.User;
import asimo.v.entities.enums.UserRole;

public class UserDTO {
    
	private String name;
	
    private String doc;
    
    private String sex;
    
	private String email;
	
    private String telephone;
    
    private String login;
    
    private Date birthDate;
    
    private UserRole role;

    public UserDTO(User user) {
		this.name = user.getName();
		this.doc = user.getDoc();
		this.sex = user.getSex();
		this.email = user.getEmail();
		this.telephone = user.getTelephone();
		this.login = user.getLogin();
		this.birthDate = user.getBirthDate();
		this.role = user.getRole();
    }
    
	public UserDTO() {
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
}