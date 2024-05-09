package com.test.api.testapi.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Embedded {

    private Events[] events;

    public Events[] getEvents() {
        return events;
    }
    public void setEvents(Events[] events) {
        this.events = events;
    }
}
