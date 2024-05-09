package com.test.api.testapi.controller;

import com.test.api.testapi.model.Location;
import com.test.api.testapi.model.Weather;
import com.test.api.testapi.services.LocationService;
import com.test.api.testapi.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) { //constructor
        this.weatherService = weatherService;
    }


    @GetMapping("/weather/{location}") //its an endpoint to handle requests, getting weather by location
    public Weather getWeather(@PathVariable String location) {
        return weatherService.getWeatherByLocation(location); //this part calls weather service to fetch data
    }

    //database part
    @PostMapping("/location")
    public String saveLocationForUser(@RequestParam String locationName, @RequestParam String user) {
        Location location = new Location(); //creating new instance of location
        location.setLocation(locationName); //setting location and user
        location.setUser(user);
        locationService.saveLocation(location); //saving location
        return "OK!";
    }

    //a GET mapping API
    @GetMapping("/location")
    public List<Weather> getWeatherForUser(@RequestParam String user) {
        List<Weather> result = new ArrayList<>();
       locationService.getLocationsForUser(user).forEach(location ->{
           result.add(
           weatherService.getWeatherByLocation(location));
       });
        return result;

    }




}

