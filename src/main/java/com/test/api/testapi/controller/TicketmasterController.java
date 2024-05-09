package com.test.api.testapi.controller;

import com.test.api.testapi.model.Activity;
import com.test.api.testapi.services.TicketmasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketmasterController {

    @Autowired
    private TicketmasterService ticketmasterService;

    public TicketmasterController(TicketmasterService ticketmasterService) {
        this.ticketmasterService = ticketmasterService;
    }

    @GetMapping("/ticketmaster/{location}")
    public Activity getActivity(@PathVariable String location) {
        return ticketmasterService.getActivityByLocation(location);
    }
}
