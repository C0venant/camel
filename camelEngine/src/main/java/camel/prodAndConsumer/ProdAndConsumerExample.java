package camel.prodAndConsumer;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class ProdAndConsumerExample {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start")
                        .process(exchange -> {
                           var message = exchange.getIn().getBody(String.class);
                           message += " modified by processor";
                           exchange.getIn().setBody(message);
                        })
                        .to("seda:end");
            }
        });

        context.start();

        ProducerTemplate producerTemplate = context.createProducerTemplate();

        producerTemplate.sendBody("direct:start", "Hello from producer");

        ConsumerTemplate consumerTemplate = context.createConsumerTemplate();

        String result = consumerTemplate.receiveBody("seda:end", String.class);


        System.out.println("result from consumer: " + result);
    }
}
