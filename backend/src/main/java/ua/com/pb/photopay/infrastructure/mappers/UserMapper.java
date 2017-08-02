package ua.com.pb.photopay.infrastructure.mappers;

import ua.com.pb.photopay.infrastructure.models.User;
import ua.com.pb.photopay.infrastructure.viewmodels.user.UserForView;

/**
 * Created by dn110592kvo on 10.07.2017.
 */
public class UserMapper {

    public static UserForView mapView(User user) {
        if (user != null) {
            return new UserForView(user.getId(), user.getName(), user.getUsername(),null, AuthorityMapper.mapView(user), user.getEmail(),user.getPicture());
        }
        return null;
    }

}
