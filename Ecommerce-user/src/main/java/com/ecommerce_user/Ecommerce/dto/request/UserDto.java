package com.ecommerce_user.Ecommerce.dto.request;

import com.ecommerce_user.Ecommerce.constant.Gender;
import com.ecommerce_user.Ecommerce.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Gender gender;
    private Address address;
}
