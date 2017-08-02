package ua.com.pb.photopay.infrastructure.constants;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public class Constants {

    public static class Roles {
        public final static String ROLE_ADMIN = "ADMIN";
        public final static String ROLE_MODERATOR = "MODERATOR";
        public final static String ROLE_ACCOUNTANT = "ACCOUNTANT";
        public final static String ROLE_MANAGER = "MANAGER";
        public final static String ROLE_GUEST = "GUEST";
    }

    public static class DeliveryChannel {
        public final static int EMAIL = 1;
        public final static int VIBER = 2;
        public final static int SENDER = 3;
    }

    public static class ApplicationStatus {
        public final static String NEW = "NEW";
        public final static String WAIT_FOR_PROCESS = "WAIT_FOR_PROCESS";
        public final static String PROCESSED = "PROCESSED";
        public final static String DEFFERED = "DEFFERED";
        public final static String ACCOUNTER_IN_PROCESSING = "ACCOUNTER_IN_PROCESSING";
        public final static String WAIT_FOR_ADDITION = "WAIT_FOR_ADDITION";
    }

}
