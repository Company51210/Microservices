package com.altran.kafkapublisher.controller;

import com.altran.kafkapublisher.Service.KafkaProducer;
import com.altran.kafkapublisher.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PublisherController {

    @Autowired
    private KafkaProducer kafkaProducer;

    /*@GetMapping("greet/{name}")
    public String publishMessage(@PathVariable String name){
        kafkaProducer.send("Welcome Mr " + name);
        return "Data published to Kafka Topic";
    }*/

    @PostMapping("/greetuser")
    public String publishjsonMessage(@RequestBody User user){
        kafkaProducer.sendJson(user);
        return "Data published to Kafka Topic";
    }
    
}
