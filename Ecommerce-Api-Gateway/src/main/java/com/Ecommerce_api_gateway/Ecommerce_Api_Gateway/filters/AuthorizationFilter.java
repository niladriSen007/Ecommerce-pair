package com.Ecommerce_api_gateway.Ecommerce_Api_Gateway.filters;

import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorizationFilter extends AbstractGatewayFilterFactory<AuthorizationFilter.Config> {
    public AuthorizationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Implement your authorization logic here
            // For example, check if the user has the required role or permission

            // If authorized, proceed with the request
            return chain.filter(exchange);
        };
    }

    @Data
    public static class Config {
        private List<String> allowedRoles;
    }
}
