package gateway.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import gateway.auth.TokenService;
import gateway.model.TokenCheckResponse;
import gateway.model.dto.token.TokenValidateResponse;
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

        String uri = ctx.getRequest().getRequestURI();

        if(uri.contains("/public"))
            return false;

        boolean hasAutHeader = request.getHeader("Authorization") != null;

        if(hasAutHeader)
            return true;

        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletRequest request = ctx.getRequest();


        TokenValidateResponse response = this.tokenService.checkToken(request);

        if(!response.isValid()){
            setFailedRequest(ctx, response.getResponseMessage(), 401);
            return null;
        }
        else{
            ctx.addZuulResponseHeader("access-control-expose-headers", "x-user-token");
            ctx.addZuulResponseHeader("x-user-token", "Bearer " + response.getToken());
            ctx.addZuulRequestHeader("X-user-id", response.getUserId() + "");
        }
        return null;
    }

    private void setFailedRequest(RequestContext context, String body, int code) {

        context.setResponseStatusCode(code);
        if (context.getResponseBody() == null) {
            context.setResponseBody(body);
            context.setResponseStatusCode(code);
            context.setSendZuulResponse(false);
        }
    }
}
