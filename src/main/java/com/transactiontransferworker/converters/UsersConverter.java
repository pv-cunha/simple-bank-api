package com.transactiontransferworker.converters;

import com.transactiontransferworker.api.dtos.UserCreatedDTO;
import com.transactiontransferworker.api.dtos.UserDTO;
import com.transactiontransferworker.repository.models.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class UsersConverter {

    public User convertToUserModel(UserDTO userDTO) {
        User user = new User();

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setDocument(userDTO.getDocument());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setBalance(Optional.ofNullable(userDTO.getBalance()).orElse(new BigDecimal("0")));
        user.setUserType(userDTO.getUserType());

        return user;
    }

    public UserCreatedDTO convertToUserCreatedDTO(UserDTO userDTO) {
        UserCreatedDTO userCreatedDTO = new UserCreatedDTO();

        userCreatedDTO.setFirstName(userDTO.getFirstName());
        userCreatedDTO.setLastName(userDTO.getLastName());
        userCreatedDTO.setDocument(userDTO.getDocument());
        userCreatedDTO.setEmail(userDTO.getEmail());

        return userCreatedDTO;
    }
}
