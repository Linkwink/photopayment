package ua.com.pb.photopay.domain.services;

import org.springframework.stereotype.Service;
import ua.com.pb.photopay.infrastructure.domain.PdAgreementService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.models.PdAgreement;
import ua.com.pb.photopay.infrastructure.viewmodels.pdAgreement.PdAgreementAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.pdAgreement.PdAgreementForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.pdAgreement.PdAgreementForView;

import java.util.List;
import java.util.Set;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Service
public class PdAgreementServiceImp implements PdAgreementService {
    @Override
    public Set<PdAgreement> getAllPdAgreementsByAgreement(int agreementId) throws EntityAlreadyExistsException {
        return null;
    }

    @Override
    public PdAgreementForView find(Integer integer) throws EntityNotFoundException {
        return null;
    }

    @Override
    public List<PdAgreementAsListItem> findAll() {
        return null;
    }

    @Override
    public Integer save(PdAgreementForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
