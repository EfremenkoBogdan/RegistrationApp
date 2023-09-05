package com.example.registrationapp;

public class Customer
{
    private String lastName;
    private String firstName;
    private String gender;
    private String country;
    private String username;
    private String password;

    public  Customer () {

    }
    public Customer(String lastName, String firstName, String gender, String country, String username, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.country = country;
        this.username = username;
        this.password = password;
    }

    public String  getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
