package ua.com.pb.photopay.domain.services;

import org.springframework.stereotype.Service;
import ua.com.pb.photopay.infrastructure.domain.ServiceTypeService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeForView;

import java.util.List;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Service
public class ServiceTypeServiceImp implements ServiceTypeService {
    @Override
    public ServiceTypeForView find(Integer integer) throws EntityNotFoundException {
        return null;
    }

    @Override
    public List<ServiceTypeAsListItem> findAll() {
        return null;
    }

    @Override
    public Integer save(ServiceTypeForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
