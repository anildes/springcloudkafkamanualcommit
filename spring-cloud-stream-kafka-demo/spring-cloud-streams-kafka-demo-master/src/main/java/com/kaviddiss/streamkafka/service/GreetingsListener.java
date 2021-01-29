package com.kaviddiss.streamkafka.service;

import com.kaviddiss.streamkafka.model.Greetings;
import com.kaviddiss.streamkafka.stream.GreetingsStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingsListener {
    /*@StreamListener(target = GreetingsStreams.INPUT)
    public void handleGreetings(@Payload Greetings greetings)
    {
        Acknowledgment acknowledgment = greetings.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            System.out.println("Acknowledgment provided...............");
            acknowledgment.acknowledge();
        }
        log.info("Received greetings: {}", greetings);
    }*/
    @StreamListener(target = GreetingsStreams.INPUT)
    public void process(Message<?> message)
    {
        System.out.println(message.getPayload());
        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            System.out.println("Acknowledgment provided...............");
            acknowledgment.acknowledge();
        }
    }

}
