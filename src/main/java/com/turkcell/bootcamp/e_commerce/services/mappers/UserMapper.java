package com.turkcell.bootcamp.e_commerce.services.mappers;

import com.turkcell.bootcamp.e_commerce.entities.User;
import com.turkcell.bootcamp.e_commerce.services.dtos.user.requests.AddUserRequest;
import org.mapstruct.factory.Mappers;

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User userFromAddUserRequest(AddUserRequest request);
}
