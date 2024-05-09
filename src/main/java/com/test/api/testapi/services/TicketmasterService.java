package com.test.api.testapi.services;

import com.test.api.testapi.model.Activity;
import com.test.api.testapi.model.Ticketmaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TicketmasterService {

    private String apiKey = "M8lXIakyAqTtySy07ZvdnXpPe3Lrsqx9";

    @Autowired
    private final RestTemplate restTemplate;

    public TicketmasterService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Activity getActivityByLocation(String location){
        String url = "https://app.ticketmaster.com/discovery/v2/events.json?city={location}&apikey=M8lXIakyAqTtySy07ZvdnXpPe3Lrsqx9";
        Ticketmaster ticketmaster = restTemplate.getForObject(url, Ticketmaster.class, location);
        Activity activity = new Activity();
//        activity.setActivityName(ticketmaster.getEmbedded().getEvents().get(0).getName());
        return activity;
    }






}
