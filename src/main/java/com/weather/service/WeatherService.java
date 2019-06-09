package com.weather.service;

import com.weather.model.response.WeatherResponse;
import com.weather.model.weather.City;
import com.weather.model.weather.Coordinate;
import com.weather.model.weather.ZipCode;
import com.weather.toolkit.URLBuilder;
import com.weather.toolkit.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class WeatherService {

    @Value("${weather.key.access}")
    public String weather_key_access;
    @Value("${weather.url.path}")
    public String weather_path;

    private RestTemplate restTemplate;
    private Utils utils;
    private ResponseHandlerService responseHandlerService;

    @Autowired
    public WeatherService(RestTemplate restTemplate, ResponseHandlerService responseHandlerService, Utils utils) {
        this.restTemplate = restTemplate;
        this.responseHandlerService = responseHandlerService;
        this.utils = utils;
    }

    public City getWeatherByCityId(Integer city_id) {
        City city = null;
        try {
            URLBuilder urlBuilder = new URLBuilder
                    .Builder(weather_path, weather_key_access)
                    .withCity_Id( city_id )
                    .build();

            if( utils.validateURL( urlBuilder.toString() ) ) {
                ResponseEntity<City> r = restTemplate.getForEntity(urlBuilder.toString(), City.class);
                city = r.getBody();
            } else {
                throw new IllegalArgumentException("400 Bad Request-Invalid URL");
            }
        } catch (RuntimeException e ) {
            city = responseHandlerService.handleRuntimeException().apply(e);
        }
        return city;
    }

    public City getWeatherByCityName(String cityName) {
        City city = null;
        try {
            URLBuilder urlBuilder = new URLBuilder
                    .Builder(weather_path, weather_key_access)
                    .withCity_Name( cityName )
                    .build();

            if( utils.validateURL( urlBuilder.toString() ) ) {
                ResponseEntity<City> r = restTemplate.getForEntity(urlBuilder.toString(), City.class);
                city = r.getBody();
            } else {
                throw new IllegalArgumentException("400 Bad Request-Invalid URL");
            }
        } catch (RuntimeException e ) {
           city = responseHandlerService.handleRuntimeException().apply(e);
        }
        return city;
    }

    public City getWeatherByZipCode(Long zip_code, String country_code) {
        City city = null;
        ZipCode zipCode = new ZipCode(zip_code, country_code);
        try {
            URLBuilder urlBuilder = new URLBuilder
                    .Builder(weather_path, weather_key_access)
                    .withZip_Code( zipCode )
                    .build();

            if( utils.validateURL( urlBuilder.toString() ) ) {
                ResponseEntity<City> r = restTemplate.getForEntity(urlBuilder.toString(), City.class);
                city = r.getBody();
            } else {
                throw new IllegalArgumentException("400 Bad Request-Invalid URL");
            }
        } catch ( RuntimeException e ) {
            city = responseHandlerService.handleRuntimeException().apply(e);
        }
        return city;
    }


    public City getWeatherByCoordinates(Double lat, Double lon) {
        City city = null;
        Coordinate coordinate = new Coordinate(lat, lon);
        try {
            URLBuilder urlBuilder = new URLBuilder
                    .Builder(weather_path, weather_key_access)
                    .withCoordinates( coordinate )
                    .build();

            if( utils.validateURL( urlBuilder.toString() ) ) {
                ResponseEntity<City> r = restTemplate.getForEntity(urlBuilder.toString(), City.class);
                city = r.getBody();
            } else {
                throw new IllegalArgumentException("400 Bad Request-Invalid URL");
            }

        } catch ( RuntimeException e) {
            city = responseHandlerService.handleRuntimeException().apply(e);
        }
        return city;
    }


    public WeatherResponse applyStandardResponse(WeatherResponse weatherResponse) {
        City city = weatherResponse.getCity();

        if( weatherResponse.getCode().intValue() == 200) {
            weatherResponse.setTodayDate(utils.LocalDateTimeFormatter(LocalDateTime.now()));
            weatherResponse.setCityName(city.getName());
            weatherResponse.setWeatherDescription(city.getWeather().get(0).getDescription());
            weatherResponse.setTemperatureFahrenheit(utils.kelvinToFahrenheit(city.getMain().getTemp().doubleValue()));
            weatherResponse.setTemperatureCelsius(utils.kelvinToCelsius(city.getMain().getTemp().doubleValue()));
            weatherResponse.setSunsetTime(utils.timeFormatter(city.getSys().getSunset()));
            weatherResponse.setSunriseTime(utils.timeFormatter(city.getSys().getSunrise()));
            weatherResponse.setMsg("Ok");
        } else {
            weatherResponse.setMsg("Not Data Available for the Search.");
        }
        return weatherResponse;
    }
}
