package com.springbootrest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springbootrest.model.Marketer;
import com.springbootrest.service.MarketerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/marketers")
public class MarketerController {

    private final MarketerService marketerService;

    @Autowired
    public MarketerController(MarketerService marketerService) {
        this.marketerService = marketerService;
    }


    // http://localhost:8080/api/marketers
    @PostMapping
    public String save(@RequestBody Marketer e) throws JsonProcessingException {
        log.info("Marketer persisted product offer successfully {}");
        return marketerService.save(e) + " Marketer saved successfully";
    }
    // http://localhost:8080/api/marketers/delete
    @DeleteMapping("/delete")
    public String deletemarketer(@RequestBody Marketer e) throws JsonProcessingException {
         log.info("Marketer deleted product offer successfully {}");
         e.setDelete(true);
        return marketerService.save(e) + " Marketer deleted product offer successfully";
    }

}