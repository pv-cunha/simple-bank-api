package com.transactiontransferworker.api.controllers;

import com.transactiontransferworker.api.dtos.ResponseDefaultDTO;
import com.transactiontransferworker.api.dtos.UserCreateDTO;
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
        UserCreateDTO userCreateDTO = new UserCreateDTO();

        when(userBO.create(any())).thenReturn(userCreateDTO);

        ResponseDefaultDTO<UserCreateDTO> newUser = userController.create(userDTO);

        assertNotNull(newUser);
    }

}