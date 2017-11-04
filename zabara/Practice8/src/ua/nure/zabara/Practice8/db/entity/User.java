package ua.nure.zabara.Practice8.db.entity;

public class User {

    private int id;
    private String login;

    public static User createUser(String login) {
        User u = new User();
        u.login = login;
        return u;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User : " + login + " id: " + id;
    }
}
