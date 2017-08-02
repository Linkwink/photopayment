package ua.com.pb.photopay.infrastructure.domain;

import ua.com.pb.photopay.infrastructure.exceptions.IndicativeNotFoundException;
import ua.com.pb.photopay.infrastructure.models.Branch;
import ua.com.pb.photopay.infrastructure.models.ServiceType;
import ua.com.pb.photopay.infrastructure.viewmodels.indicative.IndicativeAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.indicative.IndicativeForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.indicative.IndicativeForView;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface IndicativeService extends BaseService<IndicativeForSave, IndicativeAsListItem, IndicativeForView, Integer> {

    boolean checkIndicative(ServiceType type, Branch branch, float amountOfPayment) throws IndicativeNotFoundException;

}
