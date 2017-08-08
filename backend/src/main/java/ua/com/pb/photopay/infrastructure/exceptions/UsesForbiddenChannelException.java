package ua.com.pb.photopay.infrastructure.exceptions;

import static ua.com.pb.photopay.infrastructure.constants.Constants.Error.FORBIDDEN_CHANNEL;

/**
 * Created by dn110592kvo on 24.05.2017.
 */
public class UsesForbiddenChannelException extends Exception {
    public final static int CODE = FORBIDDEN_CHANNEL;
    public final String entity;

    public UsesForbiddenChannelException(String entity) {
        super("Forbidden delivery channel " + entity);
        this.entity = entity;
    }
}
