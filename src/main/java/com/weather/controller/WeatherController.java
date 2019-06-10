package com.weather.controller;

import com.weather.model.response.WeatherResponse;
import com.weather.model.weather.City;
import com.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService weatherService;

    /**
     * @param weatherService
     */
    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * @param city_id
     * @return
     */
    @GetMapping("cities/{city_id}")
    public WeatherResponse getWeatherById(@PathVariable(name = "city_id", required = true) Integer city_id ) {
        WeatherResponse weatherResponse = null;
        if( city_id != null ) {
            City cityWeather = weatherService.getWeatherByCityId(city_id);
            weatherResponse = weatherService.applyStandardResponse(new WeatherResponse(cityWeather.getCod(), cityWeather.getMessage(), cityWeather));

        } else {
            weatherResponse = new WeatherResponse();
            weatherResponse.setCode(400L);
            weatherResponse.setMsg("Bad Request");
        }

        return weatherResponse;
    }

    /**
     * @param city_name
     * @return
     */
    @GetMapping("cities/name/{city_name}")
    public WeatherResponse getWeatherByCityName(@PathVariable(name = "city_name", required = true) String city_name ) {
        WeatherResponse weatherResponse = null;
        if( city_name != null ) {
            City cityWeather = weatherService.getWeatherByCityName(city_name);
            weatherResponse = weatherService.applyStandardResponse(new WeatherResponse(cityWeather.getCod(), cityWeather.getMessage(), cityWeather));
        } else {
            weatherResponse = new WeatherResponse();
            weatherResponse.setCode(400L);
            weatherResponse.setMsg("Bad Request");
        }

        return weatherResponse;
    }

    /**
     * @param zip_code
     * @param country_code
     * @return
     */
    @GetMapping("cities/zipcode/{zip_code}/countrycode/{country_code}")
    public WeatherResponse getWeatherByZipCode(@PathVariable(name = "zip_code", required = true) Long zip_code, @PathVariable(name = "country_code", required = true) String country_code ) {
        WeatherResponse weatherResponse = null;
        if( zip_code != null && country_code != null ) {
            City cityWeather = weatherService.getWeatherByZipCode(zip_code, country_code);
            weatherResponse = weatherService.applyStandardResponse(new WeatherResponse(cityWeather.getCod(), cityWeather.getMessage(), cityWeather));
        } else {
            weatherResponse = new WeatherResponse();
            weatherResponse.setCode(400L);
            weatherResponse.setMsg("Bad Request");
        }
        return weatherResponse;
    }

    /**
     * @param lat
     * @param lon
     * @return
     */
    @GetMapping("cities/coord/{lat}/{lon}")
    public WeatherResponse getWeatherByCoordinates(@PathVariable(name = "lat") Double lat, @PathVariable(name = "lon") Double lon ) {
        WeatherResponse weatherResponse = null;
        if( lat != null && lon != null ) {
            City cityWeather = weatherService.getWeatherByCoordinates(lat, lon);
            weatherResponse = weatherService.applyStandardResponse(new WeatherResponse(cityWeather.getCod(), cityWeather.getMessage(), cityWeather));
        } else {
            weatherResponse = new WeatherResponse();
            weatherResponse.setCode(400L);
            weatherResponse.setMsg("Bad Request");
        }
        return weatherResponse;
    }

}
