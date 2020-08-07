package com.altran.kafkapublisher.Service;

import com.altran.kafkapublisher.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    /*@Autowired
    private KafkaTemplate<String,String> kafkaTemplate;*/

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplateObject;

    String kafkaTopic = "kafka_micro";

    /*public void send(String message){
        kafkaTemplate.send(kafkaTopic,message);
    }*/

    public void sendJson(User user) {
        kafkaTemplateObject.send(kafkaTopic,user);
    }
}
