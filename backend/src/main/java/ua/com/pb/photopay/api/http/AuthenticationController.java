package ua.com.pb.photopay.api.http;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.pb.photopay.infrastructure.exceptions.JsonException;
import ua.com.pb.photopay.infrastructure.mappers.UserMapper;
import ua.com.pb.photopay.infrastructure.models.User;
import ua.com.pb.photopay.infrastructure.models.UserTokenState;
import ua.com.pb.photopay.infrastructure.viewmodels.user.UserForView;
import ua.com.pb.photopay.sercurity.TokenHelper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fan.jin on 2017-05-10.
 */

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    ObjectMapper objectMapper;

    @Value("${jwt.expires_in}")
    private int EXPIRES_IN;

    @Value("${jwt.cookie}")
    private String TOKEN_COOKIE;

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request, HttpServletResponse response) {

        String authToken = tokenHelper.getToken(request);
        if (authToken != null && tokenHelper.canTokenBeRefreshed(authToken)) {
            // TODO check user password last update
            String refreshedToken = tokenHelper.refreshToken(authToken);

            Cookie authCookie = new Cookie(TOKEN_COOKIE, (refreshedToken));
            authCookie.setPath("/");
            authCookie.setHttpOnly(true);
            authCookie.setMaxAge(EXPIRES_IN);
            // Add cookie to response
            response.addCookie(authCookie);

            UserTokenState userTokenState = new UserTokenState(refreshedToken, EXPIRES_IN);
            return ResponseEntity.ok(userTokenState);
        } else {
            UserTokenState userTokenState = new UserTokenState();
            return ResponseEntity.accepted().body(userTokenState);
        }
    }


    @RequestMapping(value = "/me")
    public Object user(HttpServletResponse response) throws IOException {
        UserForView user = UserMapper.mapView((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if (user != null) {
            return user;
        } else {
            String errorResponse = objectMapper.writeValueAsString(new JsonException(HttpServletResponse.SC_UNAUTHORIZED, "Authorization required"));
            response.getWriter().write(errorResponse);
        }
        return null;
    }


}