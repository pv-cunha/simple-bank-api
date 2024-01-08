package com.transactiontransferworker.api.controllers;

import com.transactiontransferworker.api.dtos.ResponseDTO;
import com.transactiontransferworker.api.messages.APIMessages;
import com.transactiontransferworker.api.dtos.UserDTO;
import com.transactiontransferworker.business.object.UserBO;
import com.transactiontransferworker.utils.PathConstants;
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
public class UserController {
    @Autowired
    private APIMessages APIMessages;
    @Autowired
    private UserBO userBO;

    @PostMapping(PathConstants.PATH_POST_CREATE_USER)
    public @ResponseBody ResponseDTO<Object> createNewUser(@RequestBody @Valid UserDTO userDTO) {
        userBO.create(userDTO);

        return ResponseDTO.success(APIMessages.getSuccessFullMessage(), "00", "ok");
    }
}
