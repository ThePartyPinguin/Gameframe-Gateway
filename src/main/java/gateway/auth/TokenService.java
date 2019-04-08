package gateway.auth;


import gateway.dao.IAuthDao;
import gateway.model.TokenCheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;

@Service
@RequestScope
public class TokenService {

    @Autowired
    private IAuthDao authService;

    public TokenCheckResponse checkToken(HttpServletRequest request){


        String bearerToken = request.getHeader("authorization");
        System.out.println("Auth header Bearer token: " + bearerToken);

        if(bearerToken == null)
            return new TokenCheckResponse(false, "No auth header found", 403);

        if (!(bearerToken.startsWith("Bearer ") || bearerToken.startsWith("Bearer "))) {
            return new TokenCheckResponse(false, "Auth header not in valid format, should be '[Bearer or bearer] [token]'", 403);
        }

        String token = bearerToken.substring(7);

        boolean valid = this.authService.validateToken(token);

        if(!valid)
            return new TokenCheckResponse(false, "Token not valid please login again to get a new token", 401);

        return new TokenCheckResponse(true, "Valid token", 200);
    }

}
