package com.crm.sharedlib.messaging.constants;

public class RabbitMQConstants {

    public static final String MAIN_SERVICE_EXCHANGER_NAME = "main-service.events";

    public static final String FILE_SERVICE_EXCHANGE_NAME = "file-service.events";

    public final static String SEND_PASSWORD_QUEUE = "notification-service.send-password";

    public final static String SEND_VERIFICATION_CODE_QUEUE = "notification-service.send-verification-code";

    public final static String SEND_WELCOME_EMAIL_QUEUE = "notification-service.send-welcome-email";

    public final static String ORGANIZATION_USER_ROLES_SYNC_QUEUE = "auth-service.org-user-role-sync";

    public final static String SEND_MESSAGE_QUEUE = "notification-service.send-message";

    public final static String CREATE_ROOT_DIR_QUEUE = "file-service.create-organization-root-dir";

    public final static String ROOT_DIR_CREATED_REPLY_QUEUE = "main-service.create-root-dir-for-organization";

    public static final String ORGANIZATION_USER_ROLE_CHANGE_ROUTING_KEY = "org-user.role-changes";

    public static final String ORGANIZATION_INVITATION_CREATED_ROUTING_KEY = "org-invitation.created";

    public static final String ORGANIZATION_CREATED_ROUTING_KEY = "org.created";

    public static final String ORGANIZATION_ROOT_DIR_CREATE_ROUTING_KEY = "org.root-dir.created";

    /**
     * @deprecated Use instead {@link RabbitMQConstants#SEND_INVITATION_OF_ORGANIZATION_ROUTING_KEY}
     */
    @Deprecated
    public final static String SEND_INVITATION_OF_ORGANIZATION = "notification-service.send-invitation-of-organization";

    public final static String SEND_INVITATION_OF_ORGANIZATION_ROUTING_KEY = "notification-service.send-invitation-of-organization";

}
