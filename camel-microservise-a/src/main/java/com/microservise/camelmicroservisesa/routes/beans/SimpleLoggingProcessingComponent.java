package com.microservise.camelmicroservisesa.routes.beans;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SimpleLoggingProcessingComponent {

    //this is processing because it does not change message
    public void process(String message) {
        log.info(message);
    }
}
