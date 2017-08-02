package ua.com.pb.photopay.infrastructure.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.com.pb.photopay.infrastructure.models.Application;
import ua.com.pb.photopay.infrastructure.models.ApplicationStatus;
import ua.com.pb.photopay.infrastructure.models.Note;
import ua.com.pb.photopay.infrastructure.models.User;
import ua.com.pb.photopay.infrastructure.viewmodels.application.ApplicationAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.application.ApplicationForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.application.ApplicationForView;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface ApplicationService extends BaseService<ApplicationForSave, ApplicationAsListItem, ApplicationForView, Integer>{

    /**
     * Find all applications by user
     * @param user
     * @param pageable
     * @return
     */
     Page<Application> findAllByUserWithPeageble(User user, Pageable pageable);


    /**
     * Find all applications
     * @param pageable
     * @return
     */
    Page<Application> findAllWithPeageble(Pageable pageable);

    /**
     * Change status of application
     * @param status
     * @param user
     */
     void changeStatus(ApplicationStatus status, User user);

    /**
     * Set application note
     * @param note
     */
    void setNote(Note note);






}
