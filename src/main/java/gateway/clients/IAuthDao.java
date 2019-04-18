package gateway.clients;


import gateway.model.dto.token.TokenValidateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gameframe-auth-service")
public interface IAuthDao {

    @RequestMapping(value = "internal/token/{token}")
    TokenValidateResponse validateToken(@PathVariable String token);

}
