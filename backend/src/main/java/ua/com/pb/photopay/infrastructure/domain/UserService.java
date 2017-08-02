package ua.com.pb.photopay.infrastructure.domain;

import ua.com.pb.photopay.infrastructure.models.Application;
import ua.com.pb.photopay.infrastructure.models.User;
import ua.com.pb.photopay.infrastructure.viewmodels.user.UserAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.user.UserForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.user.UserForView;
import java.util.*;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface UserService extends BaseService<UserForSave, UserAsListItem, UserForView, Integer> {

    /**
     * Checks whether user has admin role
     * @param ldap
     * @return true if is, else is not
     */
    boolean isAdmin(String ldap);


    /**
     * Checks whether user has accounter role
     * @param ldap
     * @return true if is, else is not
     */
    boolean isAccounter(String ldap);

    /**
     * Checks whether user has access to resource
     * @param ldap
     * @return true - user has, otherwise fasle
     */
    boolean hasAccess(String ldap);


    /**
     * Defines whether user can read application
     * @param ldap
     * @param application
     * @return true if can else not
     */
    boolean canRead(String ldap, Application application);

    /**
     * Defines whether user can save application
     * @param ldap
     * @return true if can else not
     */
    boolean canWrite(String ldap);
    /**
     * Defines whether user can save specific application
     * @param ldap
     * @param application
     * @return true if can else not
     */
    boolean canWrite(String ldap, Application application);

    /**
     * Get user from current session
     * @return User that logged
     */
    User getCurrent();

    /**
     * Create user
     * @param ldap
     * @return
     */
    Long create(String ldap);

    /**
     * Save user from map of parameters
     * @param userParareters
     * @return
     */
    User create(Map<String, String> userParareters);

    /**
     * Add specific roles to user
     * @param user
     */
    void makeGuest(User user);
    void makeModerator(User user);
    void makeAccounter(User user);
    void makeAdmin(User user);
    void makeManager(User user);

    /**
     * Delete user role
     * @param user
     */
    void unmakeModerator(User user);
    void unmakeAccounter(User user);
    void unmakeAdmin(User user);
    void unmakeManager(User user);
    void unmakeGuest(User user);

    /**
     * Save changes with user
     * @param user
     */
    void saveTransactions(User user);

    /**
     * Find user by ldap
     * @param ldap
     * @return
     */
    User find(String ldap);

    /**
     * Find user by email
     * @param email
     * @return
     */
    User findByEmail(String email);



}
