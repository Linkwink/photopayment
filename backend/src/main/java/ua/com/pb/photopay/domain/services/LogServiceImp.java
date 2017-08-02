package ua.com.pb.photopay.domain.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.pb.photopay.infrastructure.domain.LogService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.models.Application;
import ua.com.pb.photopay.infrastructure.models.User;
import ua.com.pb.photopay.infrastructure.viewmodels.log.LogAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.log.LogForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.log.LogForView;

import java.util.Collection;
import java.util.List;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Service
public class LogServiceImp implements LogService {

    @Override
    public Page<LogForView> findUnreadLogWithPeageble(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteOld() {

    }

    @Override
    public void create(Application application, User user, Class c, String action) {

    }

    @Override
    public Long read(long id) {
        return null;
    }

    @Override
    public LogForView find(Integer integer) throws EntityNotFoundException {
        return null;
    }

    @Override
    public List<LogAsListItem> findAll() {
        return null;
    }

    @Override
    public Integer save(LogForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
