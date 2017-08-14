package ua.com.pb.photopay.domain.services;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.config.FilePathConfig;
import ua.com.pb.photopay.config.ImageConvertConfig;
import ua.com.pb.photopay.dao.repositories.ServiceTypeRepository;
import ua.com.pb.photopay.domain.utils.normalizer.NameNormalizer;
import ua.com.pb.photopay.domain.utils.validator.Validator;
import ua.com.pb.photopay.infrastructure.domain.AuxiliaryFieldService;
import ua.com.pb.photopay.infrastructure.domain.ImageSaveService;
import ua.com.pb.photopay.infrastructure.domain.ServiceGroupService;
import ua.com.pb.photopay.infrastructure.domain.ServiceTypeService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.mappers.ServiceTypeMapper;
import ua.com.pb.photopay.infrastructure.models.AuxiliaryField;
import ua.com.pb.photopay.infrastructure.models.ServiceGroup;
import ua.com.pb.photopay.infrastructure.models.ServiceType;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeForView;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
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

    @Autowired
    private ImageConvertConfig imageConvertConfig;

    @Autowired
    private ImageSaveService imageSaveService;

    @Autowired
    private FilePathConfig filePathConfig;


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
        return repository.findAll().stream().map(s -> ServiceTypeMapper.mapView(s)).collect(Collectors.toList());
    }

    @Override
    public List<ServiceTypeForView> findAllByCategory(int id) {
        return repository.findAllByServiceGroup(serviceGroupService.find(id)).stream().map(s-> ServiceTypeMapper.mapView(s)).collect(Collectors.toList());
    }

    @Override
    public Integer save(ServiceTypeForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public int save(ServiceTypeForSave newEntity, MultipartFile file) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        if (newEntity != null) {

            newEntity.setName(NameNormalizer.normalize(newEntity.getName()));
            newEntity.setServiceNomenklature(NameNormalizer.normalize(newEntity.getServiceNomenklature()));
            ServiceType serviceType = repository.findById(newEntity.getId()).get();
            ServiceType serviceTypeWithSameName = repository.findByName(newEntity.getName());

            ServiceGroup serviceGroup = serviceGroupService.find(newEntity.getServiceGroupId());

            if (serviceGroup == null) {
                throw new EntityNotFoundException(ServiceGroup.class.getSimpleName());
            }
            if (newEntity.getServiceNomenklature() == null) {
                throw new EntityNotFoundException(ServiceType.class.getSimpleName());
            }

            if (serviceTypeWithSameName != null) {
                throw new EntityAlreadyExistsException(ServiceType.class.getSimpleName());
            } else if (serviceType == null) {
                serviceType = new ServiceType();
            }

            serviceType.setName(newEntity.getName());
            serviceType.setServiceNomenklature(newEntity.getServiceNomenklature());
            serviceType.setServiceGroup(serviceGroup);

            if (newEntity.getAuxiliaryFields() != null) {
                serviceType.setAuxiliaryFields(
                        newEntity.getAuxiliaryFields().stream()
                                .filter(af -> auxiliaryFieldService.isExist(af.getId()))
                                .map(af -> auxiliaryFieldService.find(af.getId()))
                                .collect(Collectors.toSet()));
            } else {
                throw new EntityNotFoundException(AuxiliaryField.class.getSimpleName());
            }

            if (file != null && !file.isEmpty()) {
                String imageMime = "image/jpeg, image/png";
                String fileMime = file.getContentType().toLowerCase().trim();
                int serviceGroupAvatarSize = imageConvertConfig.getCategoryGroup();

                if (imageMime.contains(fileMime)) {
                    Path path = imageSaveService.saveImage(file, filePathConfig.getResourcesPath(), true, serviceGroupAvatarSize);
                    serviceType.setFileHash(FilenameUtils.getBaseName(path.getFileName().toString()));
                    serviceType.setFilePath(path.toAbsolutePath().toString());
                }
            }

            if (!Validator.isValid(serviceType)) {
                return repository.save(serviceType).getId();
            }

        }
        throw new CanNotCreateEntityException(ServiceType.class.getSimpleName());
    }

    @Override
    public void delete(Integer integer) {
    }




}
