package ua.com.pb.photopay.infrastructure.domain;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.infrastructure.exceptions.CanNotCreateEntityException;
import ua.com.pb.photopay.infrastructure.exceptions.EntityAlreadyExistsException;
import ua.com.pb.photopay.infrastructure.exceptions.InvalidDataException;
import ua.com.pb.photopay.infrastructure.models.ServiceGroup;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForView;

import java.io.IOException;

/**
 * Created by dn110592kvo on 08.08.2017.
 */
public interface ServiceGroupService extends BaseService<ServiceGroupForSave, ServiceGroupForView, ServiceGroupForView, Integer> {
    int save(ServiceGroupForSave service, MultipartFile file) throws EntityAlreadyExistsException, InvalidDataException, CanNotCreateEntityException;
    ServiceGroup find(int id);
}
