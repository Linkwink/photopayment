package ua.com.pb.photopay.infrastructure.mappers;

import ua.com.pb.photopay.infrastructure.models.ServiceGroup;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup.ServiceGroupForView;

/**
 * Created by Viacheslav_Khromoi on 09.08.2017.
 */
public class ServiceGroupMapper {

    public static ServiceGroupForView mapView(ServiceGroup serviceGroup) {
         return new ServiceGroupForView(serviceGroup.getId(), serviceGroup.getName(), String.format("/category/avatar/%s", serviceGroup.getFileHash()));
    }
}
