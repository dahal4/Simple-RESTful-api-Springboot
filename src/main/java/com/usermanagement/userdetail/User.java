package com.usermanagement.userdetail;

import javax.persistence.*;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String number;

    public User(Integer id, String name, String password, String email, String number) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.number = number;
    }

    public User() {
    }

    public User(String name, String password, String email, String number) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", number=" + number +
                '}';
    }
}