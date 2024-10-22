package com.colak.springtutorial.controller;

import com.colak.springtutorial.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class IntegrationController {

    private final MessageProducer messageProducer;

    // http://localhost:8080/api/test-integration
    @GetMapping("/test-integration")
    public ResponseEntity<Object> testIntegrationMessaging() {
        String message = "test";
        String result = messageProducer.sendMessage(message);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
