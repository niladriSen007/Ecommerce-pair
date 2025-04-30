package com.Ecommerce_api_gateway.Ecommerce_Api_Gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggingSpecificRouteFilter extends AbstractGatewayFilterFactory<LoggingSpecificRouteFilter.Config> {

    public LoggingSpecificRouteFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Pre-processing logic
            log.info("Pre-filter: Request URI is {}", exchange.getRequest().getURI());
            log.info("Pre-filter: Request Path is {}", exchange.getRequest().getPath());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                // Post-processing logic
                System.out.println("Post-filter: Response status code is " + exchange.getResponse().getStatusCode());
            }));
        };
    }

    public static class Config {

    }
}
