package ua.com.pb.photopay.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.pb.photopay.dao.repositories.ServiceTypeRepository;
import ua.com.pb.photopay.domain.utils.normalizer.NameNormalizer;
import ua.com.pb.photopay.infrastructure.domain.AuxiliaryFieldService;
import ua.com.pb.photopay.infrastructure.domain.ServiceGroupService;
import ua.com.pb.photopay.infrastructure.domain.ServiceTypeService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.mappers.ServiceTypeMapper;
import ua.com.pb.photopay.infrastructure.models.AuxiliaryField;
import ua.com.pb.photopay.infrastructure.models.ServiceGroup;
import ua.com.pb.photopay.infrastructure.models.ServiceType;
import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForView;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeForView;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Service
public class ServiceTypeServiceImp implements ServiceTypeService {

    @Autowired
    ServiceTypeRepository repository;

    @Autowired
    ServiceGroupService serviceGroupService;

    @Autowired
    AuxiliaryFieldService auxiliaryFieldService;

    @Override
    public ServiceTypeForView find(Integer id) throws EntityNotFoundException {
        if (id != null) {
            ServiceType type = repository.findById(id).get();
            if (type != null) {
                return ServiceTypeMapper.mapView(type);
            }
        }
        throw new EntityNotFoundException(ServiceType.class.getSimpleName());
    }

    @Override
    public List<ServiceTypeForView> findAll() {
        return repository.findAll().stream().map(s-> ServiceTypeMapper.mapView(s)).collect(Collectors.toList());
    }

    @Override
    public Integer save(ServiceTypeForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        if (newEntity != null) {

            ServiceType newServiceType;
            newEntity.setName(NameNormalizer.normalize(newEntity.getName()));
            Optional<ServiceType> serviceType = repository.findById(newEntity.getId());
            ServiceType serviceTypeWithSameName = repository.findByName(newEntity.getName());
            Set<AuxiliaryFieldForSave> auxiliaryFields = newEntity.getAuxiliaryFields();

            ServiceGroupForView serviceGroup = serviceGroupService.find(newEntity.getServiceGroupId());

            if (serviceGroup == null) {
                throw new EntityNotFoundException(ServiceGroup.class.getSimpleName());
            }

            if (auxiliaryFields == null) {
                throw new EntityNotFoundException(AuxiliaryField.class.getSimpleName());
            }

            if (serviceTypeWithSameName != null) {
                throw new EntityAlreadyExistsException(ServiceType.class.getSimpleName());
            } else if (serviceType.isPresent()){
                newServiceType = serviceType.get();
                newServiceType.setName(newEntity.getName());
            }





        }
        throw new CanNotCreateEntityException(ServiceType.class.getSimpleName());
    }

    @Override
    public void delete(Integer integer) {

    }
}
