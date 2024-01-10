package com.transactiontransferworker.api.controllers;

import com.transactiontransferworker.api.dtos.ResponseDTO;
import com.transactiontransferworker.api.dtos.UserCreatedDTO;
import com.transactiontransferworker.api.dtos.UserDTO;
import com.transactiontransferworker.api.messages.APIMessages;
import com.transactiontransferworker.business.object.UserBO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private APIMessages apiMessages;

    @Mock
    private UserBO userBO;

    @Test
    public void shouldBeAbleToCreateANewUser() {
        UserDTO userDTO = new UserDTO();
        UserCreatedDTO userCreatedDTO = new UserCreatedDTO();

        when(userBO.create(any())).thenReturn(userCreatedDTO);

        ResponseDTO<UserCreatedDTO> newUser = userController.createNewUser(userDTO);

        assertNotNull(newUser);
    }

}