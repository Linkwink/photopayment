package ua.com.pb.photopay.api.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.infrastructure.domain.ServiceGroupService;
import ua.com.pb.photopay.infrastructure.exceptions.CanNotCreateEntityException;
import ua.com.pb.photopay.infrastructure.exceptions.EntityAlreadyExistsException;
import ua.com.pb.photopay.infrastructure.exceptions.EntityNotFoundException;
import ua.com.pb.photopay.infrastructure.exceptions.InvalidDataException;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForView;

import java.io.IOException;
import java.util.List;

/**
 * Created by dn110592kvo on 08.08.2017.
 */
@RestController
@RequestMapping(value = "/service-group")
public class ServiceGroupController {

    @Autowired
    private ServiceGroupService service;

    @Autowired
    private ObjectMapper objectMapper;


    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<ServiceGroupForView> getAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json")
    public int save(@RequestPart("avatar") MultipartFile avatar, @RequestPart("serviceGroup") String serviceGroup) throws InvalidDataException, EntityAlreadyExistsException, CanNotCreateEntityException, IOException {
        ServiceGroupForSave group = objectMapper.readValue(serviceGroup, ServiceGroupForSave.class);
        return service.save(group, avatar);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ServiceGroupForView findOne(@PathVariable Integer id) throws EntityNotFoundException {
        return service.find(id);
    }


}
