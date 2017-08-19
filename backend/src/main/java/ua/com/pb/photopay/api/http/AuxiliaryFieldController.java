package ua.com.pb.photopay.api.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.pb.photopay.domain.services.basemodel.AuxiliaryFieldTypeService;
import ua.com.pb.photopay.infrastructure.domain.AuxiliaryFieldService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldForView;
import ua.com.pb.photopay.infrastructure.viewmodels.baseModel.BaseModelForView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dn110592kvo on 11.08.2017.
 */
@RestController
@RequestMapping(value = "/auxiliary-field")
public class AuxiliaryFieldController {

    @Autowired
    AuxiliaryFieldTypeService fieldTypeService;

    @Autowired
    AuxiliaryFieldService fieldService;

    @RequestMapping(value = "/types/all", method = RequestMethod.GET, produces = "application/json")
    public List<BaseModelForView> getAllFieldTypes() {
        return fieldTypeService.getAll();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<AuxiliaryFieldForView> getAllFields() {
        return fieldService.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public int save(@RequestBody AuxiliaryFieldForSave fieldForSave) throws EntityNotFoundException, CanNotCreateEntityException, InvalidDataException, EntityAlreadyExistsException, UsesForbiddenChannelException {
        return fieldService.save(fieldForSave);
    }

    @RequestMapping(value = "/search/{pattern}", method = RequestMethod.GET, produces = "application/json")
    public List<AuxiliaryFieldForView> searchFields(@PathVariable String pattern) {
        return fieldService
                .findAll()
                .stream()
                .filter(i -> i.getName().toLowerCase().startsWith(pattern.trim().toLowerCase())).collect(Collectors.toList());
    }



}
