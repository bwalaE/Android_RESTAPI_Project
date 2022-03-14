package com.example.jack.kubratest;

public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;

    private double[] geo = new double[2]; // stores the latitude and longitude
    // note that this makes an array of size 2, so the second and final element is geo[1], and trying to access geo[2] will cause an error

    public Address() { }
    public Address (String street, String suite, String city, String zipcode, double[] geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public String getSuite() { return suite; }

    public void setSuite(String suite) { this.suite = suite; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getZipcode() { return zipcode; }

    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    public double[] getGeo() { return geo; }

    public void setGeo(double[] geo) { this.geo = geo; }

}
