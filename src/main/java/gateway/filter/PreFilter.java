package gateway.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import gateway.auth.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;


import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;

public class PreFilter extends ZuulFilter {

    @Autowired
    private TokenService tokenService;


    private static Logger log = LoggerFactory.getLogger(PreFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {

        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {

        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletRequest request = ctx.getRequest();

        log.info(request.getHeader("Authorization"));

        return request.getHeader("Authorization") != null;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletRequest request = ctx.getRequest();




//        log.info("inside pre filter: " + request.getPathInfo());


//        System.out.println("Inside pre filter");



        return null;
    }

    private void setFailedRequest(RequestContext context, String body, int code) {
        log.debug("Reporting error ({}): {}", code, body);

        context.setResponseStatusCode(code);
        if (context.getResponseBody() == null) {
            context.setResponseBody(body);
            context.setSendZuulResponse(false);
        }
    }
}
