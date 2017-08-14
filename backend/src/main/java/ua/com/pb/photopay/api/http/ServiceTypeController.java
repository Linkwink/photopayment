package ua.com.pb.photopay.api.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.infrastructure.domain.ServiceTypeService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeForView;

import java.io.IOException;
import java.util.List;

/**
 * Created by Viacheslav_Khromoi on 12.08.2017.
 */
@RestController
@RequestMapping(value = "/service-type")
public class ServiceTypeController {

    @Autowired
    ServiceTypeService service;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET, produces = "application/json")
    public List<ServiceTypeForView> getAll(@PathVariable Integer id) {
        return service.findAllByCategory(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json")
    public int save(@RequestPart("avatar") MultipartFile avatar, @RequestPart("serviceType") String serviceType) throws InvalidDataException, EntityAlreadyExistsException, CanNotCreateEntityException, UsesForbiddenChannelException, EntityNotFoundException, IOException {
        ServiceTypeForSave serviceTypeForSave = objectMapper.readValue(serviceType, ServiceTypeForSave.class);
        return service.save(serviceTypeForSave, avatar);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ServiceTypeForView findOne(@PathVariable Integer id) throws EntityNotFoundException {
        return service.find(id);
    }

}
