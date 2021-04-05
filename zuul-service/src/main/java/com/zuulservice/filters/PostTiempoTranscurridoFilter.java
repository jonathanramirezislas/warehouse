package com.zuulservice.filters;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("Entrando a post filter");

        Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");//get tiempo inicio
        Long tiempoFinal = System.currentTimeMillis(); //currentime
        Long tiempoTranscurrido = tiempoFinal - tiempoInicio; //elapsed time

        log.info(String.format("Tiempo transcurrido en segundos %s seg.", tiempoTranscurrido.doubleValue()/1000.00));
        log.info(String.format("Tiempo transcurrido en mileseg %s ms.", tiempoTranscurrido));
        return null;
    }

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

}
