package ua.com.pb.photopay.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.pb.photopay.infrastructure.models.ServiceGroup;
import ua.com.pb.photopay.infrastructure.models.ServiceType;

import java.util.List;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
    ServiceType findByName(String name);
    List<ServiceType> findAllByServiceGroup(ServiceGroup serviceGroup);
}
