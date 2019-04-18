package gateway.auth;


import gateway.clients.IAuthDao;
import gateway.model.dto.token.TokenValidateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;

@Service
@RequestScope
public class TokenService {

    @Autowired
    private IAuthDao authService;

    public TokenValidateResponse checkToken(HttpServletRequest request){


        String bearerToken = request.getHeader("authorization");
        System.out.println("Auth header Bearer token: " + bearerToken);

        if(bearerToken == null)
            return new TokenValidateResponse("No auth header found", 403);

        if (!(bearerToken.startsWith("Bearer ") || bearerToken.startsWith("Bearer "))) {
            return new TokenValidateResponse("Auth header not in valid format, should be '[Bearer or bearer] [token]'", 403);
        }

        String token = bearerToken.substring(7);

        TokenValidateResponse response = this.authService.validateToken(token);

        if(!response.isValid())
            return new TokenValidateResponse("Token not valid please login again to get a new token", 401);

        return response;
    }

}
