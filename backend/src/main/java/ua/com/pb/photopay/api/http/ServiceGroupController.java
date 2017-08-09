package ua.com.pb.photopay.api.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.infrastructure.domain.BaseModelService;
import ua.com.pb.photopay.infrastructure.domain.ServiceGroupService;
import ua.com.pb.photopay.infrastructure.exceptions.EntityAlreadyExistsException;
import ua.com.pb.photopay.infrastructure.exceptions.InvalidDataException;
import ua.com.pb.photopay.infrastructure.models.ServiceGroup;
import ua.com.pb.photopay.infrastructure.viewmodels.baseModel.BaseModelForView;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForView;

import java.io.IOException;
import java.util.List;

/**
 * Created by dn110592kvo on 08.08.2017.
 */
@RestController
@RequestMapping( value = "/category")
public class ServiceGroupController {

    @Autowired
    private ServiceGroupService service;


    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<ServiceGroupForView> getAll(){
        return service.findAll();
    }

    @RequestMapping(value= "/add", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json")
    public int save(@RequestPart("avatar") MultipartFile avatar, ServiceGroupForSave serviceGroup) throws InvalidDataException, EntityAlreadyExistsException {
        return service.save(serviceGroup, avatar);
    }

    @RequestMapping(value = "/avatar/{hash}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> getAvatar(@PathVariable String hash) throws IOException {
        return service.getAvatar(hash);
    }

//    @RequestMapping(value = "/{id}",  method = RequestMethod.GET, produces = "application/json")
//    public BaseModelForView getOne(@PathVariable int id) {
//        return service.getOne(id);
//    }


}
