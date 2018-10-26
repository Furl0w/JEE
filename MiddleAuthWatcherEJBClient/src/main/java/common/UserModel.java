package common;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Users")
public class UserModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;

    @Column(name = "lastname")
    private String lastname;
    @Column(name = "surname")

    private String surname;

    @Column(name="login",nullable = false,unique = true)
    private String login;

    @Column(name="pwd",nullable = false)
    private String pwd;

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public UserModel() {
        this.idUser = 0;
        this.lastname = "";
        this.surname = "";
        this.login = "";
        this.pwd = "";
        this.role = Role.None;
    }

    public Number getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
