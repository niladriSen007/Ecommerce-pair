package com.ecommerce_user.Ecommerce.service;

import com.ecommerce_user.Ecommerce.dto.request.UserDto;
import com.ecommerce_user.Ecommerce.entity.User;
import com.ecommerce_user.Ecommerce.mapper.ModelMapper;
import com.ecommerce_user.Ecommerce.repository.UserRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IuserService {
    private final UserRepo userRepo;


    @Override
//    @Retry(name = "UserCreationRetry", fallbackMethod = "createUserFallback")
    @CircuitBreaker(name = "UserCreationCircuitBreaker", fallbackMethod = "createUserFallback")
    @RateLimiter(name = "UserCreationRateLimiter", fallbackMethod = "createUserFallback")
    @Transactional
    public String createUser(UserDto userDto) {
        User savedUser = userRepo.save(ModelMapper.mapToUser(userDto));
        return "User Created Successfully";
    }

    public String createUserFallback(UserDto userDto, Exception e) {
        log.info("Fallback occured due to", e.getMessage());
        return "User Creation Failed. Please try again later.";
    }


    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(ModelMapper::mapToUserDto).toList();
    }
}
