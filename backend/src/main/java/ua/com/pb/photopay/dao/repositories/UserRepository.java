package ua.com.pb.photopay.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.pb.photopay.infrastructure.models.User;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailIgnoreCase(String email);
    User findByUsernameIgnoreCase(String ldap);

}
