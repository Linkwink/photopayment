package ua.com.pb.photopay.infrastructure.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.com.pb.photopay.infrastructure.models.Application;
import ua.com.pb.photopay.infrastructure.models.User;
import ua.com.pb.photopay.infrastructure.viewmodels.log.LogAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.log.LogForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.log.LogForView;

import java.util.Collection;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface LogService extends BaseService<LogForSave, LogAsListItem, LogForView, Integer> {

    /**
     * Gets unread logs for user with peageble
     * @param pageable
     * @return
     */
    Page<LogForView> findUnreadLogWithPeageble(Pageable pageable);

    /**
     * Deletes read and old logs
     */
    void deleteOld();

    /**
     * Creates log entry
     * @param application that caused logging
     * @param c Class in which logging occurred
     * @param action action that was made
     */
    void create(Application application, User user, Class c, String action);

    Long read(long id);
}
