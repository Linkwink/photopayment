package ua.com.pb.photopay.domain.services;

import org.springframework.stereotype.Service;
import ua.com.pb.photopay.infrastructure.domain.AgreementService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.models.Agreement;
import ua.com.pb.photopay.infrastructure.models.Branch;
import ua.com.pb.photopay.infrastructure.viewmodels.agreement.AgreementAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.agreement.AgreementForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.agreement.AgreementForView;

import java.util.List;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Service
public class AgreementServiceImp implements AgreementService {


    @Override
    public Agreement findAllByBranch(Branch branch) {
        return null;
    }

    @Override
    public AgreementForView find(Integer integer) throws EntityNotFoundException {
        return null;
    }

    @Override
    public List<AgreementAsListItem> findAll() {
        return null;
    }

    @Override
    public Integer save(AgreementForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
