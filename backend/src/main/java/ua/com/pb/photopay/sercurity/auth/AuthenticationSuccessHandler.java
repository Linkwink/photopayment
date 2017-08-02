package ua.com.pb.photopay.sercurity.auth;

/**
 * Created by fan.jin on 2016-11-07.
 */


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ua.com.pb.photopay.infrastructure.models.User;
import ua.com.pb.photopay.infrastructure.models.UserTokenState;
import ua.com.pb.photopay.sercurity.TokenHelper;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Value("${jwt.expires_in}")
    private int EXPIRES_IN;

    @Value("${jwt.cookie}")
    private String TOKEN_COOKIE;

    @Value("${spring.application.user_cookie}")
    private String USER_COOKIE;

    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        clearAuthenticationAttributes(request);

        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();

        User user = (User) authentication.getPrincipal();

//        String jws = tokenHelper.generateToken(details.getTokenType() + "_" + details.getTokenValue() + "_" + user.getUsername());
        String jws = tokenHelper.generateToken(user.getUsername());

        // Create token auth Cookie
        Cookie authCookie = new Cookie(TOKEN_COOKIE, (jws));
        authCookie.setPath("/");
        authCookie.setDomain("");
        authCookie.setHttpOnly(true);
        authCookie.setMaxAge(EXPIRES_IN);
        // Create flag Cookie
        Cookie userCookie = new Cookie(USER_COOKIE, (user.getUsername()));
        userCookie.setPath("/");
        userCookie.setDomain("");
        userCookie.setMaxAge(EXPIRES_IN);
        // Add cookie to response
        response.addCookie(authCookie);
        response.addCookie(userCookie);
        redirectStrategy.sendRedirect(request,response,"http://localhost:3000");
    }


}
