package ua.com.pb.photopay.domain.services;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.config.FilePathConfig;
import ua.com.pb.photopay.config.ImageConvertConfig;
import ua.com.pb.photopay.dao.repositories.ServiceGroupRepository;
import ua.com.pb.photopay.domain.utils.normalizer.NameNormalizer;
import ua.com.pb.photopay.domain.utils.validator.Validator;
import ua.com.pb.photopay.infrastructure.domain.ImageSaveService;
import ua.com.pb.photopay.infrastructure.domain.ServiceGroupService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.mappers.ServiceGroupMapper;
import ua.com.pb.photopay.infrastructure.models.ServiceGroup;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForView;

import java.nio.file.Path;
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

    @Autowired
    private ImageSaveService imageSaveService;

    @Autowired
    private ImageConvertConfig imageConvertConfig;

    @Autowired
    private FilePathConfig filePathConfig;


    @Override
    public int save(ServiceGroupForSave serviceGroup, MultipartFile file) throws EntityAlreadyExistsException, InvalidDataException, CanNotCreateEntityException {
        if (file != null && !file.isEmpty() && serviceGroup != null) {
            ServiceGroup newGroup;
            serviceGroup.setName(NameNormalizer.normalize(serviceGroup.getName()));
            String imageMime = "image/jpeg, image/png";
            String fileMime = file.getContentType().toLowerCase().trim();
            int serviceGroupAvatarSize = imageConvertConfig.getCategoryGroup();

            if (imageMime.contains(fileMime)) {

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

                if (!Validator.isValid(newGroup)) {
                    throw new InvalidDataException(ServiceGroup.class.getSimpleName(), Arrays.asList("Field 'name' is incorrect"));
                }

                Path path = imageSaveService.saveImage(file, filePathConfig.getResourcesPath(), true, serviceGroupAvatarSize);

                newGroup.setFilePath(path.toAbsolutePath().toString());
                newGroup.setFileHash(FilenameUtils.getBaseName(path.getFileName().toString()));
                return repository.save(newGroup).getId();

            }
            throw new InvalidDataException(ServiceGroup.class.getSimpleName(), Arrays.asList("File type"));
        }
        throw new CanNotCreateEntityException(ServiceGroup.class.getSimpleName());
    }


    @Override
    public ServiceGroup find(int id) {
        return repository.findById(id).get();
    }


    @Override
    public ServiceGroupForView find(Integer id) throws EntityNotFoundException {
        if (id != null) {
            ServiceGroup group = repository.findById(id).get();
            if (group != null) {
                return ServiceGroupMapper.mapView(group);
            }
        }
        throw new EntityNotFoundException(ServiceGroup.class.getSimpleName());
    }


    @Override
    public List<ServiceGroupForView> findAll() {
        return repository.findAll().stream().map(s -> ServiceGroupMapper.mapView(s)).collect(Collectors.toList());
    }


    @Override
    public Integer save(ServiceGroupForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

}
