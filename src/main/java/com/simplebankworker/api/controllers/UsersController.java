package com.simplebankworker.api.controllers;

import com.simplebankworker.api.dto.ResponseDTO;
import com.simplebankworker.api.vo.UserVO;
import com.simplebankworker.business.object.UsersBO;
import com.simplebankworker.utils.PathConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = PathConstants.PATH_SIMPLE_BANK_USERS)
public class UsersController {

    @Autowired
    private UsersBO usersBO;
    @PostMapping(PathConstants.PATH_POST_CREATE_USER)
    public @ResponseBody ResponseDTO<Object> createNewUser(@RequestBody @Valid UserVO userVO) {
        usersBO.createNewUser(userVO);

        return ResponseDTO.success("User has been created !", "00", "ok");
    }
}
