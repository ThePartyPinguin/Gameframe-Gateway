package gateway.dao.jms;

import gateway.dao.IAuthService;
import gateway.model.entity.TokenCheckResponse;
import org.springframework.stereotype.Service;

@Service
public class JmsAuthCommunicator implements IAuthService {
    @Override
    public TokenCheckResponse validateToken(String token) {
        return null;
    }
}
