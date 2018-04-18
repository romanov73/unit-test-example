package ru.ulstu.entity;

public class User extends BaseEntity {
    private String login;
    private String password;
    private String fullName;

    public User() {
    }

    public User(Long id, String login) {
        this.login = login;
        this.id = id;
    }

    public User(String login) {
        this.login = login;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
