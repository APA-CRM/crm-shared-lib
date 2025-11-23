package com.crm.sharedlib.service;

import com.crm.sharedlib.consts.CrmConstants;
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

@Service
@RequiredArgsConstructor
@Slf4j
public class MessagingService {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessageToUser(Long userId, String messageType, String message) {
        sendMessageToUser(userId, messageType, message, null);
    }

    public void sendMessageToUser(
            Long userId, String messageType,
            String message, @Nullable Map<String, Object> details
    ) {
        sendMessage(
                new CrmRecipient(userId, RecipientType.USER),
                messageType, message, details
        );
    }

    public void sendMessageToOrganization(Long organizationId, String messageType, String message) {
        sendMessageToOrganization(organizationId, messageType, message, null);
    }

    public void sendMessageToOrganization(
            Long organizationId, String messageType,
            String message, @Nullable Map<String, Object> details
    ) {
        sendMessage(
                new CrmRecipient(organizationId, RecipientType.ORGANIZATION),
                messageType, message, details
        );
    }

    private void sendMessage(
            CrmRecipient recipient, String messageType,
            String message, @Nullable Map<String, Object> details
    ) {
        log.debug("Sending message of type {} to recipient type {} with ID {}",
                messageType, recipient.getType(), recipient.getId()
        );

        CrmNotification crmNotification = CrmNotification.builder()
                .recipient(recipient)
                .message(new CrmMessage(messageType, message))
                .details(details)
                .build();

        rabbitTemplate.convertAndSend(CrmConstants.SEND_MESSAGE_QUEUE, crmNotification);
    }

}
