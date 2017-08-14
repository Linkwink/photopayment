package ua.com.pb.photopay.infrastructure.domain;

import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeForView;

import java.util.List;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface ServiceTypeService extends BaseService<ServiceTypeForSave, ServiceTypeForView, ServiceTypeForView, Integer> {

    int save(ServiceTypeForSave serviceType, MultipartFile file) throws EntityAlreadyExistsException, InvalidDataException, CanNotCreateEntityException, EntityNotFoundException, UsesForbiddenChannelException;

    List<ServiceTypeForView> findAllByCategory(int id);
}
