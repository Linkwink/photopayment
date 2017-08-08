package ua.com.pb.photopay.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.dao.repositories.ServiceGroupRepository;
import ua.com.pb.photopay.domain.utils.normalizer.NameNormalizer;
import ua.com.pb.photopay.domain.utils.validator.Validator;
import ua.com.pb.photopay.infrastructure.domain.BaseModelService;
import ua.com.pb.photopay.infrastructure.domain.ServiceGroupService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.mappers.BaseModelMapper;
import ua.com.pb.photopay.infrastructure.models.ServiceGroup;
import ua.com.pb.photopay.infrastructure.viewmodels.baseModel.BaseModelForView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by dn110592kvo on 08.08.2017.
 */
@Service
public class ServiceGroupServiceImp implements ServiceGroupService {

    @Autowired
    private ServiceGroupRepository repository;

    @Override
    public int save(ServiceGroup serviceGroup, MultipartFile file) throws EntityAlreadyExistsException, InvalidDataException {
        ServiceGroup newGroup = null;
        serviceGroup.setName(NameNormalizer.normalize(serviceGroup.getName()));
        Optional<ServiceGroup> group = repository.findById(serviceGroup.getId());
        ServiceGroup groupWithSameName = repository.findByName(serviceGroup.getName());
        if (groupWithSameName != null) {
            throw new EntityAlreadyExistsException(ServiceGroup.class.getSimpleName());
        } else if (group.isPresent()) {
            newGroup = group.get();
            newGroup.setName(serviceGroup.getName());
        } else {
            newGroup = new ServiceGroup(serviceGroup.getName());
        }
        if ( ! Validator.isValid(newGroup)) {
            throw new InvalidDataException(ServiceGroup.class.getSimpleName(), Arrays.asList("name"));
        }
        return repository.save(newGroup).getId();
    }

    @Override
    public BaseModelForView find(Integer integer) throws EntityNotFoundException {
        return null;
    }

    @Override
    public List<BaseModelForView> findAll() {
        return repository.findAll().stream().map(s -> BaseModelMapper.map(s)).collect(Collectors.toList());
    }

    @Override
    public Integer save(BaseModelForView newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Integer integer) {
    }
}
