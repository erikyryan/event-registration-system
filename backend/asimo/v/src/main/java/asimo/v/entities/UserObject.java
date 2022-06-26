package asimo.v.entities;

import asimo.v.entities.enums.UserRole;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

public class UserObject {

    @NotNull
    private String name;

    @NotNull
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

    private Date birthDate;

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

    public UserObject(String name, String doc, String sex, String email, String telephone, String login, String password, Date birthDate) {
        this.name = name;
        this.doc = doc;
        this.sex = sex;
        this.email = email;
        this.telephone = telephone;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
    }
}
