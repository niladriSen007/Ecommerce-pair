package com.Ecommerce_api_gateway.Ecommerce_Api_Gateway.filters;

import com.Ecommerce_api_gateway.Ecommerce_Api_Gateway.service.JwtService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
@Slf4j
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    private final JwtService jwtService;

    public AuthenticationFilter(JwtService jwtService) {
        super(Config.class);
        this.jwtService = jwtService;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {

            if(!config.isEnabled) return chain.filter(exchange);

            String authorizationHeader =
                    Objects.requireNonNull(exchange.getRequest().getHeaders().getFirst("Authorization"));
            if(!authorizationHeader.startsWith("Bearer ")){
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
            final String token = authorizationHeader.substring(7);

            if (jwtService.getUserIdFromToken(token) == null) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            Long userId = jwtService.getUserIdFromToken(token);

            exchange.getRequest().mutate().header("X-User-Id", String.valueOf(userId)).build();


            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("Post-filter: Response status code is {}", exchange.getResponse().getStatusCode());
            }));
        });
    }

    @Data
    public static class Config {
        private boolean isEnabled;
    }
}
