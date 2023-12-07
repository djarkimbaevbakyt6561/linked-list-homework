package models;

public class Actor {

    public String fullName;
    public String role;

    public Actor(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    public Actor() {

    }

    @Override
    public String toString() {
        return "Actor{" +
                "fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
