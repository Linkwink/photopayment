package ua.com.pb.photopay.domain.services;

import org.springframework.stereotype.Service;
import ua.com.pb.photopay.infrastructure.domain.AuxiliaryFieldService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldForView;

import java.util.List;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Service
public class AuxiliaryFieldServiceImp implements AuxiliaryFieldService {


    @Override
    public AuxiliaryFieldForView find(Integer integer) throws EntityNotFoundException {
        return null;
    }

    @Override
    public List<AuxiliaryFieldAsListItem> findAll() {
        return null;
    }

    @Override
    public Integer save(AuxiliaryFieldForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
