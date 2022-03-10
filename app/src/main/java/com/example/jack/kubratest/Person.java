package com.example.jack.kubratest;

public class Person {
    private String name;
    private String street;
    private String suite;
    private String city;
    //private String address;

    public Person() { }
    public Person(String name, String street, String suite, String city) {
        this.name = name;
        this.street = street;
        this.suite = suite;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
