package com.gametracker.userauth.services;

import com.gametracker.userauth.dtos.UserDTO;
import com.gametracker.userauth.models.User;
import com.gametracker.userauth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO createUser(User user) {
        User userCreated = userRepository.save(user);
        return new UserDTO(userCreated.getLogin(), userCreated.getEmail(), userCreated.getName());
    }

    public Optional<UserDTO> findByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(this::convertToDTO);
    }

    public Optional<UserDTO> findByLogin(String login){
        Optional<User> user = userRepository.findByLogin(login);
        return user.map(this::convertToDTO);
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getLogin(), user.getEmail(), user.getName());
    }
}
