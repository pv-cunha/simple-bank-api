package com.transactiontransferworker.converters;

import com.transactiontransferworker.api.dtos.UserCreateDTO;
import com.transactiontransferworker.api.dtos.UserDTO;
import com.transactiontransferworker.repository.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class UsersConverter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User convertToUser(UserDTO userDTO) {
        User user = new User();

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setDocument(userDTO.getDocument());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setBalance(Optional.ofNullable(userDTO.getBalance()).orElse(new BigDecimal("0")));
        user.setUserType(userDTO.getUserType());

        return user;
    }

    public UserCreateDTO convertToUserCreateDTO(UserDTO userDTO) {
        UserCreateDTO userCreateDTO = new UserCreateDTO();

        userCreateDTO.setFirstName(userDTO.getFirstName());
        userCreateDTO.setLastName(userDTO.getLastName());
        userCreateDTO.setDocument(userDTO.getDocument());
        userCreateDTO.setEmail(userDTO.getEmail());

        return userCreateDTO;
    }

}
