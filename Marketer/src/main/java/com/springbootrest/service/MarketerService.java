package com.springbootrest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springbootrest.model.Marketer;
import com.springbootrest.service.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MarketerService {

    private final Producer producer;

    @Autowired
    public MarketerService(Producer producer) {
        this.producer = producer;
    }

    public String save(Marketer e) throws JsonProcessingException {
        return producer.sendMessage(e);
    }


}
