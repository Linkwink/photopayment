package ua.com.pb.photopay.domain.services.basemodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.pb.photopay.dao.repositories.AuxiliaryFieldTypeRepository;
import ua.com.pb.photopay.infrastructure.domain.BaseModelService;
import ua.com.pb.photopay.infrastructure.exceptions.EntityAlreadyExistsException;
import ua.com.pb.photopay.infrastructure.exceptions.InvalidDataException;
import ua.com.pb.photopay.infrastructure.mappers.BaseModelMapper;
import ua.com.pb.photopay.infrastructure.models.AuxiliaryFieldType;
import ua.com.pb.photopay.infrastructure.viewmodels.baseModel.BaseModelForView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by dn110592kvo on 11.08.2017.
 */
@Service
public class AuxiliaryFieldTypeService implements BaseModelService<AuxiliaryFieldType> {

    @Autowired
    AuxiliaryFieldTypeRepository repository;

    @Override
    public List<BaseModelForView> getAll() {
        return repository.findAll().stream().map(s -> BaseModelMapper.map(s)).collect(Collectors.toList());
    }

    @Override
    public int save(BaseModelForView model) throws InvalidDataException, EntityAlreadyExistsException {
        return 0;
    }

    @Override
    public BaseModelForView getOne(Integer id) {
        if (id != null) {
            Optional<AuxiliaryFieldType> auxiliaryFieldType = repository.findById(id);
            if (auxiliaryFieldType.isPresent()) {
                return BaseModelMapper.map(auxiliaryFieldType.get());
            }
        }
        return null;
    }
}
