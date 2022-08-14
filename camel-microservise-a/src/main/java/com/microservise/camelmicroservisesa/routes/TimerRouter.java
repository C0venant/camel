package com.microservise.camelmicroservisesa.routes;

import com.microservise.camelmicroservisesa.routes.beans.GetCurrentTimeBean;
import com.microservise.camelmicroservisesa.routes.beans.SimpleLoggingProcessingComponent;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component uncomment to start this router
public class TimerRouter extends RouteBuilder {

    //timer is defined as core class in camel

    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;

    @Autowired
    private SimpleLoggingProcessingComponent loggingProcessingComponent;

    @Override
    public void configure() throws Exception {
        //from is starting point
        //this is timer endpoint
        from("timer:first-timer")//message here is null
                //.transform().constant("Time now is" + LocalDateTime.now())
                .bean(getCurrentTimeBean)
                //.log("${body}")
                .bean(loggingProcessingComponent)
                //.bean(getCurrentTimeBean, "getCurrentTime") if we want to specify method name as well

                .to("log:first-timer");
    }
}

