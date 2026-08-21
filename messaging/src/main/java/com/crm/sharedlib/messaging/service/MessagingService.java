package com.crm.sharedlib.messaging.service;

import com.crm.sharedlib.messaging.dto.CrmMessage;
import com.crm.sharedlib.messaging.dto.CrmNotification;
import com.crm.sharedlib.messaging.dto.CrmRecipient;
import com.crm.sharedlib.messaging.enums.RecipientType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.crm.sharedlib.messaging.constants.RabbitMQConstants.SEND_MESSAGE_QUEUE;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessagingService {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessageToUser(
            Long userId, String title,
            String messageCode, String message
    ) {
        sendMessageToUser(userId, title, messageCode, message, null);
    }

    public void sendMessageToUser(
            Long userId, String title, String messageCode,
            String message, @Nullable Map<String, Object> details
    ) {
        sendMessage(
                new CrmRecipient(userId, RecipientType.USER),
                title, messageCode, message, details
        );
    }

    public void sendMessageToOrganization(
            Long organizationId, String title,
            String messageCode, String message
    ) {
        sendMessageToOrganization(organizationId, title, messageCode, message, null);
    }

    public void sendMessageToOrganization(
            Long organizationId, String title, String messageCode,
            String message, @Nullable Map<String, Object> details
    ) {
        sendMessage(
                new CrmRecipient(organizationId, RecipientType.ORGANIZATION),
                title, messageCode, message, details
        );
    }

    private void sendMessage(
            CrmRecipient recipient,
            String title, String messageCode, String message,
            @Nullable Map<String, Object> details
    ) {
        log.debug("Sending message of code {} to recipient type {} with ID {}",
                messageCode, recipient.getType(), recipient.getId()
        );

        try {
            CrmNotification crmNotification = CrmNotification.builder()
                    .recipient(recipient)
                    .message(new CrmMessage(title, messageCode, message, details))
                    .build();

            rabbitTemplate.convertAndSend(SEND_MESSAGE_QUEUE, crmNotification);

            log.debug("A message of code {} to recipient type {} with ID {} has been sent",
                    messageCode, recipient.getType(), recipient.getId()
            );
        } catch (Exception e) {
            log.error("A message of code {} to recipient type {} with ID {} has not been sent",
                    messageCode, recipient.getType(), recipient.getId(), e
            );
        }
    }

}
