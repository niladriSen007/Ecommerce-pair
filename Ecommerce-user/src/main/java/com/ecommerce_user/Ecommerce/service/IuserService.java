package com.ecommerce_user.Ecommerce.service;

import com.ecommerce_user.Ecommerce.dto.request.UserDto;

import java.util.List;

public interface IuserService {
    String createUser(UserDto userDto);
    List<UserDto> getAllUsers();
}
