package com.test.api.testapi.model;

import lombok.Data;

@Data
public class Ticketmaster {
    private Embedded _embedded;
    private Events events;

    public Events getEvents() {
        return events;
    }

}
