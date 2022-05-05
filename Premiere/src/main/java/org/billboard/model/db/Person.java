package org.billboard.model.db;

public class Person {
    private int personId;
    private String username;
    private String password;

    public Person() {
    }

    public Person(int personId, String username, String password) {
        this.personId = personId;
        this.username = username;
        this.password = password;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
