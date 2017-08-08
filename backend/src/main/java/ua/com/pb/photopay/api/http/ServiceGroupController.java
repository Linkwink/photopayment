package ua.com.pb.photopay.api.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.infrastructure.domain.BaseModelService;
import ua.com.pb.photopay.infrastructure.domain.ServiceGroupService;
import ua.com.pb.photopay.infrastructure.exceptions.EntityAlreadyExistsException;
import ua.com.pb.photopay.infrastructure.exceptions.InvalidDataException;
import ua.com.pb.photopay.infrastructure.models.ServiceGroup;
import ua.com.pb.photopay.infrastructure.viewmodels.baseModel.BaseModelForView;

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
    public List<BaseModelForView> getAll(){
        return service.findAll();
    }

    @RequestMapping(value= "/add", method = RequestMethod.POST, produces = "application/json")
    public int save(ServiceGroup serviceGroup, @RequestPart("avatar") MultipartFile avatar) throws InvalidDataException, EntityAlreadyExistsException {
        return service.save(serviceGroup, avatar);
    }

//    @RequestMapping(value = "/{id}",  method = RequestMethod.GET, produces = "application/json")
//    public BaseModelForView getOne(@PathVariable int id) {
//        return service.getOne(id);
//    }


}
