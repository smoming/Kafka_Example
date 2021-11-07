package pers.mike.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.mike.kafka.dto.Greeting;
import pers.mike.kafka.main.KafkaProducer;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/producer")
public class ProducerController {
  @Autowired private KafkaProducer producer;

  @PostMapping("/send")
  public String doSend() {
    try {
      IntStream.rangeClosed(1, 10)
          .boxed()
          .collect(Collectors.toList())
          .forEach(
              i -> {
                Greeting greeting = new Greeting();
                greeting.setName("user_" + i);
                greeting.setMsg(String.format("doing sending {%s} message~", i));
                producer.sendMessage(greeting);
              });
    } catch (Exception e) {
      System.err.println("error:" + e.getMessage());
    }
    return "do sending...";
  }
}
