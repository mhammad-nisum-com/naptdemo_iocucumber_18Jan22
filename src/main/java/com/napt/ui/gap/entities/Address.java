package com.napt.ui.gap.entities;

public class Address {

    private String email;
    private String fullName;
    private String streetAddress;
    private String aptUnit;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public Address(String email, String fullName, String streetAddress, String aptUnit, String city, String state, String zip, String phone) {
        this.email = email;
        this.fullName = fullName;
        this.streetAddress = streetAddress;
        this.aptUnit = aptUnit;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getAptUnit() {
        return aptUnit;
    }

    public void setAptUnit(String aptUnit) {
        this.aptUnit = aptUnit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
