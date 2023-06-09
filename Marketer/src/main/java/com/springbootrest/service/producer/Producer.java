package com.springbootrest.service.producer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootrest.model.Marketer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {
    private static final String marketerTopic = "t.customer";
    private final ObjectMapper objectMapper;    // java object to JSON
    private final KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String,String> kafkaTemplate,ObjectMapper objectMapper){
        this.kafkaTemplate= kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendMessage(Marketer marketer) throws JsonProcessingException{
        String MarketerAsMessage = objectMapper.writeValueAsString(marketer);
        kafkaTemplate.send(marketerTopic,MarketerAsMessage);
        log.info("Marketer produced {}",MarketerAsMessage);
        return "has been sent";
    }

}
