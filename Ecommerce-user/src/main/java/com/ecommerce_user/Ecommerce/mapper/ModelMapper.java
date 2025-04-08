package com.ecommerce_user.Ecommerce.mapper;

import com.ecommerce_user.Ecommerce.dto.request.UserDto;
import com.ecommerce_user.Ecommerce.entity.User;

public class ModelMapper {
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        userDto.setGender(user.getGender());
        return userDto;
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setGender(userDto.getGender());
        return user;
    }
}
