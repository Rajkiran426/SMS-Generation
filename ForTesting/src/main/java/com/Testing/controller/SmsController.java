package com.Testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Testing.payload.SmsRequest;
import com.Testing.services.TwilioService;

@RestController
public class SmsController {
    private final TwilioService twilioService;

    @Autowired
    public SmsController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @PostMapping("/send-sms")
    public ResponseEntity<String> sendSms(@RequestBody SmsRequest smsRequest) {
        twilioService.sendSms(smsRequest.getTo(), smsRequest.getMessage());
        return new ResponseEntity<>("Sms send sucussfully!",HttpStatus.OK);
    }
}

