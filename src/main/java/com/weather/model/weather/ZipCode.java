package com.weather.model.weather;

public class ZipCode {

    private String country_code;
    private Long zip;

    /**
     * Default constructor
     */
    public ZipCode() {}

    /**
     * Full constructor
     * @param zip
     * @param country_code
     */
    public ZipCode(Long zip, String country_code) {
        this.zip = zip;
        this.country_code = country_code;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }
}
