package ua.com.pb.photopay.infrastructure.exceptions;

import java.util.List;

import static ua.com.pb.photopay.infrastructure.constants.Constants.Error.INDICATIVE_NOT_FOUND;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public class IndicativeNotFoundException extends Exception {
    /**
     * unique code of such error
     */
    public final static int CODE = INDICATIVE_NOT_FOUND;
    /**
     * Entity that caused exception
     */
    public final String branchName;


    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param branchName list of incorrect fields
     */
    public IndicativeNotFoundException(String branchName) {
        super("For branch " + branchName + " indicative was not found");
        this.branchName = branchName;
    }
}
