package com.crm.sharedlib.messaging.dto.amqp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskReminderMessage {

    private UUID taskId;

    private String title;

    private String statusName;

    private Long organizationId;

    private String organizationName;

    private TaskExtraInfo status;

    private TaskExtraInfo priority;

    private Instant dueDate;

    private Instant createdAt;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TaskExtraInfo {

        private String name;

        private String color;

    }

}
