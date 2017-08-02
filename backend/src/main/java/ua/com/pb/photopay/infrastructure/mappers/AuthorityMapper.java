package ua.com.pb.photopay.infrastructure.mappers;

import ua.com.pb.photopay.infrastructure.models.User;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dn110592kvo on 12.07.2017.
 */
public class AuthorityMapper {
    public static Set<String> mapView(User user) {
        if (user != null) {
            return user.getAuthorities().stream().map(role -> role.getName()).collect(Collectors.toSet());
        }
        return null;
    }
}
