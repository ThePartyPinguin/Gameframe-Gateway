package gateway;

import gateway.filter.ErrorFilter;
import gateway.filter.PostFilter;
import gateway.filter.PreFilter;
import gateway.filter.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
@EnableEurekaClient
public class GameFrameZuulGateWay extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(GameFrameZuulGateWay.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(GameFrameZuulGateWay.class, args);
    }




}
