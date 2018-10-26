package common;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String lastName;
    private String surName;
    private String login;
    private String pwd;
    private Role role;

    public UserModel() {
        this.lastName = "";
        this.surName = "";
        this.login = "";
        this.pwd = "";
        this.role = Role.None;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
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
