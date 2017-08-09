package ua.com.pb.photopay.domain.services;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.config.FilePathConfig;
import ua.com.pb.photopay.dao.repositories.ServiceGroupRepository;
import ua.com.pb.photopay.domain.utils.hashizer.HashGenerator;
import ua.com.pb.photopay.domain.utils.normalizer.NameNormalizer;
import ua.com.pb.photopay.domain.utils.validator.Validator;
import ua.com.pb.photopay.infrastructure.domain.ServiceGroupService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.models.ServiceGroup;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForView;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by dn110592kvo on 08.08.2017.
 */
@Service
public class ServiceGroupServiceImp implements ServiceGroupService {

    @Autowired
    private ServiceGroupRepository repository;

    @Autowired
    private FilePathConfig filePathConfig;

    @Autowired
    private ServletContext servletContext;

    @Override
    public int save(ServiceGroupForSave serviceGroup, MultipartFile file) throws EntityAlreadyExistsException, InvalidDataException {
        if (file != null && !file.isEmpty()) {
            if (serviceGroup != null) {
                ServiceGroup newGroup = null;
                serviceGroup.setName(NameNormalizer.normalize(serviceGroup.getName()));
                String ext = "";
                String imageMime = "image/jpeg, image/png";
                String fileMime = file.getContentType().toLowerCase().trim();
                String resourcesPath = filePathConfig.getResourcesPath();

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
                        throw new InvalidDataException(ServiceGroup.class.getSimpleName(), Arrays.asList("service group name"));
                    }

                    try {
                        Path dir = Paths.get(resourcesPath);
                        if (!Files.exists(dir)) {
                            Files.createDirectories(dir);
                        }
                        Path path = dir.resolve(file.getName() + String.valueOf(new Date().getTime()));
                        Files.copy(file.getInputStream(), path);
                        newGroup.setFilePath(path.toString());
                        newGroup.setFileHash(HashGenerator.getHash(file.getOriginalFilename()));
                        return repository.save(newGroup).getId();
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new InvalidDataException(ServiceGroup.class.getSimpleName(), Arrays.asList("file error"));
                    }
                }
                throw new InvalidDataException(ServiceGroup.class.getSimpleName(), Arrays.asList("file type"));
            }
            throw new InvalidDataException(ServiceGroup.class.getSimpleName(), Arrays.asList("service group"));
        }
        throw new InvalidDataException(ServiceGroup.class.getSimpleName(), Arrays.asList("file"));
    }

    @Override
    public ResponseEntity<byte[]> getAvatar(String hash) throws IOException {
        if (hash != null) {
            ServiceGroup group = repository.findByFileHash(hash);
            if (group != null) {

                ClassPathResource image = new ClassPathResource(group.getFilePath());
                byte[] bytes = IOUtils.toByteArray(image.getInputStream());
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(bytes);
            }

        }
        return null;
    }

    @Override
    public ServiceGroupForView find(Integer integer) throws EntityNotFoundException {
        return null;
    }

    @Override
    public List<ServiceGroupForView> findAll() {
        return null;
    }

    @Override
    public Integer save(ServiceGroupForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
