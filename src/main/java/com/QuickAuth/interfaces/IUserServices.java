package com.QuickAuth.interfaces;

import com.QuickAuth.DTOs.UserDTO;
import com.QuickAuth.models.User;

public interface IUserServices {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(int id);
    void    deleteUser(int id);
    User    findUserEntityById(int id);
}
