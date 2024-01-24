package com.transactiontransferworker.api.controllers;

import com.transactiontransferworker.api.dtos.ResponseDefaultDTO;
import com.transactiontransferworker.api.dtos.UserCreateDTO;
import com.transactiontransferworker.api.dtos.UserDTO;
import com.transactiontransferworker.api.messages.APIMessages;
import com.transactiontransferworker.business.object.UserBO;
import com.transactiontransferworker.utils.Constants;
import com.transactiontransferworker.utils.PathConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Tag(name = "Transaction Transfer User Controller", description = "Operation to create a new user.")
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = PathConstants.PATH_TRANSACTION_TRANSFER_WORKER_USER)
public class UserController {
    @Autowired
    private APIMessages apiMessages;
    @Autowired
    private UserBO userBO;
    @Operation(summary = "Create a new user.")
    @PostMapping(PathConstants.PATH_POST_CREATE_USER)
    public @ResponseBody ResponseDefaultDTO<UserCreateDTO> create(@RequestBody @Valid UserDTO userDTO) {

        UserCreateDTO userCreateDTO = userBO.create(userDTO);

        return ResponseDefaultDTO.success(apiMessages.getSuccessFullMessage(), Constants.SUCCESS_CODE, userCreateDTO);
    }

}
