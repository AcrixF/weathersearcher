package com.weather.model.weather;

public class Wind {

    private Double speed;
    private Long deg;

    /**
     * Default constructor
     */
    public Wind() {}

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Long getDeg() {
        return deg;
    }

    public void setDeg(Long deg) {
        this.deg = deg;
    }

}
