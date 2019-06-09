package com.weather.toolkit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class Utils {

    @Value("${weather.url.path}")
    private String weather_path;

    private DecimalFormat decimalFormatGrades = new DecimalFormat("#.##");

    public boolean validateURL(String URL) {
        String urlTemp = URL.substring(0, URL.indexOf("?") + 1);
        if ( !weather_path.equals( urlTemp ) ) {
            return false;
        }

        if (URL.length() == weather_path.length() ) {
            return false;
        }

        return true;
    }

    public String LocalDateTimeFormatter(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return  time.format(formatter);
    }

    public Double kelvinToCelsius(Double kelvin ) {
        return Double.valueOf(decimalFormatGrades.format(kelvin - 273.5));
    }

    public Double kelvinToFahrenheit(Double kelvin) {
        return Double.valueOf(decimalFormatGrades.format(((kelvin - 273) * 9/5) + 32));
    }

    public String timeFormatter(Long time) {
        Date currentTime = new Date(time * 1000);;
        return new SimpleDateFormat("hh:mm a").format( currentTime );
    }

}
