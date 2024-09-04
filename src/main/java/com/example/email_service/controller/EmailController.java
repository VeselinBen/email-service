package com.example.email_service.controller;

import com.example.email_service.dto.EmailRequest;
import com.example.email_service.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emails")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<LocalDateTime> sendEmail(@RequestBody EmailRequest request) {
        return ResponseEntity.ok(emailService.sendSimpleEmail(request));
    }
}
