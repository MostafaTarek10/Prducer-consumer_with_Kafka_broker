package com.springbootrest.service.consumer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootrest.model.dto.CustomerDto;
import com.springbootrest.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    private static final String customerTopic = "t.customer";
    private final ObjectMapper objectMapper;    //JSON to java object
    private final CustomerService customerService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, CustomerService customerService) {
        this.objectMapper = objectMapper;
        this.customerService = customerService;
    }

    @KafkaListener(topics = customerTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed  {}",message);
        CustomerDto customerDto = objectMapper.readValue(message, CustomerDto.class);
        if(customerDto.isDelete()){
            customerService.deleteById(customerDto.getId());
        }
        else{
        customerService.persistOffer(customerDto);
    }
    }

}