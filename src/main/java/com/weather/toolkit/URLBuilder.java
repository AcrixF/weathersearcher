package com.weather.toolkit;

import com.weather.model.weather.Coordinate;
import com.weather.model.weather.ZipCode;

import java.util.Optional;

public class URLBuilder {

    private static String weather_path;
    private static String keyAccess;

    private Integer city_Id;
    private String city_Name;
    private Coordinate coordinates;
    private ZipCode zip_code;

    /**
     * Default constructor
     */
    public URLBuilder() {}

    public Integer getCity_Id() {
        return city_Id;
    }

    public void setCity_Id(Integer city_Id) {
        this.city_Id = city_Id;
    }

    public String getCity_Name() {
        return city_Name;
    }

    public void setCity_Name(String city_Name) {
        this.city_Name = city_Name;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate coordinates) {
        this.coordinates = coordinates;
    }

    public ZipCode getZip_code() {
        return zip_code;
    }

    public void setZip_code(ZipCode zip_code) {
        this.zip_code = zip_code;
    }

    public static class Builder {

        private Integer city_Id;
        private String city_Name;
        private Coordinate coordinates;
        private ZipCode zip_code;


        /**
         * Partial constructor
         * @param weatherPath
         * @param key_Access
         */
        public Builder(String weatherPath, String key_Access) {
            weather_path = weatherPath;
            keyAccess = key_Access;
        }

        public Builder withCity_Name( String city_Name ) {
            this.city_Name = city_Name;
            return this;
        }

        public Builder withCity_Id( Integer city_Id ) {
            this.city_Id = city_Id;
            return this;
        }

        public Builder withZip_Code( ZipCode zip_code ) {
            this.zip_code = zip_code;
            return this;
        }

        public Builder withCoordinates(Coordinate coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        public URLBuilder build() {
            URLBuilder urlBuilder = new URLBuilder();
            urlBuilder.setCity_Id(Optional.ofNullable(city_Id).orElseGet( () -> -1));
            urlBuilder.setZip_code(Optional.ofNullable(zip_code).orElseGet( () -> null));
            urlBuilder.setCity_Name(Optional.ofNullable(city_Name).orElseGet(() -> ""));
            urlBuilder.setCoordinates(Optional.ofNullable(coordinates).orElseGet(() -> null));
            return urlBuilder;
        }

    }

    @Override
    public String toString() {
        int validation = 0;
        StringBuilder url = new StringBuilder(this.weather_path);

        if ( this.getCity_Id().longValue() != -1) {
            url.append("id=" + this.getCity_Id()).toString();
            validation++;
        } else if (!this.getCity_Name().equals("")) {
            url.append("q=");
            url.append(this.getCity_Name());
            validation++;
        } else if (this.getZip_code() != null) {
            url.append("zip=");
            url.append(this.getZip_code().getZip());
            url.append(",");
            url.append(this.getZip_code().getCountry_code());
            validation++;
        } else if ( this.getCoordinates() != null ) {
            url.append("lat=");
            url.append(this.getCoordinates().getLat().doubleValue());
            url.append("&");
            url.append("lon=");
            url.append(this.getCoordinates().getLon().doubleValue());
            validation++;
        }

        return validation == 1 ? url.append("&appid=").append(keyAccess).toString() : this.weather_path;

    }

}
