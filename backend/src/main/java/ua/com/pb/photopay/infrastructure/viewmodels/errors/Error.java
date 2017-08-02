package ua.com.pb.photopay.infrastructure.viewmodels.errors;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public class Error {
    /**
     * Code of the error
     */
    private int status;
    /**
     * class or entity that caused exception
     */
    private String entity;

    /**
     * Constructor for error's model
     * @param status
     * @param entity
     */
    public Error(int status, String entity) {
        this.status = status;
        this.entity = entity;
    }

    /**
     * Default constructor
     */
    public Error() {
    }

    /**
     * Gets status of the error
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets status for error
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Gets entity that caused exception
     * @return entity name
     */
    public String getEntity() {
        return entity;
    }

    /**
     * Sets entity name for error
     * @param entity
     */
    public void setEntity(String entity) {
        this.entity = entity;
    }
}
