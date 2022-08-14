package com.microservise.camelmicroservisesa.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//moves files from input into output
//@Component
public class FileRouter extends RouteBuilder {

    //file is defined as core class in camel

    @Override
    public void configure() throws Exception {
        from("file:files/input")
                .log("${body}")
                .to("file:files/output");
    }
}
