package com.test.api.testapi.services;

import com.test.api.testapi.model.Weather;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {

    @Autowired
    private WeatherService weatherService;
    @Autowired
    private RestTemplate restTemplate;

    @Test //a test for making sure a valid location is entered
    void getWeatherByValidLocation() { //testing input for valid location
        weatherService = new WeatherService(new RestTemplate());
        Weather weather = weatherService.getWeatherByLocation("London");
        assertNotNull(weather); //basically checking that the weather for London exists
    }

    @Test //a test for checking that response time is less than 1 second
    void responseTime(){ //testing
        weatherService = new WeatherService(new RestTemplate());
        long startTime = System.currentTimeMillis(); //gets current time
        Weather weather = weatherService.getWeatherByLocation("London");
        long endTime = System.currentTimeMillis(); //gets current time after getting weather
        assertTrue(endTime - startTime < 1000); //checking response time is under 1 second
    }

}