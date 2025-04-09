package com.ecommerce_user.Ecommerce.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="Ecommerce-product",path="/products")
public interface ProductFeignClient {

    @GetMapping("/getAllProducts")
    public String getAllProducts();

    @GetMapping("/getProductById")
    public String getProductById(Long id);
}
