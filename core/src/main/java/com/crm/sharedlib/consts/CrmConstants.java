package com.crm.sharedlib.consts;

@Deprecated(forRemoval = true)
public class CrmConstants {

    /**
     * @deprecated Use constants for HTTP Headers from {@link CrmHeaders}
     */
    @Deprecated(forRemoval = true)
    public final static String USER_ID_HEADER_NAME = "User-Id";

    /**
     * @deprecated Use constants for HTTP Headers from {@link CrmHeaders}
     */
    @Deprecated(forRemoval = true)
    public final static String USER_LOGIN_HEADER_NAME = "User-Login";

    /**
     * @deprecated Use constants for HTTP Headers from {@link CrmHeaders}
     */
    @Deprecated(forRemoval = true)
    public final static String ORGANIZATION_ID_HEADER_NAME = "Organization-Id";

    /**
     * @deprecated Use constants for RabbitMQ from RabbitMQConstants in module messaging
     */
    @Deprecated(forRemoval = true)
    public final static String SEND_PASSWORD_QUEUE = "notification-service.send-password";

    /**
     * @deprecated Use constants for RabbitMQ from RabbitMQConstants in module messaging
     */
    @Deprecated(forRemoval = true)
    public final static String SEND_WELCOME_EMAIL_QUEUE = "notification-service.send-welcome-email";

    /**
     * @deprecated Use constants for RabbitMQ from RabbitMQConstants in module messaging
     */
    @Deprecated(forRemoval = true)
    public final static String ORGANIZATION_USER_ROLES_SYNC_QUEUE = "auth-service.org-user-role-sync";

    /**
     * @deprecated Use constants for RabbitMQ from RabbitMQConstants in module messaging
     */
    @Deprecated(forRemoval = true)
    public final static String SEND_INVITATION_OF_ORGANIZATION = "notification-service.send-invitation-of-organization";

    /**
     * @deprecated Use constants for RabbitMQ from RabbitMQConstants in module messaging
     */
    @Deprecated(forRemoval = true)
    public final static String SEND_MESSAGE_QUEUE = "notification-service.send-message";

}
