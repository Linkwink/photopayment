package ua.com.pb.photopay.infrastructure.mappers;

import ua.com.pb.photopay.infrastructure.models.ServiceType;
import ua.com.pb.photopay.infrastructure.viewmodels.serviceType.ServiceTypeForView;

import java.util.stream.Collectors;

/**
 * Created by dn110592kvo on 11.08.2017.
 */
public class ServiceTypeMapper {

    public static ServiceTypeForView mapView(ServiceType serviceType) {
        return new ServiceTypeForView(
                serviceType.getId(),
                serviceType.getName(),
                serviceType.getAuxiliaryFields().stream().map(s -> AuxiliaryFieldMapper.mapView(s)).collect(Collectors.toSet()),
                serviceType.getServiceGroup().getId(),
                serviceType.getServiceNomenklature(),
                String.format("/images/avatar/%s",  serviceType.getFileHash()));
    }
}
