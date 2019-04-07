package gateway.dao.jms;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "TokenReturns", containerFactory = "authFactory")
    public void revceiveMessage(){

    }

}
