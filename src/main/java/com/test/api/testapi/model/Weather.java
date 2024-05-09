package com.test.api.testapi.model;

import lombok.Data;

@Data
public class Weather {
    private double temp;
    private double humidity;

    private double windSpeed;


//    public double getTemp() {
//        return temp;
//    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
