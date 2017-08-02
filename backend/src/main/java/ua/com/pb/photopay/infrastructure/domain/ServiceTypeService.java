package ua.com.pb.photopay.infrastructure.domain;

import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeForView;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface ServiceTypeService extends BaseService<ServiceTypeForSave, ServiceTypeAsListItem, ServiceTypeForView, Integer> {
}
