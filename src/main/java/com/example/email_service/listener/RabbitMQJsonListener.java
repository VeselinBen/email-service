package com.example.email_service.listener;

import com.example.email_service.dto.EmailRequest;
import com.example.email_service.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class RabbitMQJsonListener {

    private static final Logger LOGGER = Logger.getLogger(RabbitMQJsonListener.class.getName());

    private final EmailService emailService;

    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void consume(EmailRequest emailRequest) {
        LOGGER.info(String.format("Consumed: %s", emailRequest.toString()));
        emailService.sendSimpleEmail(emailRequest);
    }
}
