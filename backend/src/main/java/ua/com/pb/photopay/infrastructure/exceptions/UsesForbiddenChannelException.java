package ua.com.pb.photopay.infrastructure.exceptions;

/**
 * Created by dn110592kvo on 24.05.2017.
 */
public class UsesForbiddenChannelException extends Exception {
    public final static int CODE = 4005;
    public final String entity;

    public UsesForbiddenChannelException(String entity) {
        super("Forbidden delivery channel " + entity);
        this.entity = entity;
    }
}
