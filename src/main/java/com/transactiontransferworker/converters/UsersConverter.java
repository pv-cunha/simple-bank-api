package com.transactiontransferworker.converters;

import com.transactiontransferworker.api.dtos.UserDTO;
import com.transactiontransferworker.repository.models.User;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {

    public User convertToUserModel(UserDTO userDTO) {
        User user = new User();

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setDocument(userDTO.getCPF());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUserType(userDTO.getUserType());

        return user;
    }
}
