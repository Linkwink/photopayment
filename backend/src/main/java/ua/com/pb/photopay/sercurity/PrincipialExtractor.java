package ua.com.pb.photopay.sercurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.FixedPrincipalExtractor;
import ua.com.pb.photopay.infrastructure.domain.UserService;
import ua.com.pb.photopay.infrastructure.models.User;

import java.util.Arrays;
import java.util.*;

/**
 * Created by dn110592kvo on 17.07.2017.
 */
public class PrincipialExtractor extends FixedPrincipalExtractor {

    private static final String[] PRINCIPAL_ID = new String[]{"userid", "user_id", "id"};
    private static final String[] PRINCIPAL_NAME = new String[]{"username", "login", "name"};
    private static final String[] PRINCIPAL_EMAIL = new String[]{"email", "e-mail"};
    private static final String[] PRINCIPAL_PICTURE = new String[]{"picture", "avatar"};

    @Autowired
    UserService userService;

    private boolean isExistKey(String[] keyArray, String keyToFind) {
        return Arrays.stream(keyArray).anyMatch(x -> x.equals(keyToFind));
    }


    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        User user = userService.find((String) map.get("id"));
        if (user == null) {
            User newUser = new User();
            map.entrySet().forEach(e -> {
                if (isExistKey(PRINCIPAL_ID, e.getKey())) newUser.setUsername((String) e.getValue());
                if (isExistKey(PRINCIPAL_NAME, e.getKey())) newUser.setName((String) e.getValue());
                if (isExistKey(PRINCIPAL_EMAIL, e.getKey())) newUser.setEmail((String) e.getValue());
                if (isExistKey(PRINCIPAL_PICTURE, e.getKey())) newUser.setPicture((String) e.getValue());
            });
            userService.makeAdmin(newUser);
//            userService.makeGuest(newUser);
            return newUser;
        }
        return user;
    }
}
