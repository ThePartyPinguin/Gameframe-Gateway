package gateway.auth;


import gateway.dao.IAuthService;
import gateway.model.entity.TokenCheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;

@Service
@RequestScope
public class TokenService {

    @Autowired
    private IAuthService authService;

    private TokenCheckResponse checkToken(HttpServletRequest request){


        String bearerToken = request.getHeader("authorization");
        System.out.println("Auth header Bearer token: " + bearerToken);

        if(bearerToken == null)
            return new TokenCheckResponse(false, "No auth header found", 403);

        if (!(bearerToken.startsWith("Bearer ") || bearerToken.startsWith("Bearer "))) {
            return new TokenCheckResponse(false, "Auth header not in valid format, should be '[Bearer or bearer] [token]'", 403);
        }

        String token = bearerToken.substring(7);

        return this.authService.validateToken(token);
    }

}
