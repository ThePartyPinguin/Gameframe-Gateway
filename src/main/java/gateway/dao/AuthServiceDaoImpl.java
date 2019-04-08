package gateway.dao;

import gateway.model.TokenCheckResponse;
import gateway.model.dto.UserLoginData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthServiceDaoImpl implements IAuthDao {

    private String authServiceUrl = "http://localhost:8070/internal/token";

    @Override
    public boolean validateToken(String token) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity(authServiceUrl + '/' + token, Boolean.class);

        if(responseEntity.getBody() == null)
            return false;

        return responseEntity.getBody();
    }
}
