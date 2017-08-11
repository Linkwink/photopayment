package ua.com.pb.photopay.domain.services;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.config.FilePathConfig;
import ua.com.pb.photopay.config.ImageConvertConfig;
import ua.com.pb.photopay.dao.repositories.ServiceGroupRepository;
import ua.com.pb.photopay.domain.utils.hashizer.HashGenerator;
import ua.com.pb.photopay.domain.utils.imageconverter.ImageConverter;
import ua.com.pb.photopay.domain.utils.normalizer.NameNormalizer;
import ua.com.pb.photopay.domain.utils.validator.Validator;
import ua.com.pb.photopay.infrastructure.constants.Constants;
import ua.com.pb.photopay.infrastructure.domain.ServiceGroupService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.mappers.BaseModelMapper;
import ua.com.pb.photopay.infrastructure.mappers.ServiceGroupMapper;
import ua.com.pb.photopay.infrastructure.models.ServiceGroup;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForView;

import javax.activation.FileTypeMap;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

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

    @Autowired
    private ImageConvertConfig imageConvertConfig;


    @Override
    public int save(ServiceGroupForSave serviceGroup, MultipartFile file) throws EntityAlreadyExistsException, InvalidDataException, CanNotCreateEntityException {
        if (file != null && !file.isEmpty() && serviceGroup != null) {
                ServiceGroup newGroup;
                serviceGroup.setName(NameNormalizer.normalize(serviceGroup.getName()));
                String ext = "";
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

                    try {
                        ImageConverter imageConverter = new ImageConverter(serviceGroupAvatarSize);

                        Path dir = Paths.get(getResourcePath());
                        if (!Files.exists(dir)) {
                            Files.createDirectories(dir);
                        }

                        Path path = imageConverter.apply(file.getInputStream());

                        if (path != null) {
                           path = Files.move(path, dir.resolve(path.getFileName()), REPLACE_EXISTING );
                        }
                        newGroup.setFilePath( path.toAbsolutePath().toString());
                        newGroup.setFileHash(FilenameUtils.getBaseName(path.getFileName().toString()));
                        return repository.save(newGroup).getId();
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new InvalidDataException(ServiceGroup.class.getSimpleName(), Arrays.asList("file error"));
                    }
                }
                throw new InvalidDataException(ServiceGroup.class.getSimpleName(), Arrays.asList("file type"));
            }
        throw new CanNotCreateEntityException(ServiceGroup.class.getSimpleName());
    }

    @Override
    public ResponseEntity<byte[]> getAvatar(String hash) throws IOException {
        if (hash != null) {
            Path dir = Paths.get(String.format("%s/%s.PNG", getResourcePath(), hash));
                File file = new File(dir.toAbsolutePath().toString());
                return ResponseEntity
                        .ok()
                        .lastModified(file.lastModified())
                        .header("max-age", "84600")
                        .cacheControl(CacheControl.maxAge(30, TimeUnit.HOURS).cachePublic())
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(Files.readAllBytes(file.toPath()));
            }
        return null;
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

    private String getResourcePath() {
        return String.format("%s/%s",filePathConfig.getResourcesPath(), ServiceGroup.class.getSimpleName());
    }
}
