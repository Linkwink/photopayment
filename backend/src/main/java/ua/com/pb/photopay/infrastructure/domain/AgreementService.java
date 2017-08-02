package ua.com.pb.photopay.infrastructure.domain;

import ua.com.pb.photopay.infrastructure.models.Agreement;
import ua.com.pb.photopay.infrastructure.models.Branch;
import ua.com.pb.photopay.infrastructure.viewmodels.agreement.AgreementAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.agreement.AgreementForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.agreement.AgreementForView;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface AgreementService extends BaseService<AgreementForSave, AgreementAsListItem, AgreementForView, Integer> {
    /**
     * Find all agreements by branch
     * @param branch
     * @return
     */
    Agreement findAllByBranch(Branch branch);

}
