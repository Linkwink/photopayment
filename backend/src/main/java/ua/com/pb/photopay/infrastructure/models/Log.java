package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by dn110592kvo on 03.07.2017.
 * Gets action's type  of the log
 */
@Entity
@Table(name = "log")
public class Log {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Date of creation
     */
    private LocalDateTime created;
    /**
     * Defines whether initiator read this log
     */
    private boolean isNew;
    /**
     * Defines whether someone of admins read lod
     */
    private boolean isNewForAdmin;

    /**
     * Actions that caused logging
     */
    @ManyToOne
    @JoinColumn(name = "user_action_id")
    private UserActionType userAction;
    /**
     * User that caused logging
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    /**
     * Application id which caused logging
     */
    private int applicationId;

    public Log() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isNewForAdmin() {
        return isNewForAdmin;
    }

    public void setNewForAdmin(boolean newForAdmin) {
        isNewForAdmin = newForAdmin;
    }

    public UserActionType getUserAction() {
        return userAction;
    }

    public void setUserAction(UserActionType userAction) {
        this.userAction = userAction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }
}
