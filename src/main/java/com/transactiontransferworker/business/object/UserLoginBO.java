package com.transactiontransferworker.business.object;

import com.transactiontransferworker.api.dtos.UserLoginDTO;
import com.transactiontransferworker.api.dtos.UserTokenDTO;
import com.transactiontransferworker.business.service.JwtBS;
import com.transactiontransferworker.business.service.UserBS;
import com.transactiontransferworker.exceptions.UserNotFoundException;
import com.transactiontransferworker.repository.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginBO {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtBS jwtBS;

    @Autowired
    private UserBS userBS;

    public UserTokenDTO login(UserLoginDTO userLoginDTO) {
        User user = userBS.getByDocument(userLoginDTO.getDocument());

        boolean passwordMatches = passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword());

        if (!passwordMatches) {
            throw new UserNotFoundException();
        }

        String generatedToken = jwtBS.generateToken(user);

        return new UserTokenDTO(generatedToken);
    }

}
