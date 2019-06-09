package com.weather.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weather.model.weather.City;

public class WeatherResponse {
    @JsonIgnore
    private City city;

    private Long code;
    private String msg;

    private String todayDate;
    private String cityName;
    private String weatherDescription;
    private Double temperatureFahrenheit;
    private Double TemperatureCelsius;
    private String sunriseTime;
    private String sunsetTime;

    public WeatherResponse() {}

    public WeatherResponse(Long code, String msg, City city) {
        this.code = code;
        this.city = city;
        this.msg = msg;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTodayDate() {
        return todayDate;
    }

    public String getCityName() {
        this.cityName = this.city.getName();
        return cityName;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public Double getTemperatureFahrenheit() {
        return temperatureFahrenheit;
    }

    public Double getTemperatureCelsius() {
        return TemperatureCelsius;
    }

    public String getSunriseTime() {
        return sunriseTime;
    }


    public String getSunsetTime() {
        return sunsetTime;
    }

    public void setTodayDate(String todayDate) {
        this.todayDate = todayDate;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public void setTemperatureFahrenheit(Double temperatureFahrenheit) {
        this.temperatureFahrenheit = temperatureFahrenheit;
    }

    public void setTemperatureCelsius(Double temperatureCelsius) {
        TemperatureCelsius = temperatureCelsius;
    }

    public void setSunriseTime(String sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public void setSunsetTime(String sunsetTime) {
        this.sunsetTime = sunsetTime;
    }
}
