package com.QuickAuth.mapper;

import com.QuickAuth.DTOs.UserDTO;
import com.QuickAuth.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDto(User user);

    User toEntity(UserDTO userDTO);
}
