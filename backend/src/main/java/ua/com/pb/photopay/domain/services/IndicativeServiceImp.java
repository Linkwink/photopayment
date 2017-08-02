package ua.com.pb.photopay.domain.services;

import org.springframework.stereotype.Service;
import ua.com.pb.photopay.infrastructure.domain.IndicativeService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.models.Branch;
import ua.com.pb.photopay.infrastructure.models.ServiceType;
import ua.com.pb.photopay.infrastructure.viewmodels.indicative.IndicativeAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.indicative.IndicativeForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.indicative.IndicativeForView;

import java.util.List;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Service
public class IndicativeServiceImp implements IndicativeService {
    @Override
    public boolean checkIndicative(ServiceType type, Branch branch, float amountOfPayment) throws IndicativeNotFoundException {
        return false;
    }

    @Override
    public IndicativeForView find(Integer integer) throws EntityNotFoundException {
        return null;
    }

    @Override
    public List<IndicativeAsListItem> findAll() {
        return null;
    }

    @Override
    public Integer save(IndicativeForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
