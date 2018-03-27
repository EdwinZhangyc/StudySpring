package com.spring.two.chapterSeven.advancede.customDispatcher;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {

    @NotNull
    @Size(min = 5, max = 10)
    private String username;
    @NotNull
    @Size(min = 5, max = 10)
    private String firstName;
    @NotNull
    @Size(min = 5, max = 10)
    private String lastName;
    @NotNull
    @Size(min = 5, max = 10)
    private String password;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Spitter(String username, String firstName, String lastName, String password, long id) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.id = id;
    }

    public Spitter(String username, String firstName, String lastName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}