package pers.mike.kafka.main;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import pers.mike.kafka.dto.Greeting;

@Component
public class KafkaConsumer {
  @KafkaListener(
      topics = "test_mike",
      groupId = "foo",
      containerFactory = "kafkaListenerContainerFactory")
  public void listenGroupFoo(@Payload Greeting message) {
    System.out.println("Received Message in group foo: " + message);
  }
}
