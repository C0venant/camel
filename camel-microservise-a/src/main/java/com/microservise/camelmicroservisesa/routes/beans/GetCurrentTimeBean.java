package com.microservise.camelmicroservisesa.routes.beans;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GetCurrentTimeBean {

    //this is transforming because message is getting changed
    public String getCurrentTime() {
        return "Time now is " + LocalDateTime.now();
    }
}
