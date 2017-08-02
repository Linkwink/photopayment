package ua.com.pb.photopay.sercurity.auth;

/**
 * Created by fan.jin on 2016-11-12.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import ua.com.pb.photopay.infrastructure.exceptions.JsonException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fan.jin on 2016-11-07.
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        JsonException exception = new JsonException();
        exception.setCode(HttpServletResponse.SC_UNAUTHORIZED);
        exception.setMessage(authException.getMessage());
        String unathorizedResponse = objectMapper.writeValueAsString(exception);
        response.setContentType("application/json");
        response.getWriter().write(unathorizedResponse);

    }
}

