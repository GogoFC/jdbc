package se.lexicon.model;

import java.time.LocalDate;

public class User {

    private int user_id;

    private String first_name;

    private String last_name;

    private String email;

    private LocalDate creationDate;

    //READ
    public User(int user_id, String first_name, String last_name, String email, LocalDate creationDate) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.creationDate = creationDate;
    }
    //WRITE
    public User(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("user_id=").append(user_id);
        sb.append(", first_name='").append(first_name).append('\'');
        sb.append(", last_name='").append(last_name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", creationDate=").append(creationDate);
        sb.append('}');
        return sb.toString();
    }
}
