package com.test.api.testapi.services;

import com.test.api.testapi.model.OpenWeather;
import com.test.api.testapi.model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

//    @Value("${openweathermap.api.key}") //injecting api key from application.properties?
    private String apiKey = "5a65bd8d57af37a45d768361543fe737";

    private final RestTemplate restTemplate; //rest template bean is used to make HTTP requests

    public WeatherService(RestTemplate restTemplate) { //constructor
        this.restTemplate = restTemplate;
    }

    public Weather getWeatherByLocation(String location){
        try{
        String url = "http://api.openweathermap.org/data/2.5/weather?q={location}&appid=" + apiKey + "&units=metric"; // constructs the url for the openweathermap api with placeholder for city and api key
        //makes get request to openweathermap api and deserialize json response into weather object
        OpenWeather openweather = restTemplate.getForObject(url, OpenWeather.class, location);
        Weather weather = new Weather();
        weather.setTemp(openweather.getMain().getTemp());
        weather.setHumidity(openweather.getMain().getHumidity());
        weather.setWindSpeed(openweather.getWind().getSpeed());
        return weather;
    } catch (HttpClientErrorException | HttpServerErrorException e) { //this handles http client or server errors, these errors are specific to rest template
           System.out.print("An exception occurred: ");
            e.printStackTrace(); //prints stack trace
            return null;
        } catch (Exception e) { //catches any other exceptions
            e.printStackTrace();
            return null;
        }
    }



}
