package com.example.email_service.service;

import com.example.email_service.dto.EmailRequest;

import java.time.LocalDateTime;

public interface EmailService {
    LocalDateTime sendSimpleEmail(EmailRequest emailRequest);
}
