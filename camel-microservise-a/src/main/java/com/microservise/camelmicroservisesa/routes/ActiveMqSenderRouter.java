package com.microservise.camelmicroservisesa.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//requires active mq
@Component
public class ActiveMqSenderRouter extends RouteBuilder {

    //timer is defined as core class in camel
    //activemq is not defined so it should be created

    @Override
    public void configure() throws Exception {
        //timer 5 seconds
        //send message to activemq queue
        from("timer:active-mq-timer?period=5000")
                .transform().constant("my message to mq")
                .to("activemq:my-activemq-queue");
    }
}
