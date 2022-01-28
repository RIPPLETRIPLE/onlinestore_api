package com.example.api.service;

import com.example.api.entity.DTO.UserDTO;
import com.example.api.entity.User;
import com.example.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(UserDTO userDTO) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User user = User.createUser(userDTO.getLogin(), encoder.encode(userDTO.getPassword()), User.Role.User, User.UserStatus.Unblocked);

        userRepository.save(user);
    }

    public boolean existsUser(String login) {
        return userRepository.existsUserByLogin(login);
    }
}
