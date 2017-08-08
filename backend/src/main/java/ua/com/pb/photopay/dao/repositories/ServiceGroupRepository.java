package ua.com.pb.photopay.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.pb.photopay.infrastructure.models.ServiceGroup;

/**
 * Created by dn110592kvo on 08.08.2017.
 */
public interface ServiceGroupRepository extends JpaRepository<ServiceGroup, Integer>{
    ServiceGroup findByName(String name);
}
