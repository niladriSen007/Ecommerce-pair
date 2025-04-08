package com.ecommerce_user.Ecommerce.controllers;

import com.ecommerce_user.Ecommerce.clients.ProductFeignClient;
import com.ecommerce_user.Ecommerce.dto.request.UserDto;
import com.ecommerce_user.Ecommerce.service.IuserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class UserController {

    private final IuserService userService;
    private final ProductFeignClient productFeignClient;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/getAllProducts")
    public String getAllProducts() {
        return productFeignClient.getAllProducts();
    }

    @GetMapping("/getAll")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();

        boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        String databaseSource = isReadOnly ? "replica" : "primary";

        Map<String, Object> response = new HashMap<>();
        response.put("data", users);
        response.put("database_source", databaseSource);

        return ResponseEntity.ok(response);
    }
}
