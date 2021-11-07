package pers.mike.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"pers.mike.kafka"})
public class KafkaApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaApplication.class, args);
    init();
  }

  private static void init() {
    System.out.println("###########################");
    System.out.println("#                         #");
    System.out.println("#  Spring Boot Activated  #");
    System.out.println("#                         #");
    System.out.println("###########################");
  }
}
