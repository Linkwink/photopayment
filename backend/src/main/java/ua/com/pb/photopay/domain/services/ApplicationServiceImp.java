package ua.com.pb.photopay.domain.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.pb.photopay.infrastructure.domain.ApplicationService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.models.Application;
import ua.com.pb.photopay.infrastructure.models.ApplicationStatus;
import ua.com.pb.photopay.infrastructure.models.Note;
import ua.com.pb.photopay.infrastructure.models.User;
import ua.com.pb.photopay.infrastructure.viewmodels.application.ApplicationAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.application.ApplicationForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.application.ApplicationForView;

import java.util.List;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Service
public class ApplicationServiceImp implements ApplicationService {

    @Override
    public Page<Application> findAllByUserWithPeageble(User user, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Application> findAllWithPeageble(Pageable pageable) {
        return null;
    }

    @Override
    public void changeStatus(ApplicationStatus status, User user) {

    }

    @Override
    public void setNote(Note note) {

    }

    @Override
    public ApplicationForView find(Integer integer) throws EntityNotFoundException {
        return null;
    }

    @Override
    public List<ApplicationAsListItem> findAll() {
        return null;
    }

    @Override
    public Integer save(ApplicationForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
