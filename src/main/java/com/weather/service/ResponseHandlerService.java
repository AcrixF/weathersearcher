package com.weather.service;

import com.weather.model.weather.City;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ResponseHandlerService {

    /**
     * @param <T>
     * @return
     */
    public <T extends RuntimeException> Function<T, City> handleRuntimeException () {
        return (e) -> {
            String error = e.getMessage();
            City city = new City();
            city.setCod(Long.valueOf(error.split(" ")[0]));
            city.setMessage( e.getMessage() );
            return city;
        };
    }

}
