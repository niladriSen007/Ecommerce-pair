package com.ecommerce_user.Ecommerce.service;

import com.ecommerce_user.Ecommerce.dto.request.UserDto;
import com.ecommerce_user.Ecommerce.entity.User;
import com.ecommerce_user.Ecommerce.mapper.ModelMapper;
import com.ecommerce_user.Ecommerce.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IuserService {
    private final UserRepo userRepo;


    @Override
    @Transactional
    public String createUser(UserDto userDto) {
        User savedUser = userRepo.save(ModelMapper.mapToUser(userDto));
        return "User Created Successfully";
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(ModelMapper::mapToUserDto).toList();
    }
}
