package ua.com.pb.photopay.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.pb.photopay.dao.repositories.AuxiliaryFieldRepository;
import ua.com.pb.photopay.domain.services.basemodel.AuxiliaryFieldTypeService;
import ua.com.pb.photopay.domain.utils.normalizer.NameNormalizer;
import ua.com.pb.photopay.domain.utils.validator.Validator;
import ua.com.pb.photopay.infrastructure.domain.AuxiliaryFieldService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.mappers.AuxiliaryFieldMapper;
import ua.com.pb.photopay.infrastructure.mappers.BaseModelMapper;
import ua.com.pb.photopay.infrastructure.models.AuxiliaryField;
import ua.com.pb.photopay.infrastructure.models.AuxiliaryFieldType;
import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldForView;
import ua.com.pb.photopay.infrastructure.viewmodels.baseModel.BaseModelForView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Service
public class AuxiliaryFieldServiceImp implements AuxiliaryFieldService {

    @Autowired
    AuxiliaryFieldRepository repository;

    @Autowired
    AuxiliaryFieldTypeService fieldTypeService;

    @Override
    public AuxiliaryFieldForView find(Integer id) throws EntityNotFoundException {
        if (id != null) {
            AuxiliaryField auxiliaryField = repository.findById(id).get();
            if (auxiliaryField != null) {
                return AuxiliaryFieldMapper.mapView(auxiliaryField);
            }
        }
        throw new EntityNotFoundException(AuxiliaryField.class.getSimpleName());
    }

    @Override
    public AuxiliaryField find(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<AuxiliaryFieldForView> findAll() {
        return repository.findAll().stream().map(s -> AuxiliaryFieldMapper.mapView(s)).collect(Collectors.toList());
    }


    @Override
    public Integer save(AuxiliaryFieldForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        if (newEntity != null) {
            AuxiliaryField newAuxiliaryField;
            newEntity.setName(NameNormalizer.normalize(newEntity.getName()));
            Optional<AuxiliaryField> auxiliaryField = repository.findById(newEntity.getId());
            AuxiliaryField auxiliaryFieldWithSameName = repository.findByName(newEntity.getName());
            BaseModelForView auxiliaryFieldType = fieldTypeService.getOne(newEntity.getFieldTypeId());

            if (auxiliaryFieldType == null) {
                throw new EntityNotFoundException(AuxiliaryFieldType.class.getSimpleName());
            }

            if (auxiliaryFieldWithSameName != null) {
                throw new EntityAlreadyExistsException(AuxiliaryField.class.getSimpleName());
            } else if (auxiliaryField.isPresent()) {
                newAuxiliaryField = auxiliaryField.get();
                newAuxiliaryField.setName(newEntity.getName());
                newAuxiliaryField.setFieldType(BaseModelMapper.map(auxiliaryFieldType, AuxiliaryFieldType.class));
            } else {
                newAuxiliaryField = new AuxiliaryField(newEntity.getName(), BaseModelMapper.map(auxiliaryFieldType, AuxiliaryFieldType.class));
            }

            if (!Validator.isValid(newAuxiliaryField)) {
                throw new InvalidDataException(AuxiliaryField.class.getSimpleName(), Arrays.asList("Field 'name' is incorrect"));
            }

            return repository.save(newAuxiliaryField).getId();
        }
        throw new CanNotCreateEntityException(AuxiliaryField.class.getSimpleName());
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public boolean isExist(int id) {
        return repository.existsById(id);
    }
}
