package com.transactiontransferworker.api.controllers;

import com.transactiontransferworker.api.dtos.ResponseDefaultDTO;
import com.transactiontransferworker.api.dtos.UserLoginDTO;
import com.transactiontransferworker.api.dtos.UserTokenDTO;
import com.transactiontransferworker.api.messages.APIMessages;
import com.transactiontransferworker.business.object.UserAuthBO;
import com.transactiontransferworker.utils.Constants;
import com.transactiontransferworker.utils.PathConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = PathConstants.PATH_TRANSACTION_TRANSFER_WORKER_AUTHENTICATION)
public class AuthenticationController {

    @Autowired
    private APIMessages apiMessages;

    @Autowired
    private UserAuthBO userAuthBO;

    @PostMapping(PathConstants.PATH_POST_AUTHENTICATION_LOGIN)
    public @ResponseBody ResponseDefaultDTO<UserTokenDTO> login(@RequestBody UserLoginDTO userLoginDTO) {

        UserTokenDTO userTokenDTO = userAuthBO.login(userLoginDTO);

        return ResponseDefaultDTO.success(apiMessages.getSuccessFullMessage(), Constants.SUCCESS_CODE, userTokenDTO);
    }

}
