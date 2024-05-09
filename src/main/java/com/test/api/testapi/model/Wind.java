package com.test.api.testapi.model;

import lombok.Data;

@Data // importing this allows lombok to generate getters and setters automatically
public class Wind {
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
