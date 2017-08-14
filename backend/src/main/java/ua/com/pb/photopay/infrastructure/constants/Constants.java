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

    public static class Error {
        public final static int CANNOT_CREATE_ENTITY = 4001;
        public final static int ENTITY_ALREADY_EXIST = 4002;
        public final static int ENTITY_NOT_FOUND = 4003;
        public final static int INDICATIVE_NOT_FOUND = 4006;
        public final static int INVALID_DATA = 4004;
        public final static int FORBIDDEN_CHANNEL = 4005;

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

    public static class FieldsConstraints {

        public static class ServiceGroup {
            public final static int NAME_MIN_LENGTH = 5;
            public final static int NAME_MAX_LENGTH = 30;

        }

        public static class AuxiliaryField {
            public final static int NAME_MIN_LENGTH = 5;
            public final static int NAME_MAX_LENGTH = 30;
        }

        public static class ServiceType {
            public final static int NAME_MIN_LENGTH = 5;
            public final static int NAME_MAX_LENGTH = 30;
            public final static int NOMENCLATURE_MIN_LENGTH = 5;
            public final static int NOMENCLATURE_MAX_LENGTH = 10;
        }
    }

}
