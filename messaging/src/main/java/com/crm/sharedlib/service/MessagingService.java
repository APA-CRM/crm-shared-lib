package com.crm.sharedlib.service;

import com.crm.sharedlib.dto.CrmMessage;
import com.crm.sharedlib.dto.CrmNotification;
import com.crm.sharedlib.dto.CrmRecipient;
import com.crm.sharedlib.enums.RecipientType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.crm.sharedlib.constants.RabbitMQConstants.SEND_MESSAGE_QUEUE;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessagingService {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessageToUser(Long userId, String messageCode, String message) {
        sendMessageToUser(userId, messageCode, message, null);
    }

    public void sendMessageToUser(
            Long userId, String messageCode,
            String message, @Nullable Map<String, Object> details
    ) {
        sendMessage(
                new CrmRecipient(userId, RecipientType.USER),
                messageCode, message, details
        );
    }

    public void sendMessageToOrganization(Long organizationId, String messageCode, String message) {
        sendMessageToOrganization(organizationId, messageCode, message, null);
    }

    public void sendMessageToOrganization(
            Long organizationId, String messageCode,
            String message, @Nullable Map<String, Object> details
    ) {
        sendMessage(
                new CrmRecipient(organizationId, RecipientType.ORGANIZATION),
                messageCode, message, details
        );
    }

    private void sendMessage(
            CrmRecipient recipient, String messageCode,
            String message, @Nullable Map<String, Object> details
    ) {
        log.debug("Sending message of code {} to recipient type {} with ID {}",
                messageCode, recipient.getType(), recipient.getId()
        );

        CrmNotification crmNotification = CrmNotification.builder()
                .recipient(recipient)
                .message(new CrmMessage(messageCode, message, details))
                .build();

        rabbitTemplate.convertAndSend(SEND_MESSAGE_QUEUE, crmNotification);
    }

}
