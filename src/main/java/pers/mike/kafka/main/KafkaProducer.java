package pers.mike.kafka.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import pers.mike.kafka.config.KafkaConfig;
import pers.mike.kafka.dto.Greeting;

@Component
public class KafkaProducer {
  @Autowired private KafkaTemplate<String, Greeting> kafkaTemplate;

  public void sendMessage(Greeting msg) {
    KafkaConfig config = KafkaConfig.getConfig();
    ListenableFuture<SendResult<String, Greeting>> future =
        kafkaTemplate.send(config.getTopicName(), msg);

    future.addCallback(
        new ListenableFutureCallback<SendResult<String, Greeting>>() {
          @Override
          public void onSuccess(SendResult<String, Greeting> result) {
            System.out.println(
                "Sent message=["
                    + msg
                    + "] with offset=["
                    + result.getRecordMetadata().offset()
                    + "]");
          }

          @Override
          public void onFailure(Throwable ex) {
            System.out.println("Unable to send message=[" + msg + "] due to : " + ex.getMessage());
          }
        });
  }
}
