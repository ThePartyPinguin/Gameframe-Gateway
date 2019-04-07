package gateway.dao;

import gateway.model.entity.TokenCheckResponse;

public interface IAuthService {

    TokenCheckResponse validateToken(String token);

}
