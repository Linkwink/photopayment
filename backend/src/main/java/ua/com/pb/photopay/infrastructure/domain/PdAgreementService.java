package ua.com.pb.photopay.infrastructure.domain;

import ua.com.pb.photopay.infrastructure.exceptions.EntityAlreadyExistsException;
import ua.com.pb.photopay.infrastructure.models.PdAgreement;
import ua.com.pb.photopay.infrastructure.viewmodels.pdAgreement.PdAgreementAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.pdAgreement.PdAgreementForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.pdAgreement.PdAgreementForView;

import java.util.Set;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface PdAgreementService extends BaseService<PdAgreementForSave, PdAgreementAsListItem, PdAgreementForView, Integer> {

    /**
     * Get all privat dogovor agreements by application agreement
     * @param agreementId
     * @return
     * @throws EntityAlreadyExistsException
     */
    Set<PdAgreement> getAllPdAgreementsByAgreement(int agreementId) throws EntityAlreadyExistsException;
}
