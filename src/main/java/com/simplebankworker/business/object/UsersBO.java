package com.simplebankworker.business.object;

import com.simplebankworker.api.vo.UserVO;
import com.simplebankworker.business.service.UsersBS;
import com.simplebankworker.converters.UsersConverter;
import com.simplebankworker.repository.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersBO {

    @Autowired
    private UsersBS usersBS;

    @Autowired
    private UsersConverter usersConverter;

    public void createNewUser(UserVO userVO) {
        User user = usersConverter.convertToUserModel(userVO);

        usersBS.createNewUser(user);
    }
}
