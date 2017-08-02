package ua.com.pb.photopay.infrastructure.exceptions;

/**
 * Created by dn110592kvo on 24.05.2017.
 */
public class CanNotCreateEntityException extends Exception {
    /**
     * unique code of such error
     */
    public final static int CODE = 4001;
    /**
     * Entity that caused exception
     */
    public final String entity;

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param entity the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public CanNotCreateEntityException(String entity) {
        super("Attempt to create entity " + entity + "without permission!");
        this.entity = entity;
    }
}
