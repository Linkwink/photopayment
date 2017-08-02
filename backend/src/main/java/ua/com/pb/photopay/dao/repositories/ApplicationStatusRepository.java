package ua.com.pb.photopay.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.pb.photopay.infrastructure.models.ApplicationStatus;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface ApplicationStatusRepository extends JpaRepository<ApplicationStatus, Integer> {
}
