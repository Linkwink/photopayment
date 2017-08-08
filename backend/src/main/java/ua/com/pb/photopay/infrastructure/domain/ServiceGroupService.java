package ua.com.pb.photopay.infrastructure.domain;

import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.infrastructure.exceptions.EntityAlreadyExistsException;
import ua.com.pb.photopay.infrastructure.exceptions.InvalidDataException;
import ua.com.pb.photopay.infrastructure.models.ServiceGroup;
import ua.com.pb.photopay.infrastructure.viewmodels.baseModel.BaseModelForView;

/**
 * Created by dn110592kvo on 08.08.2017.
 */
public interface ServiceGroupService extends BaseService<BaseModelForView, BaseModelForView, BaseModelForView, Integer> {
    int save(ServiceGroup service, MultipartFile file) throws EntityAlreadyExistsException, InvalidDataException;

}
