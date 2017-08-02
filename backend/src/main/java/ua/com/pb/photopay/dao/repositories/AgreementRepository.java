package ua.com.pb.photopay.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.pb.photopay.infrastructure.models.Agreement;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface AgreementRepository extends JpaRepository<Agreement,Integer> {
}
