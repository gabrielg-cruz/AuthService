package com.QuickAuth.service;

import com.QuickAuth.DTOs.UserDTO;
import com.QuickAuth.interfaces.IUserServices;
import com.QuickAuth.mapper.UserMapper;
import com.QuickAuth.models.User;
import com.QuickAuth.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServices  implements IUserServices {

    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toEntity(userDTO);
        User createdUser = userRepository.save(user);
        return UserMapper.INSTANCE.toDto(createdUser);
    }

    @Override
    public UserDTO getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.INSTANCE.toDto(user);
    }

    @Override
    public User findUserEntityById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
    
}
