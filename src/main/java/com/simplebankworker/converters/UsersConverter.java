package com.simplebankworker.converters;

import com.simplebankworker.api.vo.UserVO;
import com.simplebankworker.repository.models.User;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {

    public User convertToUserModel(UserVO userVO) {
        User user = new User();

        user.setFirstName(userVO.getFirstName());
        user.setLastName(userVO.getLastName());
        user.setDocument(userVO.getCPF());
        user.setEmail(userVO.getEmail());
        user.setPassword(userVO.getPassword());
        user.setUserType(userVO.getUserType());

        return user;
    }
}
