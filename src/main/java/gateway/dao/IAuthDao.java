package gateway.dao;


import gateway.model.TokenCheckResponse;

public interface IAuthDao {

    boolean validateToken(String token);

}
