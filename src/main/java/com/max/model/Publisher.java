package com.max.model;

public class Publisher {

    private Long id;
    private String name;
    private String city;
    private String phoneNumber;

    public Publisher(Long id, String name, String city, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public Publisher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
