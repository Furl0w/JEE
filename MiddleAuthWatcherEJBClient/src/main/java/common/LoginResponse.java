package common;

public class LoginResponse {
    private String login;
    private Boolean validAuth;
    private Role role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getValidAuth() {
        return validAuth;
    }

    public void setValidAuth(Boolean validAuth) {
        this.validAuth = validAuth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public LoginResponse() {
    }


    public LoginResponse(String login, boolean validAuth, Role role) {
        this.login = login;
        this.validAuth = validAuth;
        this.role = role;
    }
}
